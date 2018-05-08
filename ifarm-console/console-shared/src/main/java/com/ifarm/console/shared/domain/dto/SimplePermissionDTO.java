package com.ifarm.console.shared.domain.dto;

/**
 *
 **/
public class SimplePermissionDTO {
    private Integer tid;
    private Integer resourceTid;
    private String permissionCode;
    private String permissionName;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getResourceTid() {
        return resourceTid;
    }

    public void setResourceTid(Integer resourceTid) {
        this.resourceTid = resourceTid;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
}
