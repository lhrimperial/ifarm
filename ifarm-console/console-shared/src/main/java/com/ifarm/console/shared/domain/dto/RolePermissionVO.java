package com.ifarm.console.shared.domain.dto;

import com.github.framework.server.shared.domain.vo.BaseVO;

/**
 *
 */
public class RolePermissionVO extends BaseVO {
    private static final long serialVersionUID = -4206688119323330958L;

    private Integer roleTid;
    private Integer permissionTid;

    public Integer getRoleTid() {
        return roleTid;
    }

    public void setRoleTid(Integer roleTid) {
        this.roleTid = roleTid;
    }

    public Integer getPermissionTid() {
        return permissionTid;
    }

    public void setPermissionTid(Integer permissionTid) {
        this.permissionTid = permissionTid;
    }
}
