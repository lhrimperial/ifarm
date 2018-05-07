package com.ifarm.console.facade.service.impl;

import com.github.framework.util.string.StringUtils;
import com.github.pagehelper.PageHelper;
import com.ifarm.console.facade.context.ConsoleContext;
import com.ifarm.console.facade.service.IResourceService;
import com.ifarm.console.mapper.ResourceMapper;
import com.ifarm.console.shared.define.IFarmConstants;
import com.ifarm.console.shared.domain.dto.ResourceDTO;
import com.ifarm.console.shared.domain.po.PermissionPO;
import com.ifarm.console.shared.domain.po.ResourcePO;
import com.ifarm.console.shared.domain.vo.PermissionVO;
import com.ifarm.console.shared.domain.vo.ResourceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    public List<Map<String, String>> findMenuSelectStore() {
        return resourceMapper.findMenuSelectStore();
    }

    @Override
    public List<ResourceDTO> findByParentCode(String parentCode) {
        List<ResourceDTO> resourceDTOS = null;
        if (StringUtils.isBlank(parentCode)) {
            parentCode = "root";
        }
        List<ResourcePO> list = resourceMapper.findByParentCode(parentCode);
        if (list != null && !list.isEmpty()) {
            resourceDTOS = new ArrayList<>(list.size());
            for (ResourcePO po : list) {
                resourceDTOS.add(po.convertDTO());
            }
        }
        return resourceDTOS;
    }

    @Override
    public List<ResourceDTO> findMenuByUserAndParent(String parentCode) {
        if (StringUtils.isBlank(parentCode)) {
            parentCode = IFarmConstants.MENU_ROOT;
        }
        String userName = ConsoleContext.getCurrentUserName();
        List<ResourcePO> list = resourceMapper.findMenuByUserAndParent(userName, parentCode);
        List<ResourceDTO> result = new ArrayList<>();
        for (ResourcePO po : list) {
            result.add(po.convertDTO());
        }
        return result;
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
        PageHelper.startPage(resourceVO.getPageNo(), resourceVO.getPageSize());
        List<ResourcePO> resourcePOS = resourceMapper.findByParam(resourcePO);
        for (ResourcePO po : resourcePOS) {
            result.add(po.convertDTO());
        }
        resourceVO.setResourceDTOS(result);
        resourceVO.setTotalCount(resourceMapper.totalCount(resourcePO));
        return resourceVO;
    }

    @Override
    public ResourceDTO findById(Integer id) {
        if (id == null){
            throw new IllegalArgumentException("参数不能为空！");
        }
        ResourceDTO resourceDTO = null;
        ResourcePO resourcePO = resourceMapper.findByById(id);
        if (resourcePO != null) {
            resourceDTO= resourcePO.convertDTO();
        }
        return resourceDTO;
    }

    @Override
    public ResourceDTO findByCode(String resourceCode) {
        ResourceDTO resourceDTO = null;
        if (StringUtils.isBlank(resourceCode)) {
            throw new IllegalArgumentException("resourceCode is empty");
        }
        ResourcePO resourcePO = resourceMapper.findByCode(resourceCode);
        if (resourcePO != null) {
            resourceDTO = resourcePO.convertDTO();
        }
        return resourceDTO;
    }

    @Override
    public int delete(ResourceVO resourceVO) {
        if (resourceVO == null) {
            throw new IllegalArgumentException("参数不能为空");
        }
        List<Integer> ids = resourceVO.getIds();
        if (ids == null || ids.isEmpty()) {
            return 0;
        }
        return resourceMapper.updateActiveByIds(ids, IFarmConstants.INACTIVE);
    }

    @Override
    public ResourceDTO update(ResourceVO resourceVO) {
        this.check(resourceVO);
        //update
        ResourcePO resourcePO = resourceVO.getResourceDTO().convertPO();
        resourcePO.setModifyTime(new Date());
        resourceMapper.update(resourcePO);
        return this.findByCode(resourcePO.getResourceCode());
    }

    @Override
    public ResourceDTO insert(ResourceVO resourceVO) {
        this.check(resourceVO);
        //insert
        ResourcePO resourcePO = resourceVO.getResourceDTO().convertPO();
        resourcePO.setActive(IFarmConstants.ACTIVE);
        resourcePO.setCreateTime(new Date());
        resourcePO.setModifyTime(new Date());
        resourceMapper.insert(resourcePO);

        PermissionPO permissionPO = new PermissionPO();
        permissionPO.setResourceTid(resourcePO.getTid());
        permissionPO.setPermissionCode("/"+resourcePO.getResourceCode()+IFarmConstants.PERMISSION_MENU);
        permissionPO.setPermissionName(resourcePO.getResourceName());
        permissionPO.setCreateTime(new Date());
        resourceMapper.insertPermission(permissionPO);
        return this.findByCode(resourcePO.getResourceCode());
    }

    private void checkPermission(PermissionVO permissionVO) {
        if (permissionVO == null || permissionVO.getPermissionDTO() == null) {
            throw new IllegalArgumentException("参数不能为空");
        }
    }

    @Override
    public int insertPermission(PermissionVO permissionVO) {
        this.checkPermission(permissionVO);
        PermissionPO po = permissionVO.getPermissionDTO().convertPO();
        po.setCreateTime(new Date());
        return resourceMapper.insertPermission(po);
    }

    @Override
    public int updatePermission(PermissionVO permissionVO) {
        this.checkPermission(permissionVO);
        PermissionPO po = permissionVO.getPermissionDTO().convertPO();
        return resourceMapper.updatePermission(po);
    }

    @Override
    public int deletePermission(PermissionVO permissionVO) {
        if (permissionVO == null) {
            throw new IllegalArgumentException("参数不能为空");
        }
        List<Integer> ids = permissionVO.getIds();
        if (ids == null || ids.isEmpty()) {
            return 0;
        }
        return resourceMapper.deletePermission(ids);
    }
}
