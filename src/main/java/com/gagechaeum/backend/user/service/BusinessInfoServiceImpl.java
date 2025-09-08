package com.gagechaeum.backend.user.service;

import com.gagechaeum.backend.user.domain.BusinessInfoVO;
import com.gagechaeum.backend.user.dto.*;
import com.gagechaeum.backend.user.mapper.BusinessInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BusinessInfoServiceImpl implements BusinessInfoService {
    final private BusinessInfoMapper businessInfoMapper;
    final private RestTemplate restTemplate;

    @Value("${api.odcloud.service-key}")
    private String serviceKey;

    @Override
    public void save(Long userId, BusinessInfoRequestDTO reqDto) {
        BusinessInfoDTO dto = reqDto.toBusinessInfoDTO(userId);
        BusinessInfoVO vo = dto.toVO();
        businessInfoMapper.save(vo);
    }

    @Override
    public void update(BusinessInfoDTO reqDto) {
        BusinessInfoVO vo = reqDto.toVO();
        businessInfoMapper.update(vo);
    }

    @Override
    public void delete(Long businessInfoId) {
        businessInfoMapper.delete(businessInfoId);
    }

    @Override
    public List<BusinessInfoDTO> selectAll(Long userId) {
        List<BusinessInfoVO> bisVOs=businessInfoMapper.selectByUserId(userId);

        return bisVOs.stream()
                .map(BusinessInfoDTO::of)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean verifyBusinessInfo(String name, Long businessNum, LocalDate date) {
        String API_URL = "https://api.odcloud.kr/api/nts-businessman/v1/validate";
        String SUCCESS_CODE = "01";

        // 요청 URL 설정
        String validationUrl = API_URL + "?serviceKey=" + serviceKey;

        // 요청 header 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // 요청 body설정
        String bNoStr = String.valueOf(businessNum);
        String startDateStr = date.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        VerifyBisReqDTO businessInfo = new VerifyBisReqDTO(bNoStr, startDateStr, name);
        VerifyBisArrayReqDTO requestPayload = new VerifyBisArrayReqDTO(
                Collections.singletonList(businessInfo)
        );

        // 요청완성
        HttpEntity<VerifyBisArrayReqDTO> entity = new HttpEntity<>(requestPayload, headers);


        // 진위여부검증 API 호출
        try {
            ResponseEntity<VerifyBisResDTO> response = restTemplate.postForEntity(
                    validationUrl,
                    entity,
                    VerifyBisResDTO.class
            );

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {

                VerifyBisResDTO body = response.getBody();

                if (body.getData() != null && !body.getData().isEmpty()) {
                    String validCode = body.getData().get(0).getValid();
                    return SUCCESS_CODE.equals(validCode);
                }
            }
        } catch (RestClientException e) {
            System.err.println("사업자 정보 검증 API 호출 중 오류 발생: " + e.getMessage());
            return false;
        }

        // 그 외 모든 경우 false
        return false;
    }
}
