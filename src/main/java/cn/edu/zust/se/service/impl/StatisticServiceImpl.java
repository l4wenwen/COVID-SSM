package cn.edu.zust.se.service.impl;

import cn.edu.zust.se.dao.StatisticMapper;
import cn.edu.zust.se.dao.UserMapper;
import cn.edu.zust.se.dto.Result;
import cn.edu.zust.se.dto.UserDto;
import cn.edu.zust.se.entity.College;
import cn.edu.zust.se.entity.Major;
import cn.edu.zust.se.entity.Statistic;
import cn.edu.zust.se.entity.User;
import cn.edu.zust.se.service.StatisticServiceI;
import cn.edu.zust.se.util.TimeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticServiceI {

    StatisticMapper statisticMapper;

    UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setStatisticMapper(StatisticMapper statisticMapper) {
        this.statisticMapper = statisticMapper;
    }

    @Override
    public Result<String> getAllColleges() {
        Result<String> result = new Result<String>();
        List<College> list = statisticMapper.getAllColleges();
        StringBuilder collegeOption = new StringBuilder();
        for(College college : list) {
            collegeOption.append("<option value='").append(college.getCollegeNum()).append("'>").append(college.getCollegeName()).append("</option>");
        }
        result.setSuccess(true);
        result.setData(collegeOption.toString());
        return result;
    }

    @Override
    public Result<String> getMajorsByCollegeNum(String collegeNum) {
        Result<String> result = new Result<String>();
        List<Major> list = statisticMapper.getMajorsByCollegeNum(collegeNum);
        StringBuilder collegeOption = new StringBuilder();
        for(Major major : list) {
            collegeOption.append("<option value='").append(major.getMajorNum()).append("'>").append(major.getMajorName()).append("</option>");
        }
        result.setSuccess(true);
        result.setData(collegeOption.toString());
        return result;
    }

    @Override
    public Result<List<UserDto>> getAllFilledStudents() {
        Result<List<UserDto>> result = new Result<List<UserDto>>();
        List<UserDto> list = e2d(statisticMapper.getAllFilledStudents(TimeUtil.getDate()));
        result.setSuccess(true);
        result.setData(list);
        return result;
    }

    @Override
    public Result<List<UserDto>> getAllFilledStudentsByCollegeNum(String collegeNum) {
        Result<List<UserDto>> result = new Result<List<UserDto>>();
        List<UserDto> list = e2d(statisticMapper.getAllFilledStudentsByCollegeNum(collegeNum, TimeUtil.getDate()));
        result.setSuccess(true);
        result.setData(list);
        return result;
    }

    @Override
    public Result<List<UserDto>> getAllHighRiskStudents() {
        List<UserDto> list = e2d(statisticMapper.getAllHighRiskStudents(TimeUtil.getDate()));
        return new Result<List<UserDto>>(true, list);
    }

    @Override
    public Result<List<UserDto>> getAllHighRiskStudentsByCollegeNum(String collegeNum) {
        List<UserDto> list = e2d(statisticMapper.getAllHighRiskStudentsByCollegeNum(collegeNum, TimeUtil.getDate()));
        return new Result<List<UserDto>>(true, list);
    }

    @Override
    public Result<List<UserDto>> getAllRiskAreaStudents() {
        List<UserDto> list = e2d(statisticMapper.getAllRiskAreaStudents(TimeUtil.getDate()));
        return new Result<List<UserDto>>(true, list);
    }

    @Override
    public Result<List<UserDto>> getAllRiskAreaStudentsByCollegeNum(String collegeNum) {
        List<UserDto> list = e2d(statisticMapper.getAllRiskAreaStudentsByCollegeNum(collegeNum, TimeUtil.getDate()));
        return new Result<List<UserDto>>(true, list);
    }

    @Override
    public Result<List<UserDto>> getAllStudents() {
        List<UserDto> list = e2d(statisticMapper.getAllStudents(TimeUtil.getDate()));
        return new Result<List<UserDto>>(true, list);
    }

    @Override
    public Result<List<UserDto>> getAllStudentsByCollegeNum(String collegeNum) {
        List<UserDto> list = e2d(statisticMapper.getAllStudentsByCollegeNum(collegeNum, TimeUtil.getDate()));
        return new Result<List<UserDto>>(true, list);
    }

    @Override
    public Result<Statistic> getAllStatistic() {
        Statistic statistic = new Statistic();
        String curTime = TimeUtil.getDate();
        statistic.setTotalNum(userMapper.getStudentNumber());
        statistic.setFilledNum(statisticMapper.getAllFilledStudents(curTime).size());
        statistic.setHighRiskNum(statisticMapper.getAllHighRiskStudents(curTime).size());
        statistic.setPassRiskAreaNum(statisticMapper.getAllRiskAreaStudents(curTime).size());
        return new Result<Statistic>(true, statistic);
    }

    @Override
    public Result<Statistic> getAllStatisticByCollegeNum(String collegeNum) {
        Statistic statistic = new Statistic();
        String curTime = TimeUtil.getDate();
        statistic.setTotalNum(userMapper.getStudentNumberByCollegeNum(collegeNum));
        statistic.setFilledNum(statisticMapper.getAllFilledStudentsByCollegeNum(collegeNum, curTime).size());
        statistic.setHighRiskNum(statisticMapper.getAllHighRiskStudentsByCollegeNum(collegeNum, curTime).size());
        statistic.setPassRiskAreaNum(statisticMapper.getAllRiskAreaStudentsByCollegeNum(collegeNum, curTime).size());
        return new Result<Statistic>(true, statistic);
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
}
