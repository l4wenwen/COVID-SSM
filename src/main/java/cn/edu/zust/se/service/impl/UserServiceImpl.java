package cn.edu.zust.se.service.impl;

import cn.edu.zust.se.dao.UserMapper;
import cn.edu.zust.se.entity.User;
import cn.edu.zust.se.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServiceI {

    @Autowired
    UserMapper userMapper;

    public List<User> getAll() {
        return userMapper.getAll();
    }
}
