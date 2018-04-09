package com.ifarm.console.shared.domain.dto;

import com.github.framework.server.shared.domain.vo.BaseVO;

/**
 *
 */
public class RoleInfoVO extends BaseVO {

    private static final long serialVersionUID = 6418679032872085882L;
    private String roleCode;
    private String roleName;
    private String notes;

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
