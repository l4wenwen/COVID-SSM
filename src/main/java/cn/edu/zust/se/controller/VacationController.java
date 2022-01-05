package cn.edu.zust.se.controller;

import cn.edu.zust.se.service.VacationServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/vacation")
public class VacationController {
    private VacationServiceI vacationService;

    private HttpSession session;

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
}
