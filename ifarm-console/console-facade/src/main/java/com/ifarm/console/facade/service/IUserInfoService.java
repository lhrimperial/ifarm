package com.ifarm.console.facade.service;

import com.ifarm.console.shared.domain.dto.UserInfoVO;

import java.util.List;

/**
 *
 **/
public interface IUserInfoService {

    List<UserInfoVO> findByParam(UserInfoVO userInfoVO);

    long totalCount(UserInfoVO userInfoVO);

    UserInfoVO findByUserName(String userName);

    void changePassword(UserInfoVO userInfoVO);

    void register(UserInfoVO userInfoVO);

    int delete(String userName);

    int update(UserInfoVO userInfoVO);

    int insert(UserInfoVO userInfoVO);
}
