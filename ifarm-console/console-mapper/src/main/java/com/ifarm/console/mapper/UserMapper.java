package com.ifarm.console.mapper;

import com.ifarm.console.shared.domain.po.UserInfoPO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 **/
@Repository
public interface UserMapper {

    List<UserInfoPO> findByParam(UserInfoPO userInfoPO);

    long totalCount(UserInfoPO userInfoPO);

    UserInfoPO findByUserName(String userName);

    UserInfoPO findLoginUser(String userName);

    int update(UserInfoPO userInfoPO);

    int insert(UserInfoPO userInfoPO);
}
