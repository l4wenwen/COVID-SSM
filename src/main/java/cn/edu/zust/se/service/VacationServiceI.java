package cn.edu.zust.se.service;

import cn.edu.zust.se.entity.User;
import cn.edu.zust.se.entity.Vacation;

import java.util.List;

public interface VacationServiceI {

    List<Vacation> getVacationListById(String userNum);

    List<Vacation> getVacationListByDepId(Integer collegeNum);

    Integer submitVacationRequest(User user, Vacation vacation);

    Integer revokeRequest(String userNum, Integer vacationNum);

    Integer performDecision(Integer vacationNum, Integer operation);
}
