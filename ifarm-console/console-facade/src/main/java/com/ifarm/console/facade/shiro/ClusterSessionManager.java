package com.ifarm.console.facade.shiro;

import com.github.framework.util.string.StringUtils;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * 集群实现Session共享
 */
public class ClusterSessionManager extends DefaultWebSessionManager {
    private Logger logger = LoggerFactory.getLogger(ClusterSessionManager.class);
    private static final String AUTHORIZATION = "Authorization";

    private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";

    public ClusterSessionManager() {
        super();
    }

    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String url = req.getRequestURL().toString();
        logger.info("request url:" + url);
        String id = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
        logger.info("Authorization : {}", id);
        //如果请求头中有 Authorization 则其值为sessionId
        if (!StringUtils.isEmpty(id)) {
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, REFERENCED_SESSION_ID_SOURCE);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return id;
        } else {
            //否则按默认规则从cookie取sessionId
            return super.getSessionId(request, response);
        }
    }
}