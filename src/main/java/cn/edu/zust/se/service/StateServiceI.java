package cn.edu.zust.se.service;

import cn.edu.zust.se.dto.Result;
import cn.edu.zust.se.dto.StateDto;

import java.util.List;

public interface StateServiceI {
    public Result<List<StateDto>> getStateByTime(String startTime, String endTime, Integer userType);

    public Result<Integer> delState(String stateNum, String userNum);

    public Result<Integer> getUserState(String userNum, String stateTime);

    public Result<Boolean> addState(
        Integer stateNum,
        String userNum,
        String stateTime,
        boolean isTemperature,
        boolean isCovid,
        boolean isLikeCovid,
        Integer quarantine,
        boolean isRecentArea,
        boolean isRecentCountry,
        boolean isRecentPeople,
        boolean isSymptom,
        boolean isAbnormal,
        Integer healthCodeType,
        boolean isOutSchool,
        boolean isOutCity
    );
}
