package com.ifarm.console.shared.domain.po;


import com.github.framework.util.serializer.BeanCopyUtils;
import com.ifarm.console.shared.domain.dto.PermissionDTO;

/**
 *
 */
public class PermissionPO extends BasePO {

    private static final long serialVersionUID = -2120352962372802682L;

    private Integer resourceTid;
    private String permissionCode;
    private String permissionName;
    private boolean editAble;

    public PermissionDTO convertDTO() {
        PermissionDTO dto = new PermissionDTO();
        BeanCopyUtils.copyBean(this, dto);
        return dto;
    }

    public boolean isEditAble() {
        return editAble;
    }

    public void setEditAble(boolean editAble) {
        this.editAble = editAble;
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
