package com.ifarm.console.shared.domain.vo;

import com.ifarm.console.shared.domain.dto.PermissionDTO;

import java.util.List;

/**
 *
 **/
public class PermissionVO extends BaseVO {

    private List<Integer> ids;
    private PermissionDTO permissionDTO;

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
