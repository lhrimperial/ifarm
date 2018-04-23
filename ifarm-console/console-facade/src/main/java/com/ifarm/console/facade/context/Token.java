package com.ifarm.console.facade.context;

import org.apache.commons.codec.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;

/**
 * 登录令牌,使用一次即销毁
 */
public class Token {

    private Logger logger = LoggerFactory.getLogger(Token.class);
    public static final String JSESSIONID_TOKEN = "JSESSIONID";
    public static final int DEFAULT_EXPIRE = 1800;// 30分钟

    /**
     * 登录用户CODE
     */
    private String userId;

    /**
     * 工号
     */
    private String empCode;

    /**
     * 当前部门编码
     */
    private String currentDeptCode;

    /**
     * 当前部门名称
     */
    private String currentDeptName;

    /**
     * 会话ID
     */
    private String sessionId;
    /**
     * 系统ID
     */
    private String applicationId;

    /**
     * 标识token的唯一ID
     */
    private String uuid;

    /**
     * 有效时间，单位毫秒，默认为当前系统毫秒数
     */
    private Long expireTime = System.currentTimeMillis();

    public Token(String userId, String empCode, String currentDeptCode, int expireSecond) {
        this.setUserId(userId);
        this.empCode = empCode;
        this.currentDeptCode = currentDeptCode;
        //生成时间戳
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        int millisecond = expireSecond * 1000;
        c.add(Calendar.MILLISECOND, millisecond);
        this.expireTime = c.getTimeInMillis();
    }

    /**
     * 根据sessionId,userId,empCode,currentDeptCode,second秒来创建token
     *
     * @param sessionId 会话ID
     * @param userId	用户ID
     * @param empCode	工号
     * @param currentDeptCode	当前部门编号
     * @param currentDeptName	当前部门名称
     * @param expireSecond	有效时间 单位秒
     */
    public Token(String sessionId, String userId, String empCode, String currentDeptCode, String currentDeptName, int expireSecond) {
        this.setUserId(userId);
        this.setSessionId(sessionId);
        this.empCode = empCode;
        this.currentDeptCode = currentDeptCode;
        this.currentDeptName = currentDeptName;
        //生成时间戳
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        int millisecond = expireSecond * 1000;
        c.add(Calendar.MILLISECOND, millisecond);
        this.expireTime = c.getTimeInMillis();
    }

    /**
     * byte[]数组的内容复制到Token中
     *
     * @param tokenBytes
     */
    public Token(byte[] tokenBytes) {
        try {
            String token = new String(tokenBytes, CharEncoding.UTF_8);
            String[] keys = token.split(",");
            this.setUserId(keys[0]);
            this.empCode = keys[1];
            this.currentDeptCode = keys[2];
            this.expireTime = Long.parseLong(keys[3]);
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage(),e);
        }
    }

    /**
     * 返回该对象的字符串表示
     *
     * @return
     */
    @Override
    public String toString() {
        super.toString();
        StringBuffer sb = new StringBuffer();
        sb.append(getUserId()).append(",");
        sb.append(getEmpCode()).append(",");
        sb.append(getCurrentDeptCode()).append(",");
        sb.append(getExpireTime());
        return sb.toString();
    }

    /**
     * 返回该对象的byte[]数组表示
     *
     * @return
     * @see
     */
    public byte[] toBytes() {
        try {
            return this.toString().getBytes(CharEncoding.UTF_8);
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage(),e);
        }
        return null;
    }

    /**
     * token是否过期
     * 		1.expireTime >= currentTime 未过期返回false
     * 		2.expireTime < currentTime 已过期返回true
     *
     * @return 1.expireTime >= currentTime 未过期返回false 2.expireTime < currentTime 已过期返回true
     */
    public boolean expired() {
        long millisecond = this.getExpireTime();
        long currentMs = System.currentTimeMillis();
        return millisecond >= currentMs ? false : true;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getCurrentDeptCode() {
        return currentDeptCode;
    }

    public void setCurrentDeptCode(String currentDeptCode) {
        this.currentDeptCode = currentDeptCode;
    }

    public String getCurrentDeptName() {
        return currentDeptName;
    }

    public void setCurrentDeptName(String currentDeptName) {
        this.currentDeptName = currentDeptName;
    }
}
