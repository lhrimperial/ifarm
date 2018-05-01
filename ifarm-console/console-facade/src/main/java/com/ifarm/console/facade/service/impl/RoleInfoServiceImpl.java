package com.ifarm.console.facade.service.impl;

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
    public RoleInfoDTO findById(Integer tid) {
        RoleInfoDTO roleInfoDTO = null;
        if (tid == null) {
            throw new IllegalArgumentException("参数不能为空");
        }
        RoleInfoPO roleInfoPO = roleMapper.findById(tid);
        if (roleInfoPO != null) {
            roleInfoDTO = roleInfoPO.convertDTO();
        }
        return roleInfoDTO;
    }

    @Override
    public RoleInfoVO findByParam(RoleInfoVO roleInfoVO) {
        this.check(roleInfoVO);
        //query
        PageHelper.startPage(roleInfoVO.getPageNo(), roleInfoVO.getPageSize());
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
    public int delete(RoleInfoVO roleInfoVO) {
        if (roleInfoVO == null) {
            throw new IllegalArgumentException("参数不能为空!");
        }
        List<Integer> ids = roleInfoVO.getIds();
        if (ids == null || ids.isEmpty()) {
            return 0;
        }
        return roleMapper.updateActiveByIds(ids, IFarmConstants.INACTIVE);
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
