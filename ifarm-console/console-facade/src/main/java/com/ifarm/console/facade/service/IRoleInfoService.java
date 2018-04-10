package com.ifarm.console.facade.service;

import com.ifarm.console.shared.domain.dto.RoleInfoVO;

import java.util.List;

/**
 *
 */
public interface IRoleInfoService {

    List<RoleInfoVO> findByParam(RoleInfoVO roleInfoVO);

    RoleInfoVO findByRoleCode(String roleCode);

    long totalCount(RoleInfoVO roleInfoVO);

    int delete(String roleCode);

    int update(RoleInfoVO roleInfoVO);

    int insert(RoleInfoVO roleInfoVO);
}
