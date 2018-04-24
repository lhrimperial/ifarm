package com.ifarm.console.shared.domain.po;



/**
 *
 */
public class RolePermissionPO extends BasePO {
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
