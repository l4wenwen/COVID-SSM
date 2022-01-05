package cn.edu.zust.se.dao;

import cn.edu.zust.se.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> userLogin(@Param("userNum") String userNum, @Param("password") String password);
    List<User> getUserById(@Param("userNum") String userNum);
    Boolean updateUserTelephone(@Param("telephone") String telephone, @Param("userNum") String userNum);
    Boolean updateUserPassword(@Param("password") String password, @Param("userNum") String userNum);
}
