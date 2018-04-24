package com.ifarm.console.facade.service;

import com.ifarm.console.shared.domain.vo.RoleInfoVO;


/**
 *
 */
public interface IRoleInfoService {

    RoleInfoVO findByParam(RoleInfoVO roleInfoVO);

    RoleInfoVO findByRoleCode(String roleCode);

    long totalCount(RoleInfoVO roleInfoVO);

    int delete(String roleCode);

    int update(RoleInfoVO roleInfoVO);

    int insert(RoleInfoVO roleInfoVO);
}
