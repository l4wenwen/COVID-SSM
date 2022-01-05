package cn.edu.zust.se.service.impl;

import cn.edu.zust.se.dao.VacationMapper;
import cn.edu.zust.se.service.VacationServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacationServiceImpl implements VacationServiceI {
    @Autowired
    VacationMapper vacationMapper;
}
