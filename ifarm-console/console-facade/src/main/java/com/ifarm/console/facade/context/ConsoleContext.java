package com.ifarm.console.facade.context;

import com.github.framework.server.cache.exception.security.UserNotLoginException;
import com.github.framework.server.context.UserContext;
import com.ifarm.console.shared.domain.dto.UserInfoVO;

/**
 *
 **/
public class ConsoleContext {

    private ConsoleContext(){}

    static final ThreadLocal<UserInfoVO> userStore = new ThreadLocal<>();

    public static void setCurrentUser(UserInfoVO user) {
        userStore.set(user);
    }

    /**
     * 获取当前会话的用户
     *
     * @return UserEntity 当前用户
     */
    public static UserInfoVO getCurrentUser() {
        UserInfoVO user = (UserInfoVO) (UserContext.getCurrentUser());
        if (user == null) {
            throw new UserNotLoginException();
        }
        return user;
    }
}
