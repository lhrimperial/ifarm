package com.ifarm.console.facade.service.impl;

import com.ifarm.console.facade.service.IUserInfoService;
import com.ifarm.console.mapper.UserMapper;
import com.ifarm.console.shared.domain.dto.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 **/
@Service
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserInfoVO findByUserName(String userName) {
        return null;
    }
}
