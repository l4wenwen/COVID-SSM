package cn.edu.zust.se.dao;

import cn.edu.zust.se.entity.College;
import cn.edu.zust.se.entity.Major;
import cn.edu.zust.se.entity.Statistic;
import cn.edu.zust.se.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StatisticMapper {
    List<College> getAllColleges();

    List<Major> getMajorsByCollegeNum(@Param("collegeNum") String collegeNum);

    List<User> getAllFilledStudents(@Param("queryTime") String queryTime);

    List<User> getAllFilledStudentsByCollegeNum(@Param("collegeNum") String collegeNum, @Param("queryTime") String queryTime);

    List<User> getAllHighRiskStudents(@Param("queryTime") String queryTime);

    List<User> getAllHighRiskStudentsByCollegeNum(@Param("collegeNum") String collegeNum, @Param("queryTime") String queryTime);

    List<User> getAllRiskAreaStudents(@Param("queryTime") String queryTime);

    List<User> getAllRiskAreaStudentsByCollegeNum(@Param("collegeNum") String collegeNum, @Param("queryTime") String queryTime);

}
