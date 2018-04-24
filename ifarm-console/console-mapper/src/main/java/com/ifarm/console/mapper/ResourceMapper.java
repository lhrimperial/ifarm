package com.ifarm.console.mapper;

import com.ifarm.console.shared.domain.po.ResourcePO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 **/
@Repository
public interface ResourceMapper {

    List<ResourcePO> findMenuResources(String userName);

    List<ResourcePO> findByParam(ResourcePO resourcePO);

    long totalCount(ResourcePO resourcePO);

    ResourcePO findByResCode(String resCode);

    int update(ResourcePO resourcePO);

    int insert(ResourcePO resourcePO);
}
