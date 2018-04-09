package com.ifarm.console.mapper;

import com.ifarm.console.shared.domain.dto.RoleInfoVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 **/
@Repository
public interface RoleMapper {

    List<RoleInfoVO> findByParam(RoleInfoVO roleInfoVO);

    long totalCount(RoleInfoVO roleInfoVO);

    RoleInfoVO findByRoleCode(String roleCode);

    int update(RoleInfoVO roleInfoVO);

    int insert(RoleInfoVO roleInfoVO);
}
