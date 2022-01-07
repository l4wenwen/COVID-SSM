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


    UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

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
            userProfile.setSex(user.getSex() ? "男" : "女");
            if (user.getCollege() != null)
                userProfile.setCollegeName(user.getCollege().getCollegeName());
            if (user.getMajor() != null)
                userProfile.setMajorName(user.getMajor().getMajorName());
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

    @Override
    public Result<Integer> getStudentNumber() {
        Result<Integer> result = new Result<Integer>();
        Integer number = userMapper.getStudentNumber();
        result.setSuccess(true);
        result.setData(number);
        return result;
    }

    @Override
    public Result<Integer> getTeacherNumber() {
        Result<Integer> result = new Result<Integer>();
        Integer number = userMapper.getTeacherNumber();
        result.setSuccess(true);
        result.setData(number);
        return result;
    }

    @Override
    public Result<List<UserDto>> getAllTeachers() {
        Result<List<UserDto>> result = new Result<List<UserDto>>();
        List<UserDto> list = e2d(userMapper.getAllTeachers());
        result.setData(list);
        result.setSuccess(true);
        return result;
    }

    @Override
    public Result<List<UserDto>> getAllStudents() {
        Result<List<UserDto>> result = new Result<List<UserDto>>();
        List<UserDto> list = e2d(userMapper.getAllStudents());
        result.setData(list);
        result.setSuccess(true);
        return result;
    }

    @Override
    public Result<List<UserDto>> getAllStudentsByCollegeNum(String collegeNum) {
        List<UserDto> list = e2d(userMapper.getAllStudentsByCollegeNum(collegeNum));
        return new Result<List<UserDto>>(true, list);
    }

    @Override
    public Result<String> addUser(User user) {
        Result<String> result = new Result<String>();
        String userNum = user.getUserNum();
        Integer collegeNum = user.getCollegeNum();
        Integer majorNum = user.getMajorNum();
        Integer userType = user.getUserType();
        Boolean sex = user.getSex();
        String userName = user.getUserName();
        String message = "", directURI = "/WEB-INF/";
        boolean isRegistered = false;
        do {
            System.out.println(user.toString());
            if (!isGoodString(userName) || !isGoodString(userNum) || !isGoodString(sex.toString()) || !isGoodString(userType.toString())) {
                message = "信息不能为空。";
                break;
            }
            if (userNum.length() != 8) {
                message = "学号长度为8位";
                break;
            }
            if (userType == 0) {
                collegeNum = majorNum = null;
            } else if (userType == 1) {
                if (!isGoodString(collegeNum.toString())) {
                    message = "学院未选择";
                    break;
                }
                majorNum = null;
            } else {
                if (!isGoodString(collegeNum.toString()) || !isGoodString(majorNum.toString())) {
                    message = "学院或专业未选择";
                    break;
                }
            }
            isRegistered = userMapper.addUser(userNum, userName, sex, userType, collegeNum, userNum.substring(4), majorNum);
            if (!isRegistered) {
                message = "账号已存在。";
                break;
            }
            message = "添加成功";
        } while (false);
        result.setSuccess(isRegistered);
        result.setData(message);
        return result;
    }

    @Override
    public Result<List<UserDto>> searchUserByName(String userName) {
        List<UserDto> list = e2d(userMapper.searchUserByName(userName));
        return new Result<List<UserDto>>(true, list);
    }

    @Override
    public Result<List<UserDto>> searchUserByNameAndCollegeNum(String userName, Integer collegeNum) {
        List<UserDto> list = e2d(userMapper.searchUserByNameAndCollegeNum(userName, collegeNum));
        return new Result<List<UserDto>>(true, list);
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
