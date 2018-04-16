package com.ifarm.console.facade.shiro;

import com.alibaba.fastjson.JSONObject;
import com.github.framework.server.shared.domain.vo.ResponseVO;
import com.ifarm.console.shared.domain.define.ResponseCode;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 扩展RolesAuthorizationFilter，用于ajax访问接口登录但是角色认证不通过的处理
 **/
public class ShiroRolesFilter extends RolesAuthorizationFilter {
    /**
     * true-继续往下执行，false-该filter过滤器已经处理，不继续执行其他过滤器
     * @param servletRequest
     * @param servletResponse
     * @return
     * @throws IOException
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String requestedWith = httpServletRequest.getHeader("X-Requested-With");
        if (StringUtils.isNotEmpty(requestedWith) &&
                StringUtils.equals(requestedWith, "XMLHttpRequest")) {//如果是ajax返回指定格式数据
            ResponseVO responseHeader = new ResponseVO(false, ResponseCode.NO_ROLE.getCode(), ResponseCode.NO_ROLE.getMessage());
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().write(JSONObject.toJSONString(responseHeader));
        } else {//如果是普通请求进行重定向
            httpServletResponse.sendRedirect("");
        }
        return false;
    }
}