package com.ifarm.console.facade.shiro;

import com.alibaba.fastjson.JSONObject;
import com.github.framework.server.shared.domain.vo.ResponseVO;
import com.ifarm.console.shared.domain.define.ResponseCode;
import com.ifarm.console.shared.domain.dto.UserInfoVO;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.servlet.AdviceFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 在访问controller前判断是否登录，返回json，不进行重定向。
 **/
public class ShiroLoginFilter extends AdviceFilter {

    /**
     * true-继续往下执行，false-该filter过滤器已经处理，不继续执行其他过滤器
     * @param request
     * @param response
     * @return
     * @throws Exception
     */

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        UserInfoVO sysUser = (UserInfoVO) httpServletRequest.getSession().getAttribute("user");
        if (null == sysUser && !StringUtils.contains(httpServletRequest.getRequestURI(), "/login")) {
            String requestedWith = httpServletRequest.getHeader("X-Requested-With");
            if (StringUtils.isNotEmpty(requestedWith) && StringUtils.equals(requestedWith, "XMLHttpRequest")) {//如果是ajax返回指定数据
                ResponseVO responseHeader = new ResponseVO(false, ResponseCode.UN_LOGIN.getCode(), ResponseCode.UN_LOGIN.getMessage());
                httpServletResponse.setCharacterEncoding("UTF-8");
                httpServletResponse.setContentType("application/json");
                httpServletResponse.getWriter().write(JSONObject.toJSONString(responseHeader));
                return false;
            } else {//不是ajax进行重定向处理
                httpServletResponse.sendRedirect("/login");
                return false;
            }
        }
        return true;
    }

}
