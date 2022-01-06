package cn.edu.zust.se.service;

import cn.edu.zust.se.dto.Result;

public interface StatisticServiceI {
    public Result<String> getAllColleges();

    public Result<String> getMajorsByCollegeNum(String majorNum);
}
