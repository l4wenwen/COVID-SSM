package cn.edu.zust.se.service;

import cn.edu.zust.se.entity.User;
import cn.edu.zust.se.entity.Vacation;

import java.util.List;

public interface VacationServiceI {

    List<Vacation> getVacationListById(String userNum);

    List<Vacation> getVacationListByDepId(int collegeNum);

    Boolean submitVacationRequest(User user, Vacation vacation);

    Boolean revokeRequest(String userNum, int vacationNum);

    Boolean performDecision(int vacationNum, int operation);
}
