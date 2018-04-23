package com.ifarm.console.facade.controller;

import com.github.framework.server.exception.BusinessException;
import com.github.framework.server.shared.domain.vo.ResponseVO;
import com.github.framework.server.shared.entity.ErrorCode;
import com.ifarm.console.facade.context.ConsoleContext;

/**
 *
 */
public class AbstractController {

    protected ResponseVO returnSuccess() {
        ResponseVO responseVO = new ResponseVO(true, ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getName());
        responseVO.setToken(ConsoleContext.getTokenParam());
        return  responseVO;
    }

    protected ResponseVO returnSuccess(String message) {
        ResponseVO responseVO =  new ResponseVO(true, ErrorCode.SUCCESS.getCode(), message);
        responseVO.setToken(ConsoleContext.getTokenParam());
        return  responseVO;
    }

    protected ResponseVO returnError(BusinessException e) {
        ResponseVO responseVO =  new ResponseVO(false, e.getErrorCode(), e.getMessage());
        responseVO.setToken(ConsoleContext.getTokenParam());
        return  responseVO;
    }

    protected ResponseVO returnError(String message) {
        ResponseVO responseVO =  new ResponseVO(false, ErrorCode.FAILURE.getCode(), message);
        responseVO.setToken(ConsoleContext.getTokenParam());
        return  responseVO;
    }

    protected ResponseVO returnError() {
        ResponseVO responseVO =  new ResponseVO(false, ErrorCode.FAILURE.getCode(), ErrorCode.FAILURE.getName());
        responseVO.setToken(ConsoleContext.getTokenParam());
        return  responseVO;
    }
}
