package cn.edu.zust.se.dao;

import cn.edu.zust.se.entity.State;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StateMapper {
    Boolean addState(
            @Param("stateNum") Integer stateNum,
            @Param("userNum") String userNum,
            @Param("stateTime") String stateTime,
            @Param("isTemperature") boolean isTemperature,
            @Param("isCovid") boolean isCovid,
            @Param("isLikeCovid") boolean isLikeCovid,
            @Param("quarantine") Integer quarantine,
            @Param("isRecentArea") boolean isRecentArea,
            @Param("isRecentCountry") boolean isRecentCountry,
            @Param("isRecentPeople") boolean isRecentPeople,
            @Param("isSymptom") boolean isSymptom,
            @Param("isAbnormal") boolean isAbnormal,
            @Param("healthCodeType") Integer healthCodeType,
            @Param("isOutSchool") boolean isOutSchool,
            @Param("isOutCity") boolean isOutCity
    );

    List<State> getAllState();

    List<State> getStateByTime(@Param("stateTimeStart") String stateTimeStart,
                                @Param("stateTimeEnd") String stateTimeEnd);
}
