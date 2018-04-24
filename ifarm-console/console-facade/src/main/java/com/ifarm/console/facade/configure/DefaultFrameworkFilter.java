package com.ifarm.console.facade.configure;

import com.github.framework.util.string.StringUtils;
import com.ifarm.console.facade.context.ConsoleContext;
import com.ifarm.console.facade.context.Token;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 */
public class DefaultFrameworkFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        //设置登录用户
        String paramToken = WebUtils.toHttp(request).getHeader(Token.JSESSIONID_TOKEN);
        if (StringUtils.isNotBlank(paramToken) && !"undefined".equals(paramToken) && !"null".equals(paramToken)) {
            ConsoleContext.tokenToSession(paramToken);
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
