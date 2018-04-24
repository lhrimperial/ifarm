package com.ifarm.console.facade.service.impl;

import com.github.framework.util.string.StringUtils;
import com.github.pagehelper.PageHelper;
import com.ifarm.console.facade.service.IRoleInfoService;
import com.ifarm.console.mapper.RoleMapper;
import com.ifarm.console.shared.define.IFarmConstants;
import com.ifarm.console.shared.domain.dto.RoleInfoDTO;
import com.ifarm.console.shared.domain.po.RoleInfoPO;
import com.ifarm.console.shared.domain.vo.RoleInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
@Service
public class RoleInfoServiceImpl implements IRoleInfoService {

    @Autowired
    private RoleMapper roleMapper;

    private void check(RoleInfoVO roleInfoVO) {
        if (roleInfoVO == null || roleInfoVO.getRoleInfoDTO() == null) {
            throw new IllegalArgumentException("参数不能为空!");
        }
    }

    @Override
    public RoleInfoVO findByParam(RoleInfoVO roleInfoVO) {
        this.check(roleInfoVO);
        //query
        PageHelper.startPage(roleInfoVO.getPage(), roleInfoVO.getLimit());
        RoleInfoPO roleInfoPO = roleInfoVO.getRoleInfoDTO().convertPO();
        List<RoleInfoDTO> result = new ArrayList<>();
        List<RoleInfoPO> roleInfoPOS = roleMapper.findByParam(roleInfoPO);
        for (RoleInfoPO po : roleInfoPOS) {
            result.add(po.convertDTO());
        }
        roleInfoVO.setTotalCount(roleMapper.totalCount(roleInfoPO));
        roleInfoVO.setRoleInfoDTOS(result);
        return roleInfoVO;
    }

    @Override
    public RoleInfoVO findByRoleCode(String roleCode) {
        if (StringUtils.isBlank(roleCode)) {
            throw new IllegalArgumentException("参数不能为空!");
        }
        RoleInfoVO roleInfoVO = new RoleInfoVO();
        RoleInfoPO roleInfoPO = roleMapper.findByRoleCode(roleCode);
        if (roleInfoPO != null) {
            roleInfoVO.setRoleInfoDTO(roleInfoPO.convertDTO());
        }
        return roleInfoVO;
    }

    @Override
    public long totalCount(RoleInfoVO roleInfoVO) {
        this.check(roleInfoVO);
        //query
        RoleInfoPO roleInfoPO = roleInfoVO.getRoleInfoDTO().convertPO();
        return roleMapper.totalCount(roleInfoPO);
    }

    @Override
    public int delete(String roleCode) {
        if (StringUtils.isBlank(roleCode)) {
            throw new IllegalArgumentException("参数不能为空!");
        }
        RoleInfoPO roleInfoVO = new RoleInfoPO();
        roleInfoVO.setActive(IFarmConstants.INACTIVE);
        roleInfoVO.setRoleCode(roleCode);
        roleInfoVO.setModifyTime(new Date());
        return roleMapper.update(roleInfoVO);
    }

    @Override
    public int update(RoleInfoVO roleInfoVO) {
        this.check(roleInfoVO);
        //update
        RoleInfoPO roleInfoPO = roleInfoVO.getRoleInfoDTO().convertPO();
        roleInfoPO.setModifyTime(new Date());
        return roleMapper.update(roleInfoPO);
    }

    @Override
    public int insert(RoleInfoVO roleInfoVO) {
        this.check(roleInfoVO);
        RoleInfoPO roleInfoPO = roleInfoVO.getRoleInfoDTO().convertPO();
        roleInfoPO.setCreateTime(new Date());
        roleInfoPO.setModifyTime(new Date());
        roleInfoPO.setActive(IFarmConstants.ACTIVE);
        return roleMapper.insert(roleInfoPO);
    }
}
