package com.gagechaeum.backend.policy.service;

import com.gagechaeum.backend.policy.mapper.PolicyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PolicyUpdateService {

    private final PolicyMapper policyMapper;

    @Transactional
    public void saveTempDetail(String policyId, String rawText) {
        if (rawText == null || rawText.isBlank()) {
            log.warn("[정책ID: {}] 구비서류 원본 텍스트가 비어있어 임시 테이블에 저장하지 않습니다.", policyId);
            return;
        }
        log.info("[SAVE_TO_TEMP] Policy ID: {} 에 대한 raw_text를 임시 저장합니다.", policyId);
        policyMapper.saveOrUpdateTempPolicyDetail(policyId, rawText);
    }
}
