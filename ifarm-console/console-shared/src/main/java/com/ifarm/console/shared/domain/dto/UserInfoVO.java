package com.ifarm.console.shared.domain.dto;

/**
 *
 **/
public class UserInfoVO {
    private String userName;
    private String password;
    private String salt;
    public String getCredentialsSalt(){
        return userName + salt;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
