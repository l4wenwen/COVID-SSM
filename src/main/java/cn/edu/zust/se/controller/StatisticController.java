package cn.edu.zust.se.controller;

import cn.edu.zust.se.dto.Result;
import cn.edu.zust.se.dto.UserDto;
import cn.edu.zust.se.entity.College;
import cn.edu.zust.se.entity.Statistic;
import cn.edu.zust.se.service.StatisticServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/statistic")
public class StatisticController {
    private StatisticServiceI statisticService;

    private HttpSession session;

    @Autowired
    public void setSession(HttpSession session) {
        this.session = session;
    }

    @Autowired
    public void setStatisticService(StatisticServiceI statisticService) {
        this.statisticService = statisticService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String allStatistic(Model model) {
        UserDto user = (UserDto) session.getAttribute("user");
        if (user == null || user.getUserType() == 2) return "login";
        if (user.getUserType() == 0) {
            Statistic statistic = statisticService.getAllStatistic().getData();
            model.addAttribute("statistic", statistic);
        } else {
            Statistic statistic = statisticService.getAllStatisticByCollegeNum(user.getCollegeNum().toString()).getData();
            model.addAttribute("statistic", statistic);
        }
        return "forward:/user/userHome";
    }

    @RequestMapping(value = "/college", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public String collegeOption() {
        if (session.getAttribute("user") == null) return null;
        return statisticService.getAllColleges().getData();
    }

    @RequestMapping(value = "/major", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public String stateList(String collegeNum) {
        if (session.getAttribute("user") == null) return null;
        return statisticService.getMajorsByCollegeNum(collegeNum).getData();
    }

    @RequestMapping(value = "/studentList", method = {RequestMethod.POST, RequestMethod.GET}, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<List<UserDto>> studentList() {
        UserDto user = (UserDto) session.getAttribute("user");
        if (user == null || user.getUserType().equals(2)) return null;
        if (user.getUserType() == 0)
            return statisticService.getAllFilledStudents();
        else
            return statisticService.getAllFilledStudentsByCollegeNum(user.getCollegeNum().toString());
    }

    @RequestMapping(value = "/filled", method = {RequestMethod.POST, RequestMethod.GET}, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<List<UserDto>> filledStudentList() {
        UserDto user = (UserDto) session.getAttribute("user");
        if (user == null || user.getUserType().equals(2)) return null;
        if (user.getUserType() == 0)
            return statisticService.getAllFilledStudents();
        else
            return statisticService.getAllFilledStudentsByCollegeNum(user.getCollegeNum().toString());
    }

    @RequestMapping(value = "/highrisk", method = {RequestMethod.POST, RequestMethod.GET}, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<List<UserDto>> highRiskStudentList() {
        UserDto user = (UserDto) session.getAttribute("user");
        if (user == null || user.getUserType().equals(2)) return null;
        if (user.getUserType() == 0)
            return statisticService.getAllHighRiskStudents();
        else
            return statisticService.getAllHighRiskStudentsByCollegeNum(user.getCollegeNum().toString());
    }

    @RequestMapping(value = "/riskarea", method = {RequestMethod.POST, RequestMethod.GET}, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<List<UserDto>> riskAreaStudentList() {
        UserDto user = (UserDto) session.getAttribute("user");
        if (user == null || user.getUserType().equals(2)) return null;
        if (user.getUserType() == 0)
            return statisticService.getAllRiskAreaStudents();
        else
            return statisticService.getAllRiskAreaStudentsByCollegeNum(user.getCollegeNum().toString());
    }
}
