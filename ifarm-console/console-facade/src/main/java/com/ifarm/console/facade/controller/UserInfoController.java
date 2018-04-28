package com.ifarm.console.facade.controller;

import com.ifarm.console.facade.service.IUserInfoService;
import com.ifarm.console.shared.domain.vo.ResponseVO;
import com.ifarm.console.shared.domain.vo.UserInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("/user")
public class UserInfoController extends AbstractController{
    private Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private IUserInfoService userInfoService;

    @RequestMapping("/list")
    public ResponseVO list(UserInfoVO userInfoVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            userInfoService.findByParam(userInfoVO);
            responseVO.setResult(userInfoVO);
        } catch (Exception e) {
            logger.error("", e);
            return returnError();
        }
        return responseVO;
    }
}
