package com.ifarm.console.shared.domain.dto;

import com.github.framework.server.shared.domain.vo.BaseVO;

/**
 *
 */
public class ResActionVO extends BaseVO {

    private static final long serialVersionUID = -2120352962372802682L;

    private String resourceCode;
    private String resourceAction;

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public String getResourceAction() {
        return resourceAction;
    }

    public void setResourceAction(String resourceAction) {
        this.resourceAction = resourceAction;
    }
}
