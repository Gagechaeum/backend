package com.gagechaeum.backend.document.mapper;

import com.gagechaeum.backend.document.domain.Document;
import com.gagechaeum.backend.document.dto.ProductInfo;
import com.gagechaeum.backend.document.dto.response.DocumentChecklistResponseDto;
import com.gagechaeum.backend.document.dto.response.ItemsByDocumentResponseDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DocumentMapper {
    List<Document> findAll();

    ProductInfo findPolicyDetailsById(String policyId);

    ProductInfo findLoanDetailsById(Long loanId);

    List<DocumentChecklistResponseDto.DocumentStatusDto> findRequiredDocumentsWithStatusByPolicyId(@Param("policyId") String policyId, @Param("userId") Long userId);

    List<DocumentChecklistResponseDto.DocumentStatusDto> findRequiredDocumentsWithStatusByLoanId(@Param("loanId") Long loanId, @Param("userId") Long userId);

    List<ItemsByDocumentResponseDto> findPoliciesByDocumentId(@Param("documentId") Long documentId, @Param("userId") Long userId);

    List<ItemsByDocumentResponseDto> findLoansByDocumentId(@Param("documentId") Long documentId, @Param("userId") Long userId);
}
