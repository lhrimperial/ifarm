package com.ifarm.console.facade.service;

import com.ifarm.console.shared.domain.dto.ResourceDTO;
import com.ifarm.console.shared.domain.vo.ResourceVO;

import java.util.List;


/**
 *
 */
public interface IResourceService {

    List<ResourceDTO> findByParentCode(String parentCode);

    List<ResourceDTO> findMenuByUserName(String userName);

    ResourceVO findByParam(ResourceVO resourceVO);

    ResourceDTO findById(Integer id);

    int delete(ResourceVO resourceVO);

    int update(ResourceVO resourceVO);

    int insert(ResourceVO resourceVO);
}
