package com.ifarm.console.facade.context;

import com.github.framework.server.cache.exception.security.UserNotLoginException;
import com.github.framework.server.context.SessionContext;
import com.github.framework.server.shared.define.Definitions;
import com.github.framework.util.string.StringUtils;
import com.ifarm.console.shared.domain.dto.UserInfoVO;

/**
 *
 **/
public class ConsoleContext {

    private ConsoleContext(){}

    static final ThreadLocal<UserInfoVO> userInfoStore = new ThreadLocal<>();

    /**
     * 通过前端设置当前会话的登录用户
     * @param paramToken
     */
    public static void tokenToSession(String paramToken) {
        if (StringUtils.isBlank(paramToken)) {
            throw new UserNotLoginException();// 用户未登录
        } else {
            Token token = TokenMarshal.unMarshal(paramToken);
            if (token != null && !token.expired()) {
                UserInfoVO userInfoVO = new UserInfoVO(token.getUserId(), token.getEmpCode(), token.getCurrentDeptCode());
                setCurrentUser(userInfoVO);
            } else {
                throw new UserNotLoginException();// 用户未登录
            }
        }
    }

    /**
     * 获取Token字符串
     */
    public static String getTokenParam() {
        UserInfoVO userInfoVO = userInfoStore.get();
        if (userInfoVO == null) {
            throw new UserNotLoginException();
        }
        String userName = userInfoVO.getUserName();
        String empCode = userInfoVO.getEmpCode();
        String currentDeptCode = userInfoVO.getDeptCode();
        Token token = new Token(userName,
                empCode, currentDeptCode, Token.DEFAULT_EXPIRE);
        return TokenMarshal.marshal(token);
    }

    /**
     * 设置当前登录用户信息
     * @param userInfoVO
     */
    public static void setCurrentUser(UserInfoVO userInfoVO) {
        userInfoStore.set(userInfoVO);
    }

    /**
     * 获取当前登录用户信息
     * @return
     */
    public static UserInfoVO getCurrentUser() {
        return userInfoStore.get();
    }


    /**
     * 获取当前会话的用户
     *
     * @return UserEntity 当前用户
     */
    public static String getCurrentUserName() {
        UserInfoVO user = userInfoStore.get();
        if (user == null) {
            throw new UserNotLoginException();
        }
        return user.getUserName();
    }
}
