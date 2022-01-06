package cn.edu.zust.se.service;

import cn.edu.zust.se.dto.Result;
import cn.edu.zust.se.dto.UserDto;

import java.util.List;

public interface StatisticServiceI {
    public Result<String> getAllColleges();

    public Result<String> getMajorsByCollegeNum(String majorNum);

    public Result<List<UserDto>> getAllFilledStudents();

    public Result<List<UserDto>> getAllFilledStudentsByCollegeNum(String collegeNum);
}
