package cn.edu.zust.se.controller;

import cn.edu.zust.se.dto.UserDto;
import cn.edu.zust.se.entity.User;
import cn.edu.zust.se.entity.Vacation;
import cn.edu.zust.se.service.VacationServiceI;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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

//    @RequestMapping(value = "/list", method = )
//    public String stateList() {
//        if (session.getAttribute("user") == null) return "login";
//        return "vacationList";
//    }

    @RequestMapping(value = "/list", method = {RequestMethod.POST, RequestMethod.GET})
    public String stateList(Model model) {
        UserDto user = (UserDto) session.getAttribute("user");
        if (user == null) return "login";
        List<Vacation> vacation = new ArrayList<>();
        if (user.getUserType().equals(2)) {
            vacation = vacationService.getVacationListById(user.getUserNum());
        } else {
            vacation = vacationService.getVacationListByDepId(user.getCollegeNum());
        }
        model.addAttribute("vacations", vacation);
        return "vacationList";
    }

    //??????????????????
    @RequestMapping(value = "/request", method = RequestMethod.POST)
    public String request(Vacation vacation, HttpServletRequest request) {
        UserDto userDto = (UserDto) session.getAttribute("user");
        if (userDto == null) return "login";
        if (!userDto.getUserType().equals(2)) return "redirect:/user/userHome";
        String reason = vacation.getReason();
        String startTime = vacation.getStartTime();
        String endTime = vacation.getEndTime();
        String transport = vacation.getWay();
        System.out.println(vacation.toString());
        if (!isGoodString(reason) || !isGoodString(startTime) || !isGoodString(endTime) || !isGoodString(transport)) {
            request.setAttribute("message", "?????????????????????");
            return "forward:/vacation/list";
        }
        else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            if (!vacationService.submitVacationRequest(user, vacation).equals(0)) return "redirect:/vacation/list";
            else {
                request.setAttribute("message", "?????????????????????");
                return "forward:/vacation/list";
            }
        }
    }

    //??????????????????
    @RequestMapping("/revoke")
    public String revoke(String userNum, Integer vacationNum, HttpServletRequest request) {
        UserDto user = (UserDto) session.getAttribute("user");
        if (user == null) return "login";
        if (vacationService.revokeRequest(userNum, vacationNum).equals(0))
            request.setAttribute("message", "????????????????????????????????????");
        return "redirect:/vacation/list";
    }

    //????????????
    @RequestMapping("/operate")
    public String operate(Integer vacationNum, Integer operation) {
        UserDto user = (UserDto) session.getAttribute("user");
        if (user == null) return "login";
        if (user.getUserType().equals(2)) return "forward:/vacation/list";
        if (user.getUserType().equals(0)) return "redirect:/user/userHome";
        else {
            vacationService.performDecision(vacationNum, operation);
            return "forward:/vacation/list";
        }
    }

}
