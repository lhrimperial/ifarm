package com.ifarm.console.facade.service.impl;

import com.github.framework.util.string.StringUtils;
import com.github.pagehelper.PageHelper;
import com.ifarm.console.facade.service.IResourceService;
import com.ifarm.console.mapper.ResourceMapper;
import com.ifarm.console.shared.define.IFarmConstants;
import com.ifarm.console.shared.domain.dto.ResourceDTO;
import com.ifarm.console.shared.domain.po.ResourcePO;
import com.ifarm.console.shared.domain.vo.ResourceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
@Service
public class ResourceServiceImpl implements IResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    private void check(ResourceVO resourceVO) {
        if (resourceVO == null || resourceVO.getResourceDTO() == null) {
            throw new IllegalArgumentException("参数不能为空！");
        }
    }

    @Override
    public List<ResourceDTO> findMenuByUserName(String userName) {
        if (StringUtils.isBlank(userName)) {
            throw new IllegalArgumentException("参数不能为空!");
        }
        List<ResourceDTO> result = new ArrayList<>();
        List<ResourcePO> resourcePOS = resourceMapper.findMenuResources(userName);
        for (ResourcePO po : resourcePOS) {
            result.add(po.convertDTO());
        }
        return result;
    }

    @Override
    public ResourceVO findByParam(ResourceVO resourceVO) {
        this.check(resourceVO);
        //query
        List<ResourceDTO> result = new ArrayList<>();
        ResourcePO resourcePO = resourceVO.getResourceDTO().convertPO();
        PageHelper.startPage(resourceVO.getPage(), resourceVO.getLimit());
        List<ResourcePO> resourcePOS = resourceMapper.findByParam(resourcePO);
        for (ResourcePO po : resourcePOS) {
            result.add(po.convertDTO());
        }
        resourceVO.setResourceDTOS(result);
        resourceVO.setTotalCount(resourceMapper.totalCount(resourcePO));
        return resourceVO;
    }

    @Override
    public ResourceVO findByResCode(String resCode) {
        if (StringUtils.isBlank(resCode)){
            throw new IllegalArgumentException("参数不能为空！");
        }
        ResourceVO resourceVO = new ResourceVO();
        ResourcePO resourcePO = resourceMapper.findByResCode(resCode);
        if (resourcePO != null) {
            resourceVO.setResourceDTO(resourcePO.convertDTO());
        }
        return resourceVO;
    }

    @Override
    public long totalCount(ResourceVO resourceVO) {
        this.check(resourceVO);
        //query
        ResourcePO resourcePO =  resourceVO.getResourceDTO().convertPO();
        return resourceMapper.totalCount(resourcePO);
    }

    @Override
    public int delete(String resCode) {
        if (StringUtils.isBlank(resCode)){
            throw new IllegalArgumentException("参数不能为空！");
        }
        ResourcePO resourcePO = new ResourcePO();
        resourcePO.setResourceCode(resCode);
        resourcePO.setModifyTime(new Date());
        resourcePO.setActive(IFarmConstants.INACTIVE);
        return resourceMapper.update(resourcePO);
    }

    @Override
    public int update(ResourceVO resourceVO) {
        this.check(resourceVO);
        //update
        ResourcePO resourcePO = resourceVO.getResourceDTO().convertPO();
        resourcePO.setModifyTime(new Date());
        return resourceMapper.update(resourcePO);
    }

    @Override
    public int insert(ResourceVO resourceVO) {
        this.check(resourceVO);
        //insert
        ResourcePO resourcePO = resourceVO.getResourceDTO().convertPO();
        resourcePO.setActive(IFarmConstants.ACTIVE);
        resourcePO.setCreateTime(new Date());
        resourcePO.setModifyTime(new Date());
        return resourceMapper.insert(resourcePO);
    }
}
