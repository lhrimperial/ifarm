package com.ifarm.console.facade.service;

import com.ifarm.console.shared.domain.dto.RoleInfoDTO;
import com.ifarm.console.shared.domain.vo.RoleInfoVO;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 *
 */
public interface IRoleInfoService {

    List<RoleInfoDTO> findAllRole();

    List<RoleInfoDTO> findRoleByUserId(Integer userId);

    RoleInfoDTO findById(Integer tid);

    RoleInfoVO findByParam(RoleInfoVO roleInfoVO);

    int delete(RoleInfoVO roleInfoVO);

    int update(RoleInfoVO roleInfoVO);

    int insert(RoleInfoVO roleInfoVO);
}
