package com.ifarm.console.facade.controller;

import com.github.framework.server.shared.domain.vo.ResponseVO;
import com.github.framework.server.web.AbstractController;
import com.ifarm.console.shared.domain.dto.UserInfoVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static com.ifarm.console.shared.domain.define.ResponseCode.*;

/**
 *
 **/
@RestController
public class LoginController extends AbstractController{
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);
    /**
     * 登录
     * @param userInfoVO
     * @return
     */
    @RequestMapping("/login")
    public ResponseVO login(UserInfoVO userInfoVO) {
        ResponseVO responseVO = null;
        UsernamePasswordToken token = new UsernamePasswordToken(userInfoVO.getUserName(), userInfoVO.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return returnSuccess();
        } catch (IncorrectCredentialsException e) {
            //密码错误
            logger.error("密码错误", e);
            responseVO = returnError("密码错误");
        } catch (LockedAccountException e) {
            //该用户已被冻结
            logger.error("该用户已被冻结", e);
            responseVO = returnError("密码错误");
        } catch (ExcessiveAttemptsException e){
            //尝试次数过多
            logger.error("尝试次数过多", e);
            responseVO = returnError("密码错误");
        } catch (AuthenticationException e) {
            //该用户不存在
            logger.error("该用户不存在", e);
            responseVO = returnError("密码错误");
        } catch (Exception e) {
            logger.error("", e);
            responseVO = new ResponseVO(false, LOGIN_FAIL.getCode(), LOGIN_FAIL.getMessage());
        }
        return responseVO;
    }

    /**
     * 登录成功
     * @return
     */
    @RequestMapping("/index")
    public ResponseVO index() {
        ResponseVO responseVO = new ResponseVO(true, LOGIN_SUCCESS.getCode(),LOGIN_SUCCESS.getMessage());
        return responseVO;
    }

    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     * @return
     */
    @RequestMapping(value = "/unauth")
    public ResponseVO unauth() {
        ResponseVO responseVO = new ResponseVO(true, UN_LOGIN.getCode(),UN_LOGIN.getMessage());
        return responseVO;
    }

    /**
     * 未授权
     * @return
     */
    @RequestMapping("/unauthorized")
    public ResponseVO unauthorized() {
        ResponseVO responseVO = new ResponseVO(true, UNAUTHORIZED.getCode(),UNAUTHORIZED.getMessage());
        return responseVO;
    }

    @RequestMapping("/logout")
    public ResponseVO logout() {
        return returnSuccess();
    }
}
