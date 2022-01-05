package cn.edu.zust.se.service;

import cn.edu.zust.se.dto.Result;
import cn.edu.zust.se.dto.UserDto;
import cn.edu.zust.se.entity.User;
import cn.edu.zust.se.entity.UserProfile;

import java.util.List;

public interface UserServiceI {
    public Result<UserDto> userLogin(String userNum, String password);
    public Result<UserDto> getUserById(String userNum);
    public Result<UserProfile> getUserProfile(String userNum);
    public Result<Boolean> updateUserTelephone(String telephone, String userNum);
    public Result<Boolean> updateUserPassword(String password, String repassword, String userNum);
}
