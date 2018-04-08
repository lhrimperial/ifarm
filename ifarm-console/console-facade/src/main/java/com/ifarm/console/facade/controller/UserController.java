package com.ifarm.console.facade.controller;

import com.github.framework.server.shared.domain.vo.ResponseVO;
import com.github.framework.server.web.AbstractController;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 **/
@RestController
public class UserController extends AbstractController{

    public ResponseVO index() {
        return returnSuccess();
    }
}
