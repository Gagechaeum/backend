package com.gagechaeum.backend.policy.client;

import com.gagechaeum.backend.global.exception.ExternalApiException;
import com.gagechaeum.backend.policy.dto.external.Gov24ApiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class Gov24ApiClient {

    private final RestTemplate restTemplate;

    @Value("${external.gov24.api.url}")
    private String apiUrl;

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
}
