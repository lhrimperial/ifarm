package com.ifarm.console.facade.context;

import com.github.framework.server.cache.exception.security.UserNotLoginException;
import com.github.framework.server.context.SessionContext;
import com.github.framework.server.shared.define.Definitions;

/**
 *
 **/
public class ConsoleContext {

    private ConsoleContext(){}

    static final ThreadLocal<String> userStore = new ThreadLocal<>();

    public static void setCurrentUserName(String userName) {
        SessionContext.setCurrentUser(userName);
    }

    /**
     * 获取当前会话的用户
     *
     * @return UserEntity 当前用户
     */
    public static String getCurrentUserName() {
        String userName = (String) SessionContext.getSession().getObject(Definitions.KEY_USER);
        if (userName == null) {
            throw new UserNotLoginException();
        }
        return userName;
    }
}
