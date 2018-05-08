package com.ifarm.console.facade.controller;

import com.ifarm.console.facade.service.IUserInfoService;
import com.ifarm.console.shared.domain.vo.ResponseVO;
import com.ifarm.console.shared.domain.vo.UserInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseVO list(@RequestBody UserInfoVO userInfoVO) {
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

    @RequestMapping("/find")
    public ResponseVO findById(Integer tid) {
        ResponseVO responseVO = returnSuccess();
        try {
            responseVO.setResult(userInfoService.findById(tid));
        } catch (Exception e) {
            logger.error("", e);
            return returnError();
        }
        return responseVO;
    }

    @RequestMapping("/save")
    public ResponseVO save(@RequestBody UserInfoVO userInfoVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            userInfoService.insert(userInfoVO);
        } catch (Exception e) {
            logger.error("", e);
            return returnError(e.getMessage());
        }
        return responseVO;
    }

    @RequestMapping("/update")
    public ResponseVO update(@RequestBody UserInfoVO userInfoVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            userInfoService.update(userInfoVO);
        } catch (Exception e) {
            logger.error("", e);
            return returnError(e.getMessage());
        }
        return responseVO;
    }

    @RequestMapping("/delete")
    public ResponseVO delete(@RequestBody UserInfoVO userInfoVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            userInfoService.delete(userInfoVO);
        } catch (Exception e) {
            logger.error("", e);
            return returnError(e.getMessage());
        }
        return responseVO;
    }

    @RequestMapping("/distributeRole")
    public ResponseVO distributeRole(@RequestBody UserInfoVO userInfoVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            userInfoService.distributeRole(userInfoVO);
        } catch (Exception e) {
            logger.error("", e);
            return returnError(e.getMessage());
        }
        return responseVO;
    }
}
