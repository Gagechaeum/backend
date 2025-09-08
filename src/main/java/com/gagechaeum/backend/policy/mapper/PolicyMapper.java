package com.gagechaeum.backend.policy.mapper;

import com.gagechaeum.backend.policy.domain.Policy;
import com.gagechaeum.backend.policy.dto.DocumentKeywordDTO;
import com.gagechaeum.backend.policy.dto.response.PolicyDocumentsResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface PolicyMapper {
    List<Policy> findRecommendedPoliciesByUserId(@Param("userId") Long userId);

    void saveOrUpdatePolicy(Policy policy);

    Policy getPolicyById(@Param("policyId") String policyId);

    List<DocumentKeywordDTO> findAllDocumentsWithKeywords();

    void deleteRequiredDocumentsByPolicyId(String policyId);

    void insertRequiredDocument(@Param("policyId") String policyId, @Param("documentId") Long documentId);

    List<PolicyDocumentsResponseDTO.StructuredDocumentDTO> findStructuredDocumentsByPolicyId(@Param("policyId") String policyId, @Param("userId") Long userId);

    List<Policy> findAllPolicyIdsWithModificationDate();

    List<Policy> findAllPolicies();

    int updatePoliciesFromTempTable();

    void saveOrUpdateTempPolicyDetail(@Param("policyId") String policyId, @Param("rawText") String rawText);
}
