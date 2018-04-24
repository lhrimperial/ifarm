package com.ifarm.console.facade.service;

import com.ifarm.console.shared.domain.dto.UserInfoDTO;
import com.ifarm.console.shared.domain.vo.UserInfoVO;


/**
 *
 **/
public interface IUserInfoService {

    UserInfoVO findByParam(UserInfoVO userInfoVO);

    long totalCount(UserInfoVO userInfoVO);

    UserInfoDTO findByUserName(String userName);

    UserInfoDTO findLoginUser(String userName);

    void changePassword(UserInfoVO userInfoVO);

    void register(UserInfoVO userInfoVO);

    int delete(String userName);

    int update(UserInfoVO userInfoVO);

    int insert(UserInfoVO userInfoVO);
}
