package com.ifarm.console.shared.domain.dto;

import java.util.List;

/**
 *
 **/
public class SimpleResourceDTO {
    private Integer tid;
    private String code;
    private String label;
    private String isLeaf;
    private List<SimpleResourceDTO> children;
    private List<SimplePermissionDTO> permissions;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf;
    }

    public List<SimpleResourceDTO> getChildren() {
        return children;
    }

    public void setChildren(List<SimpleResourceDTO> children) {
        this.children = children;
    }

    public List<SimplePermissionDTO> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SimplePermissionDTO> permissions) {
        this.permissions = permissions;
    }
}
