package com.ifarm.console.facade.controller;

import com.github.framework.server.shared.domain.vo.ResponseVO;
import com.ifarm.console.facade.service.IUserInfoService;
import com.ifarm.console.shared.domain.dto.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class RegisterController extends AbstractController {

    @Autowired
    private IUserInfoService userInfoService;

    @RequestMapping("/register")
    public ResponseVO register(UserInfoVO userInfoVO) {
        ResponseVO responseVO = returnSuccess();
        userInfoService.register(userInfoVO);
        return responseVO;
    }
}
