package cn.edu.zust.se.dao;

import cn.edu.zust.se.entity.User;
import cn.edu.zust.se.entity.Vacation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VacationMapper {

    List<Vacation> getVacationListById(@Param("userNum") String userNum);

    List<Vacation> getVacationListByDepId(@Param("collegeNum") int collegeNum);

    Boolean submitVacationRequest(@Param("user") User user, @Param("vacation") Vacation vacation);

    int queryVacationState(@Param("userNum") String userNum, @Param("vacationNum") int vacationNum);

    Boolean deleteVacation(@Param("userNum") String userNum, @Param("vacationNum") int vacationNum);

    Boolean checkVacationPending(@Param("vacationNum") int vacationNum);

    Boolean updateVacationState(@Param("vacationNum") int vacationNum, @Param("state") int state);
}
