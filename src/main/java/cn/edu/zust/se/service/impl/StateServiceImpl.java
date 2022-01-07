package cn.edu.zust.se.service.impl;

import cn.edu.zust.se.dao.StateMapper;
import cn.edu.zust.se.dto.Result;
import cn.edu.zust.se.dto.StateDto;
import cn.edu.zust.se.entity.State;
import cn.edu.zust.se.service.StateServiceI;
import cn.edu.zust.se.util.TimeUtil;
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
    public Result<List<StateDto>> getStateByTime(String startTime, String endTime, Integer userType, Integer collegeNum, String userNum) {
        Result<List<StateDto>> result = new Result<>();
        if (userType == 0) {
            result.setData(stateMapper.getStateByTime0(startTime, endTime));
        } else if (userType == 1) {
            result.setData(stateMapper.getStateByTime1(startTime, endTime, collegeNum));
        } else {
            result.setData(stateMapper.getStateByTime2(startTime, endTime, userNum));
        }
        return result;
    }

    @Override
    public Result<Integer> delState(String stateNum, String userNum) {
        Result<Integer> result = new Result<Integer>();
        result.setSuccess(true);
        result.setData(stateMapper.delState(TimeUtil.getDate(), userNum));
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
    public Result<Boolean> addState(State state) {
        Result<Boolean> result = new Result<Boolean>();
        result.setSuccess(true);
        stateMapper.addState(state);
        return result;
    }
}
