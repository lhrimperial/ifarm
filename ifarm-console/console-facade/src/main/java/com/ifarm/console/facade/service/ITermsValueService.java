package com.ifarm.console.facade.service;


import com.ifarm.console.shared.domain.dto.TermsCodeDTO;
import com.ifarm.console.shared.domain.dto.TermsValueDTO;
import com.ifarm.console.shared.domain.vo.DictionaryVO;

/**
 * @author longhr
 * @version 2017/11/6 0006
 */
public interface ITermsValueService {

    DictionaryVO findAllTermsCode();

    DictionaryVO termsCodeList(DictionaryVO dictionaryVO);

    TermsCodeDTO findCodeById(Integer tid);

    int termsCodeSave(DictionaryVO dictionaryVO);

    int termsCodeUpdate(DictionaryVO dictionaryVO);

    int termsCodeDelete(DictionaryVO dictionaryVO);


    DictionaryVO termsValueList(DictionaryVO dictionaryVO);

    TermsValueDTO findValueById(Integer tid);

    int termsValueSave(DictionaryVO dictionaryVO);

    int termsValueUpdate(DictionaryVO dictionaryVO);

    int termsValueDelete(DictionaryVO dictionaryVO);
}
