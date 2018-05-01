package com.ifarm.console.shared.domain.vo;

import com.ifarm.console.shared.domain.dto.RoleInfoDTO;

import java.util.List;

/**
 *
 */
public class RoleInfoVO extends BaseVO {

    private List<Integer> ids;
    private RoleInfoDTO roleInfoDTO;
    private List<RoleInfoDTO> roleInfoDTOS;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public RoleInfoDTO getRoleInfoDTO() {
        return roleInfoDTO;
    }

    public void setRoleInfoDTO(RoleInfoDTO roleInfoDTO) {
        this.roleInfoDTO = roleInfoDTO;
    }

    public List<RoleInfoDTO> getRoleInfoDTOS() {
        return roleInfoDTOS;
    }

    public void setRoleInfoDTOS(List<RoleInfoDTO> roleInfoDTOS) {
        this.roleInfoDTOS = roleInfoDTOS;
    }
}
