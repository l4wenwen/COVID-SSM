package cn.edu.zust.se.service.impl;

import cn.edu.zust.se.dao.UserMapper;
import cn.edu.zust.se.dto.Result;
import cn.edu.zust.se.dto.UserDto;
import cn.edu.zust.se.entity.User;
import cn.edu.zust.se.entity.UserProfile;
import cn.edu.zust.se.service.UserServiceI;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserServiceI {

    @Autowired
    UserMapper userMapper;

    public Result<UserDto> userLogin(String userNum, String password){
        Result<UserDto> result = new Result<UserDto>();
        List<UserDto> list = e2d(userMapper.userLogin(userNum, password));
        if (list == null || list.size() == 0) {
            result.setSuccess(false);
            result.setError("账号密码错误！");
        } else {
            result.setSuccess(true);
            result.setData(list.get(0));
        }
        return result;
    }

    @Override
    public Result<UserDto> getUserById(String userNum) {
        Result<UserDto> result = new Result<UserDto>();
        List<UserDto> list = e2d(userMapper.getUserById(userNum));
        if (list == null || list.size() == 0) {
            result.setSuccess(false);
            result.setError("找不到用户！");
        } else {
            result.setSuccess(true);
            result.setData(list.get(0));
        }
        return result;
    }

    @Override
    public Result<UserProfile> getUserProfile(String userNum) {
        Result<UserProfile> result = new Result<UserProfile>();
        List<UserDto> list = e2d(userMapper.getUserById(userNum));
        if (list == null || list.size() == 0) {
            result.setSuccess(false);
            result.setError("找不到用户！");
        } else {
            result.setSuccess(true);
            UserDto user = list.get(0);
            UserProfile userProfile = new UserProfile();
            userProfile.setUserName(user.getUserName());
            userProfile.setUserNum(user.getUserNum());
            userProfile.setSex(user.isSex() ? "男" : "女");
            String userType = "管理员";
            if (user.getUserType() == 1) userType = "老师";
            else if (user.getUserType() == 2) userType = "学生";
            result.setData(userProfile);
            userProfile.setUserType(userType);
            userProfile.setTelephone(user.getTelephone() == null || "".equals(user.getTelephone().trim()) ? "未填写" : user.getTelephone());
        }
        return result;
    }

    @Override
    public Result<Boolean> updateUserTelephone(String telephone, String userNum) {
        Result<Boolean> result = new Result<Boolean>();

        Boolean isVaild = false;
        if (isGoodString(telephone)) {
            Pattern pattern = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
            Matcher matcher = pattern.matcher(telephone);
            isVaild = matcher.matches();
        }
        if (isVaild) {
            Boolean isUpdate = userMapper.updateUserTelephone(telephone, userNum);
            if (!isUpdate) {
                result.setSuccess(false);
                result.setError("更新失败");
            } else {
                result.setSuccess(true);
            }
        } else {
            result.setSuccess(false);
            result.setError("号码格式错误！");
        }

        return result;
    }

    @Override
    public Result<Boolean> updateUserPassword(String password, String repassword, String userNum) {
        Result<Boolean> result = new Result<Boolean>();
        if (!isGoodString(password) || !isGoodString(repassword) || !password.equals(repassword)) {
            result.setSuccess(false);
            result.setError("密码为空或两次密码不一致！");
        } else {
            if (userMapper.updateUserPassword(password, userNum)) {
                result.setSuccess(true);
            } else {
                result.setSuccess(false);
                result.setError("修改失败！");
            }
        }
        return result;
    }

    private List<UserDto> e2d(List<User> pictures) {
        if (pictures == null || pictures.size() == 0) return null;
        List<UserDto> dtoList = new ArrayList<UserDto>();
        for(User e : pictures) {
            UserDto dto = new UserDto();
            BeanUtils.copyProperties(e, dto);
            dtoList.add(dto);
        }
        return dtoList;
    }

    protected boolean isGoodString(String str) {
        return str != null && !"".equals(str.trim());
    }
}
