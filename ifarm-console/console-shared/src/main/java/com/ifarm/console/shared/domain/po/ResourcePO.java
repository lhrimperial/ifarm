package com.ifarm.console.shared.domain.po;



import com.github.framework.util.serializer.BeanCopyUtils;
import com.ifarm.console.shared.domain.dto.ResourceDTO;

import java.util.List;

/**
 *
 */
public class ResourcePO extends BasePO {

    private static final long serialVersionUID = 2374775121155910833L;
    private String resourceCode;
    private String resourceName;
    private String entryUrl;
    private String parentCode;
    private Integer resourceLevel;
    private Integer resourceType;
    private Integer displayOrder;
    private String nodeIcon;
    private String leafFlag;
    private String notes;

    private List<ResourcePO> childrenNode;

    public ResourceDTO convertDTO() {
        ResourceDTO resourceDTO = new ResourceDTO();
        BeanCopyUtils.copyBean(this, resourceDTO);
        return resourceDTO;
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

    public String getEntryUrl() {
        return entryUrl;
    }

    public void setEntryUrl(String entryUrl) {
        this.entryUrl = entryUrl;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public Integer getResourceLevel() {
        return resourceLevel;
    }

    public void setResourceLevel(Integer resourceLevel) {
        this.resourceLevel = resourceLevel;
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getNodeIcon() {
        return nodeIcon;
    }

    public void setNodeIcon(String nodeIcon) {
        this.nodeIcon = nodeIcon;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<ResourcePO> getChildrenNode() {
        return childrenNode;
    }

    public void setChildrenNode(List<ResourcePO> childrenNode) {
        this.childrenNode = childrenNode;
    }

    public String getLeafFlag() {
        return leafFlag;
    }

    public void setLeafFlag(String leafFlag) {
        this.leafFlag = leafFlag;
    }
}
