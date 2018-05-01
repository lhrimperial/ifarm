package com.ifarm.console.shared.domain.vo;


import java.io.Serializable;

/**
 * 基础视图对象
 */
public class BaseVO implements Serializable {

    private static final long serialVersionUID = 1615483319438201092L;
    private Integer pageNo = 1;
    private Integer pageSize = 10;
    private Long totalCount;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}
