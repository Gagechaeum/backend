package com.gagechaeum.backend.policy.mapper;

import com.gagechaeum.backend.policy.domain.Policy;
import com.gagechaeum.backend.policy.dto.DocumentKeywordDTO;
import com.gagechaeum.backend.policy.dto.request.PolicyListRequestDto;
import com.gagechaeum.backend.policy.dto.response.PolicyDocumentsResponseDTO;
import com.gagechaeum.backend.policy.dto.response.PolicySummaryDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface PolicyMapper {
    List<PolicySummaryDto> getPolicyList(@Param("requestDto") PolicyListRequestDto requestDto);

    List<Policy> findRecommendedPoliciesByUserId(@Param("userId") Long userId);

    void saveOrUpdatePolicy(Policy policy);

    Policy getPolicyById(@Param("policyId") String policyId);

    List<Policy> findPoliciesForMatching();

    List<DocumentKeywordDTO> findAllDocumentsWithKeywords();

    void deleteRequiredDocumentsByPolicyId(String policyId);

    void insertRequiredDocument(@Param("policyId") String policyId, @Param("documentId") Long documentId);

    List<PolicyDocumentsResponseDTO.StructuredDocumentDTO> findStructuredDocumentsByPolicyId(@Param("policyId") String policyId, @Param("userId") Long userId);

    List<Policy> findAllPolicyIdsWithModificationDate();

    List<Policy> findAllPolicies();

    int updatePoliciesFromTempTable();

    void saveOrUpdateTempPolicyDetail(@Param("policyId") String policyId, @Param("rawText") String rawText, @Param("updatedAt") LocalDateTime updatedAt);

    void updatePolicyCategories(@Param("policyId") String policyId, @Param("regionId") Long regionId, @Param("industryId") Long industryId);

    List<Policy> findPoliciesMissingDetails(); // [추가]
}
