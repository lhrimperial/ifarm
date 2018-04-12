package com.ifarm.console.shared.domain.dto;

import com.github.framework.server.shared.domain.vo.BaseVO;

/**
 *
 */
public class UserRoleVO extends BaseVO{
    private static final long serialVersionUID = 3371204090150138391L;
    private Integer userTid;
    private Integer roleTid;

    public Integer getUserTid() {
        return userTid;
    }

    public void setUserTid(Integer userTid) {
        this.userTid = userTid;
    }

    public Integer getRoleTid() {
        return roleTid;
    }

    public void setRoleTid(Integer roleTid) {
        this.roleTid = roleTid;
    }
}
