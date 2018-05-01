package com.ifarm.console.mapper;

import com.ifarm.console.shared.domain.po.TermsCodePO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TermsCodeMapper {

    TermsCodePO findByTermsCode(String termsCode);

    List<TermsCodePO> findAllCode();

    TermsCodePO findTermsCodeByID(Integer tid);

    List<TermsCodePO> findTermsCodeByParam(TermsCodePO termsCodePO);

    long termsCodeTotalCount(TermsCodePO termsCodePO);

    int termsCodeDelete(@Param("ids")List<Integer> ids, @Param("active") String active);

    int batchUpdateTermsCodeStatus(@Param("termsCodes") List<String> termsCodes, @Param("status") String active);

    int insert(TermsCodePO record);

    int update(TermsCodePO record);
}