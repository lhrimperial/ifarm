package com.ifarm.console.facade.service.impl;

import com.github.framework.util.string.StringUtils;
import com.github.pagehelper.PageHelper;
import com.ifarm.console.facade.service.ITermsValueService;
import com.ifarm.console.mapper.TermsCodeMapper;
import com.ifarm.console.mapper.TermsValueMapper;
import com.ifarm.console.shared.define.IFarmConstants;
import com.ifarm.console.shared.domain.dto.TermsCodeDTO;
import com.ifarm.console.shared.domain.dto.TermsValueDTO;
import com.ifarm.console.shared.domain.po.TermsCodePO;
import com.ifarm.console.shared.domain.po.TermsValuePO;
import com.ifarm.console.shared.domain.vo.DictionaryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 **/
@Service
public class TermsValueServiceImpl implements ITermsValueService {

    @Autowired
    private TermsCodeMapper termsCodeMapper;

    @Autowired
    private TermsValueMapper termsValueMapper;

    @Override
    public DictionaryVO findAllTermsCode() {
        DictionaryVO dictionaryVO = new DictionaryVO();
        List<TermsCodePO> list = termsCodeMapper.findAllCode();
        if (list != null && !list.isEmpty()) {
            List<TermsCodeDTO> result = new ArrayList<>(list.size());
            for (TermsCodePO po : list) {
                result.add(po.convertDTO());
            }
            dictionaryVO.setTermsCodeDTOS(result);
        }
        return dictionaryVO;
    }

    private void codeCheck(DictionaryVO dictionaryVO) {
        if (dictionaryVO == null || dictionaryVO.getTermsCodeDTO() == null) {
            throw new IllegalArgumentException("参数不能为空！");
        }
    }

    @Override
    public DictionaryVO termsCodeList(DictionaryVO dictionaryVO) {
        this.codeCheck(dictionaryVO);
        TermsCodePO termsCodePO = dictionaryVO.getTermsCodeDTO().convertPO();
        PageHelper.startPage(dictionaryVO.getPageNo(), dictionaryVO.getPageSize());
        List<TermsCodePO> list = termsCodeMapper.findTermsCodeByParam(termsCodePO);
        if (list != null && list.size() > 0) {
            List<TermsCodeDTO> result = new ArrayList<>(list.size());
            for (TermsCodePO po : list) {
                result.add(po.convertDTO());
            }
            dictionaryVO.setTermsCodeDTOS(result);
        }
        dictionaryVO.setTotalCount(termsCodeMapper.termsCodeTotalCount(termsCodePO));
        return dictionaryVO;
    }

    @Override
    public TermsCodeDTO findCodeById(Integer tid) {
        TermsCodeDTO termsCodeDTO = null;
        if (tid == null) {
            throw new IllegalArgumentException("参数不能为空！");
        }
        TermsCodePO po = termsCodeMapper.findTermsCodeByID(tid);
        if (po != null) {
            termsCodeDTO = po.convertDTO();
        }
        return termsCodeDTO;
    }

    @Override
    public int termsCodeSave(DictionaryVO dictionaryVO) {
        this.codeCheck(dictionaryVO);
        TermsCodePO po = dictionaryVO.getTermsCodeDTO().convertPO();
        if (StringUtils.isBlank(po.getActive())) {
            po.setActive(IFarmConstants.ACTIVE);
        }
        po.setCreateTime(new Date());
        po.setModifyTime(new Date());
        return termsCodeMapper.insert(po);
    }

    @Override
    public int termsCodeUpdate(DictionaryVO dictionaryVO) {
        this.codeCheck(dictionaryVO);
        TermsCodePO po = dictionaryVO.getTermsCodeDTO().convertPO();
        po.setModifyTime(new Date());
        return termsCodeMapper.update(po);
    }

    @Override
    public int termsCodeDelete(DictionaryVO dictionaryVO) {
        if (dictionaryVO == null) {
            throw new IllegalArgumentException("参数不能为空");
        }
        List<Integer> ids = dictionaryVO.getIds();
        if (ids == null || ids.isEmpty()) {
            return 0;
        }
        return termsCodeMapper.termsCodeDelete(ids, IFarmConstants.INACTIVE);
    }

    private void valueCheck(DictionaryVO dictionaryVO) {
        if (dictionaryVO == null || dictionaryVO.getTermsValueDTO() == null) {
            throw new IllegalArgumentException("参数不能为空！");
        }
    }

    @Override
    public DictionaryVO termsValueList(DictionaryVO dictionaryVO) {
        this.valueCheck(dictionaryVO);
        TermsValuePO termsValuePO = dictionaryVO.getTermsValueDTO().convertPO();
        PageHelper.startPage(dictionaryVO.getPageNo(), dictionaryVO.getPageSize());
        List<TermsValuePO> list = termsValueMapper.findTermsValueByParam(termsValuePO);
        if (list != null && list.size() > 0) {
            List<TermsValueDTO> result = new ArrayList<>(list.size());
            for (TermsValuePO po : list) {
                result.add(po.convertDTO());
            }
            dictionaryVO.setTermsValueDTOS(result);
        }
        dictionaryVO.setTotalCount(termsValueMapper.totalCount(termsValuePO));
        return dictionaryVO;
    }

    @Override
    public TermsValueDTO findValueById(Integer tid) {
        TermsValueDTO termsValueDTO = null;
        if (tid == null) {
            throw new IllegalArgumentException("参数不能为空！");
        }
        TermsValuePO termsValuePO = termsValueMapper.findByID(tid);
        if (termsValuePO != null) {
            termsValueDTO = termsValuePO.convertDTO();
        }
        return termsValueDTO;
    }

    @Override
    public int termsValueSave(DictionaryVO dictionaryVO) {
        this.valueCheck(dictionaryVO);
        TermsValuePO termsValuePO = dictionaryVO.getTermsValueDTO().convertPO();
        if (StringUtils.isBlank(termsValuePO.getActive())) {
            termsValuePO.setActive(IFarmConstants.ACTIVE);
        }
        termsValuePO.setCreateTime(new Date());
        termsValuePO.setModifyTime(new Date());
        return termsValueMapper.insert(termsValuePO);
    }

    @Override
    public int termsValueUpdate(DictionaryVO dictionaryVO) {
        this.valueCheck(dictionaryVO);
        TermsValuePO termsValuePO = dictionaryVO.getTermsValueDTO().convertPO();
        termsValuePO.setModifyTime(new Date());
        return termsValueMapper.insert(termsValuePO);
    }

    @Override
    public int termsValueDelete(DictionaryVO dictionaryVO) {
        if (dictionaryVO == null) {
            throw new IllegalArgumentException("参数不能为空");
        }
        List<Integer> ids = dictionaryVO.getIds();
        if (ids == null || ids.isEmpty()) {
            return 0;
        }
        return termsValueMapper.updateActiveByIds(ids, IFarmConstants.INACTIVE);
    }
}
