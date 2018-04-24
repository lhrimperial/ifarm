package com.ifarm.console.facade.service;

import com.ifarm.console.shared.domain.dto.ResourceDTO;
import com.ifarm.console.shared.domain.vo.ResourceVO;

import java.util.List;


/**
 *
 */
public interface IResourceService {

    List<ResourceDTO> findMenuByUserName(String userName);

    ResourceVO findByParam(ResourceVO resourceVO);

    ResourceVO findByResCode(String resCode);

    long totalCount(ResourceVO resourceVO);

    int delete(String resCode);

    int update(ResourceVO resourceVO);

    int insert(ResourceVO resourceVO);
}
