package com.ifarm.console.shared.domain.po;



/**
 *
 */
public class PermissionPO extends BasePO {

    private static final long serialVersionUID = -2120352962372802682L;

    private Integer resourceTid;
    private String permission;

    public Integer getResourceTid() {
        return resourceTid;
    }

    public void setResourceTid(Integer resourceTid) {
        this.resourceTid = resourceTid;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
