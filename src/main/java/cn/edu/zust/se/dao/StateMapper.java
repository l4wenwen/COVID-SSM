package cn.edu.zust.se.dao;

import cn.edu.zust.se.dto.StateDto;
import cn.edu.zust.se.entity.Area;
import cn.edu.zust.se.entity.State;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StateMapper {
    List<StateDto> getStateByTime0(@Param("startTime") String startTime, @Param("endTime") String endTime);
    List<StateDto> getStateByTime1(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("collegeNum") Integer collegeNum);
    List<StateDto> getStateByTime2(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("userNum") String userNum);

    Integer delState(@Param("stateTime") String stateTime, @Param("userNum") String userNum);

    Integer getUserState(@Param("userNum") String userNum, @Param("stateTime") String stateTime);

    Integer addArea(@Param("areaName") String areaName);

    Boolean addState(State state);

    List<Area> getAllArea();

    Integer delArea(Integer areaNum);
}
