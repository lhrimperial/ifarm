package com.ifarm.console.shared.domain.vo;

import com.ifarm.console.shared.domain.dto.PermissionDTO;

import java.util.List;

/**
 *
 **/
public class PermissionVO extends BaseVO {

    private String resourceCode;
    private List<Integer> ids;
    private PermissionDTO permissionDTO;

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public PermissionDTO getPermissionDTO() {
        return permissionDTO;
    }

    public void setPermissionDTO(PermissionDTO permissionDTO) {
        this.permissionDTO = permissionDTO;
    }
}
