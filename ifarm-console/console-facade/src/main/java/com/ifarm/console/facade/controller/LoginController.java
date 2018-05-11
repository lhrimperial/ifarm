package com.ifarm.console.facade.controller;

import com.ifarm.console.facade.context.ConsoleContext;
import com.ifarm.console.facade.service.IResourceService;
import com.ifarm.console.facade.service.IUserInfoService;
import com.ifarm.console.shared.define.IFarmConstants;
import com.ifarm.console.shared.domain.dto.ResourceDTO;
import com.ifarm.console.shared.domain.dto.UserInfoDTO;
import com.ifarm.console.shared.domain.po.UserInfoPO;
import com.ifarm.console.shared.domain.vo.ResponseVO;
import com.ifarm.console.shared.domain.vo.UserInfoVO;
import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

import static com.ifarm.console.shared.define.ResponseCode.*;

/**
 *
 **/
@RestController
public class LoginController extends AbstractController{
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private IUserInfoService userInfoService;

    @Autowired
    private IResourceService resourceService;
    /**
     * 登录
     * @param userInfoVO
     * @return
     */
    @RequestMapping("/login")
    public ResponseVO<Map<String,Object>> login(@RequestBody UserInfoPO userInfoVO, HttpSession session) {
        ResponseVO responseVO = null;
        UsernamePasswordToken token = new UsernamePasswordToken(userInfoVO.getUserName(), userInfoVO.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            //User
            UserInfoDTO userDetail = userInfoService.findByUserName(userInfoVO.getUserName());
            ConsoleContext.setCurrentUser(userDetail);

            Map<String, Object> resultMap = new HashedMap();
            resultMap.put("Authorization", session.getId());
            responseVO = returnSuccess();
            responseVO.setResult(resultMap);
            return responseVO;
        } catch (IncorrectCredentialsException e) {
            //密码错误
            logger.error("用户名/密码错误", e);
            responseVO = returnError("用户名/密码错误");
        } catch (LockedAccountException e) {
            //该用户已被冻结
            logger.error("该用户已被冻结", e);
            responseVO = returnError("该用户已被冻结");
        } catch (ExcessiveAttemptsException e){
            //尝试次数过多
            logger.error("尝试次数过多", e);
            responseVO = returnError("尝试次数过多");
        } catch (AuthenticationException e) {
            //该用户不存在
            logger.error("该用户不存在", e);
            responseVO = returnError("该用户不存在");
        } catch (Exception e) {
            logger.error("", e);
            responseVO = new ResponseVO(false, LOGIN_FAIL.getCode(), LOGIN_FAIL.getMessage());
        }
        return responseVO;
    }

    @RequestMapping("/userInfo")
    public ResponseVO userInfo() {
        ResponseVO<UserInfoVO> responseVO = returnSuccess();
        try {
            UserInfoVO userInfoVO = new UserInfoVO();
            String userName = ConsoleContext.getCurrentUserName();
            UserInfoDTO userInfoDTO = userInfoService.findByUserName(userName);
            userInfoDTO.clearCredentialsSalt();
            List<ResourceDTO> userMenus = resourceService.findMenuByUserAndParent(IFarmConstants.MENU_ROOT);
            userInfoVO.setUserInfoDTO(userInfoDTO);
            userInfoVO.setUserMenus(userMenus);
            responseVO.setResult(userInfoVO);
        } catch (Exception e) {
            logger.error("", e);
            return returnError(e.getMessage());
        }
        return responseVO;
    }

    @RequestMapping("/userMenu")
    public ResponseVO userMenu(String parentCode) {
        ResponseVO<List<ResourceDTO>> responseVO = returnSuccess();
        try {
            List<ResourceDTO> userMenus = resourceService.findMenuByUserAndParent(parentCode);
            responseVO.setResult(userMenus);
        } catch (Exception e) {
            logger.error("", e);
            return returnError(e.getMessage());
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
        ResponseVO responseVO = new ResponseVO(false, UN_LOGIN.getCode(),UN_LOGIN.getMessage());
        return responseVO;
    }

    /**
     * 未授权
     * @return
     */
    @RequestMapping("/unauthorized")
    public ResponseVO unauthorized() {
        ResponseVO responseVO = new ResponseVO(false, UNAUTHORIZED.getCode(),UNAUTHORIZED.getMessage());
        return responseVO;
    }

    @RequestMapping("/logout")
    public ResponseVO logout() {
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
        } catch (Exception e) {
            logger.error("", e);
            return returnError();
        }
        return returnSuccess();
    }

}
