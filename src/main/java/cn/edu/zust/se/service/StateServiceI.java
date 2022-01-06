package cn.edu.zust.se.service;

import cn.edu.zust.se.dto.Result;
import cn.edu.zust.se.dto.StateDto;
import cn.edu.zust.se.entity.State;

import java.util.List;

public interface StateServiceI {
    public Result<List<StateDto>> getStateByTime(String startTime, String endTime, Integer userType);

    public Result<Integer> delState(String stateNum, String userNum);

    public Result<Integer> getUserState(String userNum, String stateTime);

    public Result<Boolean> addState(State state);
}
