package com.ifarm.console.mapper;

import com.ifarm.console.shared.domain.dto.ResourceVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 **/
@Repository
public interface ResourceMapper {

    List<ResourceVO> findMenuResources(String userName);

    List<ResourceVO> findByParam(ResourceVO resourceVO);

    long totalCount(ResourceVO resourceVO);

    ResourceVO findByResCode(String resCode);

    int update(ResourceVO resourceVO);

    int insert(ResourceVO resourceVO);
}
