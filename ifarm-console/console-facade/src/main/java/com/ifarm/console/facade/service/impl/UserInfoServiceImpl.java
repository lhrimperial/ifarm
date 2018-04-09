package com.ifarm.console.facade.service.impl;

import com.github.framework.util.string.StringUtils;
import com.ifarm.console.facade.service.IUserInfoService;
import com.ifarm.console.mapper.UserMapper;
import com.ifarm.console.shared.domain.define.IFarmConstants;
import com.ifarm.console.shared.domain.dto.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 *
 **/
@Service
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserInfoVO> findByParam(UserInfoVO userInfoVO) {
        if (userInfoVO == null) {
            throw new IllegalArgumentException("参数不能为空！");
        }
        return userMapper.findByParam(userInfoVO);
    }

    @Override
    public long totalCount(UserInfoVO userInfoVO) {
        if (userInfoVO == null) {
            throw new IllegalArgumentException("参数不能为空！");
        }
        return userMapper.totalCount(userInfoVO);
    }

    @Override
    public UserInfoVO findByUserName(String userName) {
        if (StringUtils.isBlank(userName)) {
            throw new IllegalArgumentException("参数不能为空！");
        }
        return userMapper.findByUserName(userName);
    }

    @Override
    public int delete(String userName) {
        if (StringUtils.isBlank(userName)) {
            throw new IllegalArgumentException("参数不能为空！");
        }
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setUserName(userName);
        userInfoVO.setActive(IFarmConstants.INACTIVE);
        userInfoVO.setModifyTime(new Date());
        return userMapper.update(userInfoVO);
    }

    @Override
    public int update(UserInfoVO userInfoVO) {
        if (userInfoVO == null) {
            throw new IllegalArgumentException("参数不能为空！");
        }
        userInfoVO.setModifyTime(new Date());
        return userMapper.update(userInfoVO);
    }

    @Override
    public int insert(UserInfoVO userInfoVO) {
        if (userInfoVO == null) {
            throw new IllegalArgumentException("参数不能为空！");
        }
        userInfoVO.setCreateTime(new Date());
        userInfoVO.setModifyTime(new Date());
        userInfoVO.setActive(IFarmConstants.ACTIVE);
        return userMapper.insert(userInfoVO);
    }
}
