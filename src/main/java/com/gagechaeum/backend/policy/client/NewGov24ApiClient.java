package com.gagechaeum.backend.policy.client;

import com.gagechaeum.backend.policy.dto.NewPolicyApiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class NewGov24ApiClient {

    private final RestTemplate restTemplate;

    // 구비서류 API
    @Value("${external.gov24.api.detailUrl}")
    private String detailApiUrl;

    @Value("${external.gov24.api.serviceKey}")
    private String serviceKey;

    public NewPolicyApiResponseDto fetchServiceDetail(String serviceId) {
        URI uri = UriComponentsBuilder.fromHttpUrl(detailApiUrl)
                .queryParam("page", 1)
                .queryParam("perPage", 10)
                .queryParam("serviceKey", serviceKey)
                .queryParam("serviceId", serviceId)
                .build()
                .encode()
                .toUri();

        return restTemplate.getForObject(uri, NewPolicyApiResponseDto.class);
    }
}
