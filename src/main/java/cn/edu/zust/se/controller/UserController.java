package cn.edu.zust.se.controller;

import cn.edu.zust.se.entity.User;
import cn.edu.zust.se.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserServiceI userService;

    @Autowired
    public void setUserService(UserServiceI userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/listUser", method = RequestMethod.GET)
    public String listUser(HttpServletRequest request) {
        List<User> list = userService.getAll();
        request.setAttribute("userList", list);
        return "home";
    }
}
