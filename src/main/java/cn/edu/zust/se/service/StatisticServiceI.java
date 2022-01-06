package cn.edu.zust.se.service;

import cn.edu.zust.se.dto.Result;
import cn.edu.zust.se.dto.UserDto;
import cn.edu.zust.se.entity.Statistic;
import cn.edu.zust.se.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StatisticServiceI {
    public Result<String> getAllColleges();

    public Result<String> getMajorsByCollegeNum(String majorNum);

    public Result<List<UserDto>> getAllFilledStudents();

    public Result<List<UserDto>> getAllFilledStudentsByCollegeNum(String collegeNum);

    public Result<List<UserDto>> getAllHighRiskStudents();

    public Result<List<UserDto>> getAllHighRiskStudentsByCollegeNum(String collegeNum);

    public Result<List<UserDto>> getAllRiskAreaStudents();

    public Result<List<UserDto>> getAllRiskAreaStudentsByCollegeNum(String collegeNum);

    public Result<List<UserDto>> getAllStudents();

    public Result<List<UserDto>> getAllStudentsByCollegeNum(String collegeNum);


    public Result<Statistic> getAllStatistic();

    public Result<Statistic> getAllStatisticByCollegeNum(String collegeNum);
}
