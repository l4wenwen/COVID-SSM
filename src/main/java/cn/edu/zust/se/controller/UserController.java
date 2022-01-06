package cn.edu.zust.se.controller;

import cn.edu.zust.se.dto.Result;
import cn.edu.zust.se.dto.UserDto;
import cn.edu.zust.se.entity.User;
import cn.edu.zust.se.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserServiceI userService;

    private HttpSession session;

    @Autowired
    public void setUserService(UserServiceI userService) {
        this.userService = userService;
    }

    @Autowired
    public void setSession(HttpSession session) {
        this.session = session;
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String userLogin() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userLogin(Model model, String userNum, String password) {
        Result<UserDto> result = userService.userLogin(userNum, password);
        System.out.println(result.toString());
        if (!result.isSuccess()) {
            model.addAttribute("error", result.getError());
            return "login";
        }
        session.setAttribute("user", result.getData());
        return "redirect:/user/userHome";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String userLogout() {
        session.invalidate();
        return "login";
    }

    @RequestMapping(value = "/userHome", method = RequestMethod.GET)
    public String userHome() {
        if (session.getAttribute("user") == null) return "login";
        return "userHome";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String userProfile(Model model) {
        UserDto user = (UserDto) session.getAttribute("user");
        if (user == null) return "login";
        model.addAttribute("userProfile", userService.getUserProfile(user.getUserNum()).getData());
        return "profile";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String userUpdate(Model model, String telephone) {
        UserDto user = (UserDto) session.getAttribute("user");
        if (user == null) return "login";
        Result<Boolean> result = userService.updateUserTelephone(telephone, user.getUserNum());
        if (!result.isSuccess()) model.addAttribute("error", result.getError());
        return "forward:/user/profile";
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<Boolean> userUpdate(Model model, String password, String repassword) {
        UserDto user = (UserDto) session.getAttribute("user");
        if (user == null) return null;
        return userService.updateUserPassword(password, repassword, user.getUserNum());
    }

    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    public String userManage() {
        if (session.getAttribute("user") == null) return "login";
        return "redirect:/user/userInfo";
    }

    @RequestMapping(value = "/userInfo", method = {RequestMethod.GET, RequestMethod.POST})
    public String userInfo(Model model) {
        if (session.getAttribute("user") == null) return "login";
        Integer studentNum = userService.getStudentNumber().getData();
        Integer teacherNum = userService.getTeacherNumber().getData();
        model.addAttribute("studentNum", studentNum);
        model.addAttribute("teacherNum", teacherNum);
        return "userManager";
    }

    @RequestMapping(value = "/teacherList", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<List<UserDto>> teacherList() {
        UserDto user = (UserDto) session.getAttribute("user");
        if (user == null || !user.getUserType().equals(0)) return null;
        return userService.getAllTeachers();
    }

    @RequestMapping(value = "/studentList", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<List<UserDto>> studentList(Model model) {
        UserDto user = (UserDto) session.getAttribute("user");
        if (user == null || user.getUserType().equals(2)) return null;
        if (user.getUserType() == 0)
            return userService.getAllStudents();
        else
            return userService.getAllStudentsByCollegeNum(user.getCollegeNum().toString());
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public String userAdd(User u) {
        UserDto user = (UserDto) session.getAttribute("user");
        if (user == null || !user.getUserType().equals(0)) return null;
        Result<String> result = userService.addUser(u);
        return result.getData();
    }
}
