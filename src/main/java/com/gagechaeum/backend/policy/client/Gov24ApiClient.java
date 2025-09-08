package com.gagechaeum.backend.policy.client;

import com.gagechaeum.backend.global.exception.ExternalApiException;
import com.gagechaeum.backend.policy.dto.external.Gov24ApiDetailResponseDto;
import com.gagechaeum.backend.policy.dto.external.Gov24ApiResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
@RequiredArgsConstructor
public class Gov24ApiClient {

    private final RestTemplate restTemplate;

    @Value("${external.gov24.api.url}")
    private String apiUrl;

    // 구비서류 API
    @Value("${external.gov24.api.detailUrl}")
    private String detailApiUrl;

    @Value("${external.gov24.api.serviceKey}")
    private String serviceKey;

    public Gov24ApiResponseDto fetchPolicies(int page, int perPage) {
        URI uri = UriComponentsBuilder
                .fromUriString(apiUrl)
                .queryParam("page", page)
                .queryParam("perPage", perPage)
                .queryParam("serviceKey", serviceKey)
                .build(true)
                .toUri();

        try {
            return restTemplate.getForObject(uri, Gov24ApiResponseDto.class);
        } catch (RestClientException e) {
            throw new ExternalApiException("Failed to fetch policies from Gov24 API", e);
        }
    }

    @Async("taskExecutor")
    public CompletableFuture<Gov24ApiDetailResponseDto> fetchPolicyDetails(String policyId) {
        try {
            Thread.sleep(1000);

            RestTemplate localRestTemplate = new RestTemplate();

            URI uri = UriComponentsBuilder
                    .fromUriString(detailApiUrl)
                    .queryParam("serviceKey", serviceKey)
                    .queryParam("serviceId", policyId)
                    .build(true)
                    .toUri();

            // 생성한 localRestTemplate을 사용하여 API를 호출합니다.
            Gov24ApiDetailResponseDto result = localRestTemplate.getForObject(uri, Gov24ApiDetailResponseDto.class);

            return CompletableFuture.completedFuture(result);

        } catch (Exception e) {
            log.error("!!! Gov24 API 호출 또는 처리 중 심각한 오류 발생 (policyId: {}): {}", policyId, e.getMessage(), e);
            return CompletableFuture.failedFuture(e);
        }
    }
}
