package cn.edu.zust.se.controller;

import cn.edu.zust.se.dto.UserDto;
import cn.edu.zust.se.entity.User;
import cn.edu.zust.se.entity.Vacation;
import cn.edu.zust.se.service.VacationServiceI;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/vacation")
public class VacationController {
    @Autowired
    @Qualifier("vacationServiceImpl")
    private VacationServiceI vacationService;

    private HttpSession session;

    boolean isGoodString(String str) {
        return str != null && !"".equals(str.trim());
    }

    @Autowired
    public void setSession(HttpSession session) {
        this.session = session;
    }

    @Autowired
    public void setVacationService(VacationServiceI vacationService) {
        this.vacationService = vacationService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String stateList() {
        if (session.getAttribute("user") == null) return "login";
        return "vacationList";
    }

    //提交离校请求
    @RequestMapping(value = "/request", method = RequestMethod.POST)
    public String request(Vacation vacation, HttpServletRequest request) {
        UserDto userDto = (UserDto) session.getAttribute("user");
        if (userDto.getUserType() != 2) return "redirect:/user/userHome";
        String reason = vacation.getReason();
        String startTime = vacation.getStartTime();
        String endTime = vacation.getEndTime();
        String transport = vacation.getWay();
        if (!isGoodString(reason) || !isGoodString(startTime) || !isGoodString(endTime) || !isGoodString(transport)) {
            request.setAttribute("message", "输入不能为空。");
            return "forward:/vacation/list";
        }
        else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            if (vacationService.submitVacationRequest(user, vacation)) return "redirect:/vacation/list";
            else {
                request.setAttribute("message", "提交请求失败。");
                return "forward:/vacation/list";
            }
        }
    }

//    //用户撤销请求
//    @RequestMapping("/revoke/{userNum}/{vacationNum}")
//    public String revoke(@PathVariable("userNum") String uid, @PathVariable("vacationNum") int vid, HttpServletRequest request) {
//        if (!vacationService.revokeRequest(uid, vid))
//            request.setAttribute("message", "撤回失败，请求已经完成。");
//        return "redirect:/vacation/list";
//    }
//
    //处理请假
//    @RequestMapping("/operate/{vid}/{operation}")
//    public String operate(@PathVariable("vid") int vid, @PathVariable("operation") int operation) {
//        UserDto user = (UserDto) session.getAttribute("user");
//        if (user.getUserType() == 2) return "forward:/vacation/list";
//        if (user.getUserType() == 0) return "redirect:/user/userHome";
//        else {
//            vacationService.performDecision(vid, operation);
//            return "forward:/vacation/list";
//        }
//    }

}
