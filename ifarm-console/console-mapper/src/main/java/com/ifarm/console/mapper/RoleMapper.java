package com.ifarm.console.mapper;

import com.ifarm.console.shared.domain.po.RoleInfoPO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 **/
@Repository
public interface RoleMapper {

    List<RoleInfoPO> findByParam(RoleInfoPO roleInfoPO);

    long totalCount(RoleInfoPO roleInfoPO);

    RoleInfoPO findByRoleCode(String roleCode);

    int update(RoleInfoPO roleInfoPO);

    int insert(RoleInfoPO roleInfoPO);
}
