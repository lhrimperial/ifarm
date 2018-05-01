package com.ifarm.console.shared.domain.vo;

import com.ifarm.console.shared.domain.dto.TermsCodeDTO;
import com.ifarm.console.shared.domain.dto.TermsValueDTO;

import java.util.List;

/**
 *
 **/
public class DictionaryVO extends BaseVO{

    private List<Integer> ids;
    private TermsCodeDTO termsCodeDTO;
    private List<TermsCodeDTO> termsCodeDTOS;
    private TermsValueDTO termsValueDTO;
    private List<TermsValueDTO> termsValueDTOS;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public TermsCodeDTO getTermsCodeDTO() {
        return termsCodeDTO;
    }

    public void setTermsCodeDTO(TermsCodeDTO termsCodeDTO) {
        this.termsCodeDTO = termsCodeDTO;
    }

    public List<TermsCodeDTO> getTermsCodeDTOS() {
        return termsCodeDTOS;
    }

    public void setTermsCodeDTOS(List<TermsCodeDTO> termsCodeDTOS) {
        this.termsCodeDTOS = termsCodeDTOS;
    }

    public TermsValueDTO getTermsValueDTO() {
        return termsValueDTO;
    }

    public void setTermsValueDTO(TermsValueDTO termsValueDTO) {
        this.termsValueDTO = termsValueDTO;
    }

    public List<TermsValueDTO> getTermsValueDTOS() {
        return termsValueDTOS;
    }

    public void setTermsValueDTOS(List<TermsValueDTO> termsValueDTOS) {
        this.termsValueDTOS = termsValueDTOS;
    }
}
