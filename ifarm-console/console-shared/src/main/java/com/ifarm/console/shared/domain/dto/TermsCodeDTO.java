package com.ifarm.console.shared.domain.dto;

import com.github.framework.util.serializer.BeanCopyUtils;
import com.ifarm.console.shared.domain.po.TermsCodePO;

import java.util.List;

/**
 *
 **/
public class TermsCodeDTO extends BaseDTO {
    private static final long serialVersionUID = -3422083228098690401L;

    /**
     * 条款编码
     */
    private String termsCode;

    /**
     * 条款名称
     */
    private String termsName;

    /**
     *
     */
    private String notes;

    private List<TermsValueDTO> termsValues;

    public TermsCodePO convertPO() {
        TermsCodePO termsCodePO = new TermsCodePO();
        BeanCopyUtils.copyBean(this, termsCodePO);
        return termsCodePO;
    }

    public List<TermsValueDTO> getTermsValues() {
        return termsValues;
    }

    public void setTermsValues(List<TermsValueDTO> termsValues) {
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
