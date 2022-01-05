package cn.edu.zust.se.controller;

import cn.edu.zust.se.service.StateServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/state")
public class StateController {
    private StateServiceI stateService;

    private HttpSession session;

    @Autowired
    public void setSession(HttpSession session) {
        this.session = session;
    }

    @Autowired
    public void setStateService(StateServiceI stateService) {
        this.stateService = stateService;
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String stateList() {
        if (session.getAttribute("user") == null) return "login";
        return "stateList";
    }

    @RequestMapping(value = "/request", method = RequestMethod.GET)
    public String stateRequest() {
        if (session.getAttribute("user") == null) return "login";
        return "stateRequest";
    }
}