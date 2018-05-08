package com.ifarm.console.shared.domain.dto;

import java.util.List;

/**
 *
 **/
public class SimpleResourceDTO {
    private Integer tid;
    private String resourceCode;
    private String resourceName;
    private String leafFlag;
    private List<SimpleResourceDTO> childrenNodes;
    private List<SimplePermissionDTO> permissions;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getLeafFlag() {
        return leafFlag;
    }

    public void setLeafFlag(String leafFlag) {
        this.leafFlag = leafFlag;
    }

    public List<SimpleResourceDTO> getChildrenNodes() {
        return childrenNodes;
    }

    public void setChildrenNodes(List<SimpleResourceDTO> childrenNodes) {
        this.childrenNodes = childrenNodes;
    }

    public List<SimplePermissionDTO> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SimplePermissionDTO> permissions) {
        this.permissions = permissions;
    }
}
