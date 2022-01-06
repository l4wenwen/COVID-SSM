package cn.edu.zust.se.service.impl;

import cn.edu.zust.se.dao.StateMapper;
import cn.edu.zust.se.dto.Result;
import cn.edu.zust.se.dto.StateDto;
import cn.edu.zust.se.service.StateServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImpl implements StateServiceI {

    StateMapper stateMapper;

    @Autowired
    public void setStateMapper(StateMapper stateMapper) {
        this.stateMapper = stateMapper;
    }

    @Override
    public Result<List<StateDto>> getStateByTime(String startTime, String endTime, Integer userType) {
        Result<List<StateDto>> result = new Result<>();
        if (userType == 0) {
            result.setData(stateMapper.getStateByTime0(startTime, endTime));
        } else if (userType == 1) {
            result.setData(stateMapper.getStateByTime1(startTime, endTime));
        } else {
            result.setData(stateMapper.getStateByTime2(startTime, endTime));
        }
        result.setSuccess(true);
        return result;
    }

    @Override
    public Result<Integer> delState(String stateNum, String userNum) {
        Result<Integer> result = new Result<Integer>();
        result.setSuccess(true);
        result.setData(stateMapper.delState(stateNum, userNum));
        return result;
    }

    @Override
    public Result<Integer> getUserState(String userNum, String stateTime) {
        Result<Integer> result = new Result<Integer>();
        result.setSuccess(true);
        result.setData(stateMapper.getUserState(userNum, stateTime));
        return result;
    }

    @Override
    public Result<Boolean> addState(Integer stateNum, String userNum, String stateTime, boolean isTemperature, boolean isCovid, boolean isLikeCovid, Integer quarantine, boolean isRecentArea, boolean isRecentCountry, boolean isRecentPeople, boolean isSymptom, boolean isAbnormal, Integer healthCodeType, boolean isOutSchool, boolean isOutCity) {
        Result<Boolean> result = new Result<Boolean>();
        result.setSuccess(true);
        result.setData("添加成功");
        stateMapper.addState(stateNum, userNum, stateTime, isTemperature, isCovid, isLikeCovid, quarantine, isRecentArea, isRecentCountry, isRecentPeople, isSymptom, isAbnormal, healthCodeType, isOutSchool, isOutCity);
        return result;
    }
}
