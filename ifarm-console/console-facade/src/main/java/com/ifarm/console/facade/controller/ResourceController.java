package com.ifarm.console.facade.controller;

import com.ifarm.console.facade.service.IResourceService;
import com.ifarm.console.shared.domain.dto.ResourceDTO;
import com.ifarm.console.shared.domain.vo.ResourceVO;
import com.ifarm.console.shared.domain.vo.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 **/
@RestController
@RequestMapping("/resource")
public class ResourceController extends AbstractController {
    private Logger logger = LoggerFactory.getLogger(ResourceController.class);

    @Autowired
    private IResourceService resourceService;

    @RequestMapping("/findByParentCode")
    public ResponseVO<List<ResourceDTO>> findByParentCode(String parentCode) {
        ResponseVO responseVO = returnSuccess();
        try {
            responseVO.setResult(resourceService.findByParentCode(parentCode));
        } catch (Exception e) {
            logger.error("", e);
            return returnError(e.getMessage());
        }
        return responseVO;
    }

    @RequestMapping("/find")
    public ResponseVO findById(Integer tid) {
        ResponseVO responseVO = returnSuccess();
        try {
            responseVO.setResult(resourceService.findById(tid));
        } catch (Exception e) {
            logger.error("", e);
            return returnError(e.getMessage());
        }
        return responseVO;
    }

    @RequestMapping("/list")
    public ResponseVO list(@RequestBody ResourceVO resourceVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            responseVO.setResult(resourceService.findByParam(resourceVO));
        } catch (Exception e) {
            logger.error("", e);
            return returnError(e.getMessage());
        }
        return responseVO;
    }

    @RequestMapping("/save")
    public ResponseVO save(@RequestBody ResourceVO resourceVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            responseVO.setResult(resourceService.insert(resourceVO));
        } catch (Exception e) {
            logger.error("", e);
            return returnError(e.getMessage());
        }
        return responseVO;
    }

    @RequestMapping("/update")
    public ResponseVO update(@RequestBody ResourceVO resourceVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            responseVO.setResult(resourceService.update(resourceVO));
        } catch (Exception e) {
            logger.error("", e);
            return returnError(e.getMessage());
        }
        return responseVO;
    }

    @RequestMapping("/delete")
    public ResponseVO delete(@RequestBody ResourceVO resourceVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            responseVO.setResult(resourceService.delete(resourceVO));
        } catch (Exception e) {
            logger.error("", e);
            return returnError(e.getMessage());
        }
        return responseVO;
    }
}
