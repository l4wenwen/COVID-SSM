package cn.edu.zust.se.controller;

import cn.edu.zust.se.dto.Result;
import cn.edu.zust.se.dto.StateDto;
import cn.edu.zust.se.dto.UserDto;
import cn.edu.zust.se.entity.State;
import cn.edu.zust.se.entity.User;
import cn.edu.zust.se.service.StateServiceI;
import cn.edu.zust.se.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public String stateList(String startTime, String endTime, Model model) {
        UserDto user = (UserDto) session.getAttribute("user");
        List<StateDto> states = stateService.getStateByTime(startTime, endTime,
                            user.getUserType(), user.getCollegeNum(), user.getUserNum()).getData();
        model.addAttribute(states);
        return "stateList";
    }

    @RequestMapping(value = "/request", method = RequestMethod.GET)
    public String stateRequest() {
        if (session.getAttribute("user") == null) return "login";
        return "stateRequest";
    }

    @RequestMapping(value = "/request", method = RequestMethod.POST)
    public String stateRequest(State state) {
        if (session.getAttribute("user") == null) return "login";
        UserDto user = (UserDto) session.getAttribute("user");
        state.setUserNum(user.getUserNum());
        state.setStateTime(TimeUtil.getDate());
        stateService.delState(TimeUtil.getDate(), user.getUserNum());
        stateService.addState(state);
        return "stateSuccess";
    }

    @RequestMapping(value = "/getstate", method = {RequestMethod.GET, RequestMethod.POST})
    public String getState(Model model) {
        UserDto user = (UserDto) session.getAttribute("user");
        if (user == null) return "login";
        model.addAttribute("state", stateService.getUserState(user.getUserNum(), TimeUtil.getDate()).getData());
        return "forward:/user/userHome";
    }
}
