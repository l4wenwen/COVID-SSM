package cn.edu.zust.se.service.impl;

import cn.edu.zust.se.dao.VacationMapper;
import cn.edu.zust.se.entity.User;
import cn.edu.zust.se.entity.Vacation;
import cn.edu.zust.se.service.VacationServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacationServiceImpl implements VacationServiceI {
    @Autowired
    VacationMapper vacationMapper;

    @Override
    public List<Vacation> getVacationListById(String userNum) {
        return vacationMapper.getVacationListById(userNum);
    }

    @Override
    public List<Vacation> getVacationListByDepId(int collegeNum) {
        return vacationMapper.getVacationListByDepId(collegeNum);
    }

    @Override
    public boolean submitVacationRequest(User user, Vacation vacation) {
        return vacationMapper.submitVacationRequest(user, vacation);
    }

    @Override
    public boolean revokeRequest(String userNum, String vacationNum) {
        int state = vacationMapper.queryVacationState(userNum, vacationNum);
        if (state == -1) return false;
        boolean isRevoked = false;
        if (state == Vacation.STATE_PENDING) {
            isRevoked = vacationMapper.deleteVacation(userNum, vacationNum);
        }
        return isRevoked;
    }

    @Override
    public boolean performDecision(int vacationNum, int operation) {
        boolean ok = vacationMapper.checkVacationPending(vacationNum);
        if (!ok) return false;
        return vacationMapper.updateVacationState(vacationNum, operation);
    }
}
