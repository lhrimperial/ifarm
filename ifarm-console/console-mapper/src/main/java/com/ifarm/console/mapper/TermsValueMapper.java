package com.ifarm.console.mapper;

import com.ifarm.console.shared.domain.po.TermsCodePO;
import com.ifarm.console.shared.domain.po.TermsValuePO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TermsValueMapper {
    TermsValuePO findByID(Integer tid);

    List<TermsValuePO> findByTermsCode(String termsCode);

    TermsValuePO findByTermsCodeAndValueCode(@Param("termsCode") String termsCode, @Param("valueCode") String valueCode);

    List<TermsValuePO> findTermsValueByParam(TermsValuePO TermsValuePO);

    long totalCount(TermsValuePO termsValuePO);

    int updateTermsValueByTermsCode(TermsCodePO termsCodepO);

    int insert(TermsValuePO record);

    int update(TermsValuePO record);

    int updateBatch(List<TermsValuePO> termsValuePOS);

    int updateActiveByIds(@Param("ids") List<Integer> ids, @Param("active") String active);
}