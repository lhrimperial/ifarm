package com.ifarm.console.facade.service;

import com.ifarm.console.shared.domain.dto.ResourceDTO;
import com.ifarm.console.shared.domain.dto.SimpleResourceDTO;
import com.ifarm.console.shared.domain.vo.PermissionVO;
import com.ifarm.console.shared.domain.vo.ResourceVO;

import java.util.List;
import java.util.Map;


/**
 *
 */
public interface IResourceService {

    int distributePermission(ResourceVO resourceVO);

    List<SimpleResourceDTO> findAllDistributeResource();

    List<SimpleResourceDTO> findRoleDistributeResource(Integer roleId);

    List<Map<String, String>> findMenuSelectStore();

    List<ResourceDTO> findByParentCode(String parentCode);

    List<ResourceDTO> findMenuByUserAndParent(String parentCode);

    List<ResourceDTO> findMenuByUserName(String userName);

    List<String> userPermission(String userName);

    ResourceVO findByParam(ResourceVO resourceVO);

    ResourceDTO findById(Integer id);

    ResourceDTO findByCode(String resourceCode);

    int delete(ResourceVO resourceVO);

    ResourceDTO update(ResourceVO resourceVO);

    ResourceDTO insert(ResourceVO resourceVO);

    ResourceDTO insertPermission(PermissionVO permissionVO);

    ResourceDTO updatePermission(PermissionVO permissionVO);

    ResourceDTO deletePermission(PermissionVO permissionVO);
}
