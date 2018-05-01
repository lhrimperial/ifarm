package com.ifarm.console.mapper;

import com.ifarm.console.shared.domain.po.RoleInfoPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 **/
@Repository
public interface RoleMapper {

    List<RoleInfoPO> findByParam(RoleInfoPO roleInfoPO);

    long totalCount(RoleInfoPO roleInfoPO);

    RoleInfoPO findById(Integer tid);

    int updateActiveByIds(@Param("ids") List<Integer> ids, @Param("active") String active);

    int update(RoleInfoPO roleInfoPO);

    int insert(RoleInfoPO roleInfoPO);
}
