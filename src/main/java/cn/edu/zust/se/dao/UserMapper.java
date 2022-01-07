package cn.edu.zust.se.dao;

import cn.edu.zust.se.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> userLogin(@Param("userNum") String userNum, @Param("password") String password);

    List<User> getUserById(@Param("userNum") String userNum);

    List<User> getAllTeachers();

    List<User> getAllStudents();

    List<User> searchUserByName(@Param("userName") String userName);

    List<User> searchUserByNameAndCollegeNum(@Param("userName") String userName, @Param("collegeNum") Integer collegeNum);

    List<User> getAllStudentsByCollegeNum(@Param("collegeNum") String collegeNum);

    Boolean updateUserTelephone(@Param("telephone") String telephone, @Param("userNum") String userNum);

    Boolean updateUserPassword(@Param("password") String password, @Param("userNum") String userNum);

    Integer getStudentNumber();

    Integer getTeacherNumber();

    Integer getStudentNumberByCollegeNum(@Param("collegeNum") String collegeNum);

    Boolean addUser(@Param("userNum") String userNum,
                    @Param("userName") String userName,
                    @Param("sex") Boolean sex,
                    @Param("userType") Integer userType,
                    @Param("collegeNum") Integer collegeNum,
                    @Param("password") String password,
                    @Param("majorNum") Integer majorNum);
}
