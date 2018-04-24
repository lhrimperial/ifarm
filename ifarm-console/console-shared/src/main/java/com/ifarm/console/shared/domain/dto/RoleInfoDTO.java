package com.ifarm.console.shared.domain.dto;


import com.github.framework.util.serializer.BeanCopyUtils;
import com.ifarm.console.shared.domain.po.RoleInfoPO;

import java.util.List;

/**
 *
 */
public class RoleInfoDTO extends BaseDTO {

    private static final long serialVersionUID = 6418679032872085882L;
    private String roleCode;
    private String roleName;
    private String notes;

    private List<String> permission;

    public RoleInfoPO convertPO() {
        RoleInfoPO roleInfoPO = new RoleInfoPO();
        BeanCopyUtils.copyBean(this, roleInfoPO);
        return roleInfoPO;
    }

    public List<String> getPermission() {
        return permission;
    }

    public void setPermission(List<String> permission) {
        this.permission = permission;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
