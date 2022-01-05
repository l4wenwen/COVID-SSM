package cn.edu.zust.se.service.impl;

import cn.edu.zust.se.dao.StateMapper;
import cn.edu.zust.se.service.StateServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateServiceImpl implements StateServiceI {
    @Autowired
    StateMapper stateMapper;
}
