package com.ifarm.console.facade.service.impl;

import com.ifarm.console.facade.service.IUserService;
import com.ifarm.console.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;
}
