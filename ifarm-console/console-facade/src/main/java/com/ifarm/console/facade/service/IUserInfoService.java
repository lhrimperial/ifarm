package com.ifarm.console.facade.service;

import com.ifarm.console.shared.domain.dto.UserInfoVO;

/**
 *
 **/
public interface IUserInfoService {

    UserInfoVO findByUserName(String userName);
}
