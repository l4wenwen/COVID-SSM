package cn.edu.zust.se.dao;

import cn.edu.zust.se.entity.College;
import cn.edu.zust.se.entity.Major;

import java.util.List;

public interface StatisticMapper {
    List<College> getAllColleges();

    List<Major> getMajorsByCollegeNum(String collegeNum);
}
