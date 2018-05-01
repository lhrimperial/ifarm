package com.ifarm.console.facade.controller;

import com.ifarm.console.facade.service.ITermsValueService;
import com.ifarm.console.shared.domain.vo.DictionaryVO;
import com.ifarm.console.shared.domain.vo.ResponseVO;
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
@RequestMapping("/terms")
public class TermsController extends AbstractController {
    private Logger logger = LoggerFactory.getLogger(TermsController.class);

    @Autowired
    private ITermsValueService termsValueService;

    @RequestMapping("/dictionary")
    public ResponseVO dictionary() {
        ResponseVO responseVO = returnSuccess();
        try {
            responseVO.setResult(termsValueService.findAllTermsCode());
        } catch (Exception e) {
            logger.error("", e);
            return returnError(e.getMessage());
        }
        return responseVO;
    }


    @RequestMapping("/code/list")
    public ResponseVO termsCodeList(@RequestBody DictionaryVO dictionaryVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            responseVO.setResult(termsValueService.termsCodeList(dictionaryVO));
        } catch (Exception e) {
            logger.error("", e);
            return returnError(e.getMessage());
        }
        return responseVO;
    }

    @RequestMapping("/code/find")
    public ResponseVO findCodeById(Integer tid) {
        ResponseVO responseVO = returnSuccess();
        try {
            responseVO.setResult(termsValueService.findCodeById(tid));
        } catch (Exception e) {
            logger.error("", e);
            return returnError(e.getMessage());
        }
        return responseVO;
    }

    @RequestMapping("/code/save")
    public ResponseVO termsCodeSave(@RequestBody DictionaryVO dictionaryVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            responseVO.setResult(termsValueService.termsCodeSave(dictionaryVO));
        } catch (Exception e) {
            logger.error("", e);
            return returnError(e.getMessage());
        }
        return responseVO;
    }

    @RequestMapping("/code/update")
    public ResponseVO termsCodeUpdate(@RequestBody DictionaryVO dictionaryVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            responseVO.setResult(termsValueService.termsCodeUpdate(dictionaryVO));
        } catch (Exception e) {
            logger.error("", e);
            return returnError(e.getMessage());
        }
        return responseVO;
    }

    @RequestMapping("/code/delete")
    public ResponseVO termsCodeDelete(@RequestBody DictionaryVO dictionaryVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            responseVO.setResult(termsValueService.termsCodeDelete(dictionaryVO));
        } catch (Exception e) {
            logger.error("", e);
            return returnError(e.getMessage());
        }
        return responseVO;
    }


    @RequestMapping("/value/list")
    public ResponseVO termsValueList(@RequestBody DictionaryVO dictionaryVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            responseVO.setResult(termsValueService.termsValueList(dictionaryVO));
        } catch (Exception e) {
            logger.error("", e);
            return returnError(e.getMessage());
        }
        return responseVO;
    }

    @RequestMapping("/value/find")
    public ResponseVO findValueById(Integer tid) {
        ResponseVO responseVO = returnSuccess();
        try {
            responseVO.setResult(termsValueService.findValueById(tid));
        } catch (Exception e) {
            logger.error("", e);
            return returnError(e.getMessage());
        }
        return responseVO;
    }

    @RequestMapping("/value/save")
    public ResponseVO termsValueSave(@RequestBody DictionaryVO dictionaryVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            responseVO.setResult(termsValueService.termsValueSave(dictionaryVO));
        } catch (Exception e) {
            logger.error("", e);
            return returnError(e.getMessage());
        }
        return responseVO;
    }

    @RequestMapping("/value/update")
    public ResponseVO termsValueUpdate(@RequestBody DictionaryVO dictionaryVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            responseVO.setResult(termsValueService.termsValueUpdate(dictionaryVO));
        } catch (Exception e) {
            logger.error("", e);
            return returnError(e.getMessage());
        }
        return responseVO;
    }

    @RequestMapping("/value/delete")
    public ResponseVO termsValueDelete(@RequestBody DictionaryVO dictionaryVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            responseVO.setResult(termsValueService.termsValueDelete(dictionaryVO));
        } catch (Exception e) {
            logger.error("", e);
            return returnError(e.getMessage());
        }
        return responseVO;
    }


}
