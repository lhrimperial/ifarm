package com.ifarm.console.facade.service.impl;

import com.github.framework.util.string.StringUtils;
import com.github.pagehelper.PageHelper;
import com.ifarm.console.shared.domain.exception.RegisterException;
import com.ifarm.console.facade.service.IUserInfoService;
import com.ifarm.console.mapper.UserMapper;
import com.ifarm.console.shared.domain.define.IFarmConstants;
import com.ifarm.console.shared.domain.dto.UserInfoVO;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 *
 **/
@Service
public class UserInfoServiceImpl implements IUserInfoService {

    private Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserInfoVO> findByParam(UserInfoVO userInfoVO) {
        if (userInfoVO == null) {
            throw new IllegalArgumentException("参数不能为空！");
        }
        PageHelper.startPage(userInfoVO.getPage(), userInfoVO.getLimit());
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
    @Cacheable
    public UserInfoVO findByUserName(String userName) {
        if (StringUtils.isBlank(userName)) {
            throw new IllegalArgumentException("参数不能为空！");
        }
        return userMapper.findByUserName(userName);
    }

    @Override
    public UserInfoVO findLoginUser(String userName) {
        if (StringUtils.isBlank(userName)) {
            throw new IllegalArgumentException("参数不能为空！");
        }
        return userMapper.findLoginUser(userName);
    }

    @Override
    public void changePassword(UserInfoVO userInfoVO) {
        //TODO
    }

    @Override
    public void register(UserInfoVO userInfoVO) {
        if (userInfoVO == null) {
            throw new RegisterException("参数不能为空");
        } else if (StringUtils.isBlank(userInfoVO.getUserName())) {
            throw new RegisterException("用户名不能为空");
        } else if (StringUtils.isBlank(userInfoVO.getPassword())) {
            throw new RegisterException("登录密码不能为空");
        }
        String userName = userInfoVO.getUserName();
        String password = userInfoVO.getPassword();
        UserInfoVO exist = this.findByUserName(userName);
        if (exist != null) {
            throw new RegisterException("此用户名已注册");
        }

        // 将用户名作为盐值
        ByteSource salt = ByteSource.Util.bytes(userName);
        /*
        * MD5加密：
        * 使用SimpleHash类对原始密码进行加密。
        * 第一个参数代表使用MD5方式加密
        * 第二个参数为原始密码
        * 第三个参数为盐值，即用户名
        * 第四个参数为加密次数
        * 最后用toHex()方法将加密后的密码转成String
        * */
        String newPs = new SimpleHash("MD5", password, salt, 2).toHex().toUpperCase();

        userInfoVO.setPassword(newPs);
        userInfoVO.setSalt(salt.toString());
        this.insert(userInfoVO);
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
