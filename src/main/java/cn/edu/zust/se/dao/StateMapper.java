package cn.edu.zust.se.dao;

import org.apache.ibatis.annotations.Param;

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

    String getStateByTime0(@Param("startTime") String startTime, @Param("endTime") String endTime);
    String getStateByTime1(@Param("startTime") String startTime, @Param("endTime") String endTime);
    String getStateByTime2(@Param("startTime") String startTime, @Param("endTime") String endTime);

    String delState(@Param("stateNum") String stateNum, @Param("userNum") String userNum);

    String getUserState(@Param("userNum") String userNum, @Param("stateTime") String stateTime);
}
