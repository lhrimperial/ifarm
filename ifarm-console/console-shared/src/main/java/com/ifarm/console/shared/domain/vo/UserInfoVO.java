package com.ifarm.console.shared.domain.vo;

import com.ifarm.console.shared.domain.dto.ResourceDTO;
import com.ifarm.console.shared.domain.dto.UserInfoDTO;

import java.util.List;

/**
 *
 */
public class UserInfoVO extends BaseVO {

    private List<Integer> ids;
    private UserInfoDTO userInfoDTO;
    private List<UserInfoDTO> userInfoDTOS;
    private List<ResourceDTO> userMenus;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public List<ResourceDTO> getUserMenus() {
        return userMenus;
    }

    public void setUserMenus(List<ResourceDTO> userMenus) {
        this.userMenus = userMenus;
    }

    public UserInfoDTO getUserInfoDTO() {
        return userInfoDTO;
    }

    public void setUserInfoDTO(UserInfoDTO userInfoDTO) {
        this.userInfoDTO = userInfoDTO;
    }

    public List<UserInfoDTO> getUserInfoDTOS() {
        return userInfoDTOS;
    }

    public void setUserInfoDTOS(List<UserInfoDTO> userInfoDTOS) {
        this.userInfoDTOS = userInfoDTOS;
    }
}
