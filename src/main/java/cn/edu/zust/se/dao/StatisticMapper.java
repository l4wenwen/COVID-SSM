package cn.edu.zust.se.dao;

import cn.edu.zust.se.entity.College;
import cn.edu.zust.se.entity.Major;
import cn.edu.zust.se.entity.User;

import java.util.List;

public interface StatisticMapper {
    List<College> getAllColleges();

    List<Major> getMajorsByCollegeNum(String collegeNum);

    List<User> getAllFilledStudents();

    List<User> getAllFilledStudentsByCollegeNum(String collegeNum);
}
