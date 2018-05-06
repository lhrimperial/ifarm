package com.ifarm.console.facade.service;

import com.ifarm.console.shared.domain.dto.ResourceDTO;
import com.ifarm.console.shared.domain.vo.PermissionVO;
import com.ifarm.console.shared.domain.vo.ResourceVO;

import java.util.List;
import java.util.Map;


/**
 *
 */
public interface IResourceService {

    List<Map<String, String>> findMenuSelectStore();

    List<ResourceDTO> findByParentCode(String parentCode);

    List<ResourceDTO> findMenuByUserAndParent(String parentCode);

    List<ResourceDTO> findMenuByUserName(String userName);

    ResourceVO findByParam(ResourceVO resourceVO);

    ResourceDTO findById(Integer id);

    int delete(ResourceVO resourceVO);

    int update(ResourceVO resourceVO);

    int insert(ResourceVO resourceVO);

    int insertPermission(PermissionVO permissionVO);

    int updatePermission(PermissionVO permissionVO);

    int deletePermission(PermissionVO permissionVO);
}
