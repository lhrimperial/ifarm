package com.ifarm.console.shared.domain.po;


import java.io.Serializable;
import java.util.Date;

/**
 * 基础持久化对象
 */
public class BasePO implements Serializable {

    private static final long serialVersionUID = -2923004833770597362L;
    private Integer tid;
    private String active;
    private String createUser;
    private String modifyUser;
    private Date createTime;
    private Date modifyTime;

    public BasePO(){}

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
