package com.ifarm.console.facade.context;

import com.github.framework.util.string.StringUtils;
import com.ifarm.console.shared.domain.dto.UserInfoDTO;
import com.ifarm.console.shared.exception.UserNotLoginException;

/**
 *
 **/
public class ConsoleContext {

    private ConsoleContext(){}

    static final ThreadLocal<UserInfoDTO> userInfoStore = new ThreadLocal<>();

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
                UserInfoDTO userInfoDTO = new UserInfoDTO(token.getUserId(), token.getEmpCode(), token.getCurrentDeptCode());
                setCurrentUser(userInfoDTO);
            } else {
                throw new UserNotLoginException();// 用户未登录
            }
        }
    }

    /**
     * 获取Token字符串
     */
    public static String getTokenParam() {
        UserInfoDTO userInfoPO = userInfoStore.get();
        if (userInfoPO == null) {
            throw new UserNotLoginException();
        }
        String userName = userInfoPO.getUserName();
        String empCode = userInfoPO.getEmpCode();
        String currentDeptCode = userInfoPO.getDeptCode();
        Token token = new Token(userName,
                empCode, currentDeptCode, Token.DEFAULT_EXPIRE);
        return TokenMarshal.marshal(token);
    }

    /**
     * 设置当前登录用户信息
     * @param userInfoDTO
     */
    public static void setCurrentUser(UserInfoDTO userInfoDTO) {
        userInfoStore.set(userInfoDTO);
    }

    /**
     * 获取当前登录用户信息
     * @return
     */
    public static UserInfoDTO getCurrentUser() {
        return userInfoStore.get();
    }


    /**
     * 获取当前会话的用户
     *
     * @return UserEntity 当前用户
     */
    public static String getCurrentUserName() {
        UserInfoDTO user = userInfoStore.get();
        if (user == null) {
            throw new UserNotLoginException();
        }
        return user.getUserName();
    }
}
