package com.ifarm.console.mapper;

import com.ifarm.console.shared.domain.po.UserInfoPO;
import com.ifarm.console.shared.domain.po.UserRolePO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 **/
@Repository
public interface UserMapper {

    UserInfoPO findById(Integer tid);

    List<UserInfoPO> findByParam(UserInfoPO userInfoPO);

    long totalCount(UserInfoPO userInfoPO);

    UserInfoPO findByUserName(String userName);

    UserInfoPO findLoginUser(String userName);

    int updateActive(@Param("ids") List<Integer> ids, @Param("active") String active);

    int update(UserInfoPO userInfoPO);

    int insert(UserInfoPO userInfoPO);

    int saveUserRoleBatch(List<UserRolePO> list);

    int deleteUserRole(Integer userId);
}
