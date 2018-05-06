package com.ifarm.console.shared.domain.dto;


import com.github.framework.util.serializer.BeanCopyUtils;
import com.ifarm.console.shared.domain.po.PermissionPO;

/**
 *
 */
public class PermissionDTO extends BaseDTO {

    private static final long serialVersionUID = -2120352962372802682L;

    private Integer resourceTid;
    private String permissionCode;
    private String permissionName;

    public PermissionPO convertPO() {
        PermissionPO po = new PermissionPO();
        BeanCopyUtils.copyBean(this, po);
        return po;
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
