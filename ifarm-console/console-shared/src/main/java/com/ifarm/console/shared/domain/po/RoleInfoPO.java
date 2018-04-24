package com.ifarm.console.shared.domain.po;



import com.github.framework.util.serializer.BeanCopyUtils;
import com.ifarm.console.shared.domain.dto.RoleInfoDTO;

import java.util.List;

/**
 *
 */
public class RoleInfoPO extends BasePO {

    private static final long serialVersionUID = 6418679032872085882L;
    private String roleCode;
    private String roleName;
    private String notes;

    private List<String> permission;

    public RoleInfoDTO convertDTO() {
        RoleInfoDTO roleInfoDTO = new RoleInfoDTO();
        BeanCopyUtils.copyBean(this, roleInfoDTO);
        return roleInfoDTO;
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
