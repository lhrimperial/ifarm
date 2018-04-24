package com.ifarm.console.shared.domain.vo;


import java.io.Serializable;

/**
 * 基础视图对象
 */
public class BaseVO implements Serializable {

    private static final long serialVersionUID = 1615483319438201092L;
    private Integer page = 1;
    private Integer start = 0;
    private Integer limit = 10;
    private Long totalCount;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}
