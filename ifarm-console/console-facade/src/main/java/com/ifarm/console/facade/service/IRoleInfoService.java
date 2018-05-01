package com.ifarm.console.facade.service;

import com.ifarm.console.shared.domain.dto.RoleInfoDTO;
import com.ifarm.console.shared.domain.vo.RoleInfoVO;


/**
 *
 */
public interface IRoleInfoService {

    RoleInfoDTO findById(Integer tid);

    RoleInfoVO findByParam(RoleInfoVO roleInfoVO);

    int delete(RoleInfoVO roleInfoVO);

    int update(RoleInfoVO roleInfoVO);

    int insert(RoleInfoVO roleInfoVO);
}
