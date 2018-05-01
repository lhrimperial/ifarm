package com.ifarm.console.shared.domain.dto;

import java.io.Serializable;

/**
 *
 */
public class BaseDTO implements Serializable {
    private static final long serialVersionUID = -5202513974647431318L;

    private Integer tid;
    private String active;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
