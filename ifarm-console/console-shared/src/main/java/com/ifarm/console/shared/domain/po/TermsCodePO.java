package com.ifarm.console.shared.domain.po;


import com.github.framework.util.serializer.BeanCopyUtils;
import com.ifarm.console.shared.domain.dto.TermsCodeDTO;
import com.ifarm.console.shared.domain.dto.TermsValueDTO;

import java.util.ArrayList;
import java.util.List;

public class TermsCodePO extends BasePO {

    private static final long serialVersionUID = -1046503061844307480L;
    /**
     * 条款编码
     */
    private String termsCode;

    /**
     * 条款名称
     */
    private String termsName;

    private String notes;

    private List<TermsValuePO> termsValues;

    public TermsCodeDTO convertDTO() {
        TermsCodeDTO termsCodeDTO = new TermsCodeDTO();
        BeanCopyUtils.copyBean(this, termsCodeDTO);
        if (this.termsValues != null && !this.termsValues.isEmpty()) {
            List<TermsValueDTO> dtos = new ArrayList<>(this.termsValues.size());
            for (TermsValuePO po : this.termsValues) {
                dtos.add(po.convertDTO());
            }
            termsCodeDTO.setTermsValues(dtos);
        }
        return termsCodeDTO;
    }

    public List<TermsValuePO> getTermsValues() {
        return termsValues;
    }

    public void setTermsValues(List<TermsValuePO> termsValues) {
        this.termsValues = termsValues;
    }

    public String getTermsCode() {
        return termsCode;
    }

    public void setTermsCode(String termsCode) {
        this.termsCode = termsCode;
    }

    public String getTermsName() {
        return termsName;
    }

    public void setTermsName(String termsName) {
        this.termsName = termsName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}