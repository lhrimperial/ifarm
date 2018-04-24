package com.ifarm.console.facade.controller;

import com.ifarm.console.facade.context.ConsoleContext;
import com.ifarm.console.shared.define.ResponseCode;
import com.ifarm.console.shared.exception.BusinessException;
import com.ifarm.console.shared.domain.vo.ResponseVO;

/**
 *
 */
public class AbstractController {

    protected ResponseVO returnSuccess() {
        ResponseVO responseVO = new ResponseVO(true, ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
        responseVO.setToken(ConsoleContext.getTokenParam());
        return  responseVO;
    }

    protected ResponseVO returnSuccess(String message) {
        ResponseVO responseVO =  new ResponseVO(true, ResponseCode.SUCCESS.getCode(), message);
        responseVO.setToken(ConsoleContext.getTokenParam());
        return  responseVO;
    }

    protected ResponseVO returnError(BusinessException e) {
        ResponseVO responseVO =  new ResponseVO(false, e.getErrorCode(), e.getMessage());
        responseVO.setToken(ConsoleContext.getTokenParam());
        return  responseVO;
    }

    protected ResponseVO returnError(String message) {
        ResponseVO responseVO =  new ResponseVO(false, ResponseCode.FAILURE.getCode(), message);
        responseVO.setToken(ConsoleContext.getTokenParam());
        return  responseVO;
    }

    protected ResponseVO returnError() {
        ResponseVO responseVO =  new ResponseVO(false, ResponseCode.FAILURE.getCode(), ResponseCode.FAILURE.getMessage());
        responseVO.setToken(ConsoleContext.getTokenParam());
        return  responseVO;
    }
}
