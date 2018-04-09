package com.ifarm.console.shared.domain.dto;

import com.github.framework.server.shared.domain.vo.BaseVO;

/**
 *
 */
public class RolePermissionVO extends BaseVO {
    private static final long serialVersionUID = -4206688119323330958L;

    private String roleCode;
    private Integer resActionId;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public Integer getResActionId() {
        return resActionId;
    }

    public void setResActionId(Integer resActionId) {
        this.resActionId = resActionId;
    }
}
