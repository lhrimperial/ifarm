package com.ifarm.console.mapper;

import com.ifarm.console.shared.domain.po.ResourcePO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 **/
@Repository
public interface ResourceMapper {

    List<ResourcePO> findByParentCode(@Param("parentCode") String parentCode);

    List<ResourcePO> findMenuResources(String userName);

    List<ResourcePO> findByParam(ResourcePO resourcePO);

    long totalCount(ResourcePO resourcePO);

    ResourcePO findByById(Integer id);

    int updateActiveByIds(@Param("ids") List<Integer> ids, @Param("active") String active);

    int update(ResourcePO resourcePO);

    int insert(ResourcePO resourcePO);
}
