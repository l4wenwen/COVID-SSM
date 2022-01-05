package cn.edu.zust.se.dao;

import cn.edu.zust.se.entity.User;
import cn.edu.zust.se.entity.Vacation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VacationMapper {
    List<Vacation> getVacationListById(@Param("userNum") String userNum);

    List<Vacation> getVacationListByDepId(@Param("collegeNum") int collegeNum);

//    boolean submitVacationRequest(User user, Vacation vacation);
//
//    boolean revokeRequest(String userNum, String vacationNum);
//
//    boolean performDecision(int vacationNum, int operation);
}
