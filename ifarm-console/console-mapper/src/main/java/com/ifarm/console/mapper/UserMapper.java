package com.ifarm.console.mapper;

import com.ifarm.console.shared.domain.dto.UserInfoVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 **/
@Repository
public interface UserMapper {

    List<UserInfoVO> findByParam(UserInfoVO userInfoVO);

    long totalCount(UserInfoVO userInfoVO);

    UserInfoVO findByUserName(String userName);

    UserInfoVO findLoginUser(String userName);

    int update(UserInfoVO userInfoVO);

    int insert(UserInfoVO userInfoVO);
}
