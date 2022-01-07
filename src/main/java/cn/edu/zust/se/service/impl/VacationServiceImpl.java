package cn.edu.zust.se.service.impl;

import cn.edu.zust.se.dao.VacationMapper;
import cn.edu.zust.se.entity.User;
import cn.edu.zust.se.entity.Vacation;
import cn.edu.zust.se.service.VacationServiceI;
import cn.edu.zust.se.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacationServiceImpl implements VacationServiceI {
    VacationMapper vacationMapper;

    @Autowired
    public void setVacationMapper(VacationMapper vacationMapper) {
        this.vacationMapper = vacationMapper;
    }

    @Override
    public List<Vacation> getVacationListById(String userNum) {
        return vacationMapper.getVacationListById(userNum);
    }

    @Override
    public List<Vacation> getVacationListByDepId(Integer collegeNum) {
        return vacationMapper.getVacationListByDepId(collegeNum);
    }

    @Override
    public Integer submitVacationRequest(User user, Vacation vacation) {
        vacation.setRequestTime(TimeUtil.getDate());
        vacation.setState(0);
        return vacationMapper.submitVacationRequest(user, vacation);
    }

    @Override
    public Integer revokeRequest(String userNum, Integer vacationNum) {
        Integer state = vacationMapper.queryVacationState(userNum, vacationNum);
        if (state == -1) return 0;
        Integer isRevoked = 0;
        if (state == Vacation.STATE_PENDING) {
            isRevoked = vacationMapper.deleteVacation(userNum, vacationNum);
        }
        return isRevoked;
    }

    @Override
    public Integer performDecision(Integer vacationNum, Integer operation) {
        Integer ok = vacationMapper.checkVacationPending(vacationNum);
        if (ok == 0) return 0;
        return vacationMapper.updateVacationState(vacationNum, operation);
    }
}
