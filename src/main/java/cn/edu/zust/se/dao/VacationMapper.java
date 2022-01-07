package cn.edu.zust.se.dao;

import cn.edu.zust.se.entity.User;
import cn.edu.zust.se.entity.Vacation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VacationMapper {

    List<Vacation> getVacationListById(@Param("userNum") String userNum);

    List<Vacation> getVacationListByDepId(@Param("collegeNum") Integer collegeNum);

    Integer submitVacationRequest(@Param("user") User user, @Param("vacation") Vacation vacation);

    Integer queryVacationState(@Param("userNum") String userNum, @Param("vacationNum") Integer vacationNum);

    Integer deleteVacation(@Param("userNum") String userNum, @Param("vacationNum") Integer vacationNum);

    Integer checkVacationPending(@Param("vacationNum") Integer vacationNum);

    Integer updateVacationState(@Param("vacationNum") Integer vacationNum, @Param("state") Integer state);
}
