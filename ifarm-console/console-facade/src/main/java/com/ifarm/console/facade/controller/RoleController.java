package com.ifarm.console.facade.controller;

import com.ifarm.console.facade.service.IRoleInfoService;
import com.ifarm.console.shared.domain.vo.ResponseVO;
import com.ifarm.console.shared.domain.vo.RoleInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 **/
@RestController
@RequestMapping("/role")
public class RoleController extends AbstractController {
    private Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private IRoleInfoService roleInfoService;

    @RequestMapping("/find")
    public ResponseVO findById(Integer tid) {
        ResponseVO responseVO = returnSuccess();
        try {
            responseVO.setResult(roleInfoService.findById(tid));
        } catch (Exception e) {
            logger.error("", e);
            return returnError(e.getMessage());
        }
        return responseVO;
    }

    @RequestMapping("/list")
    public ResponseVO list(@RequestBody RoleInfoVO roleInfoVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            responseVO.setResult(roleInfoService.findByParam(roleInfoVO));
        } catch (Exception e) {
            logger.error("", e);
            return returnError(e.getMessage());
        }
        return responseVO;
    }

    @RequestMapping("/save")
    public ResponseVO save(@RequestBody RoleInfoVO roleInfoVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            responseVO.setResult(roleInfoService.insert(roleInfoVO));
        } catch (Exception e) {
            logger.error("", e);
            return returnError(e.getMessage());
        }
        return responseVO;
    }

    @RequestMapping("/update")
    public ResponseVO update(@RequestBody RoleInfoVO roleInfoVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            responseVO.setResult(roleInfoService.update(roleInfoVO));
        } catch (Exception e) {
            logger.error("", e);
            return returnError(e.getMessage());
        }
        return responseVO;
    }

    @RequestMapping("/delete")
    public ResponseVO delete(@RequestBody RoleInfoVO roleInfoVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            responseVO.setResult(roleInfoService.delete(roleInfoVO));
        } catch (Exception e) {
            logger.error("", e);
            return returnError(e.getMessage());
        }
        return responseVO;
    }
}
