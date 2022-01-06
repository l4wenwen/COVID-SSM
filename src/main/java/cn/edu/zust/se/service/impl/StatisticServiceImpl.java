package cn.edu.zust.se.service.impl;

import cn.edu.zust.se.dao.StatisticMapper;
import cn.edu.zust.se.dto.Result;
import cn.edu.zust.se.dto.UserDto;
import cn.edu.zust.se.entity.College;
import cn.edu.zust.se.entity.Major;
import cn.edu.zust.se.entity.User;
import cn.edu.zust.se.service.StatisticServiceI;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticServiceI {

    StatisticMapper statisticMapper;

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
        List<UserDto> list = e2d(statisticMapper.getAllFilledStudents());
        result.setSuccess(true);
        result.setData(list);
        return result;
    }

    @Override
    public Result<List<UserDto>> getAllFilledStudentsByCollegeNum(String collegeNum) {
        Result<List<UserDto>> result = new Result<List<UserDto>>();
        List<UserDto> list = e2d(statisticMapper.getAllFilledStudentsByCollegeNum(collegeNum));
        result.setSuccess(true);
        result.setData(list);
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
}
