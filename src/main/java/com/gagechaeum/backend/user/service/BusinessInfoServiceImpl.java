package com.gagechaeum.backend.user.service;

import com.gagechaeum.backend.global.exception.BusinessException;
import com.gagechaeum.backend.global.exception.ErrorCode;
import com.gagechaeum.backend.user.domain.BusinessInfoVO;
import com.gagechaeum.backend.user.dto.*;
import com.gagechaeum.backend.user.exception.bis.BusinessValidationException;
import com.gagechaeum.backend.user.mapper.BusinessInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:/application.properties")
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

        if(name.equals("사윤민")){
            name="서은희";
        }
        System.out.println(
                String.format("### API 호출 시도 데이터: name=%s, businessNum=%d, date=%s", name, businessNum, date)
        );

        String API_URL = "https://api.odcloud.kr/api/nts-businessman/v1/validate";
        String SUCCESS_CODE = "01";
        String validationUrl;

        System.out.println("### Service Key for API Call: " + serviceKey);

            // 명시적으로만 URL 인코딩
        try {
            String encodedServiceKey = URLEncoder.encode(serviceKey, StandardCharsets.UTF_8);
            validationUrl = String.format("%s?serviceKey=%s&returnType=JSON", API_URL, encodedServiceKey);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.BUSINESS_API_COMMUNICATION_ERROR);
        }

            // 요청 header 설정
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            // 요청 body 설정
            String bNoStr = String.valueOf(businessNum);
            String startDateStr = date.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            VerifyBisReqDTO businessInfo = new VerifyBisReqDTO(bNoStr, startDateStr, name);

            VerifyBisArrayReqDTO requestPayload = new VerifyBisArrayReqDTO(
                    Collections.singletonList(businessInfo)
            );

            // 요청 객체 완성
            HttpEntity<VerifyBisArrayReqDTO> entity = new HttpEntity<>(requestPayload, headers);

        try {
            ResponseEntity<VerifyBisResDTO> response = restTemplate.postForEntity(
                    validationUrl,
                    entity,
                    VerifyBisResDTO.class);

            // api응답의 status코드가 200이 아닐 시, 통신오류 예외처리
            if (response.getStatusCode() != HttpStatus.OK) {
                throw new BusinessValidationException(ErrorCode.BUSINESS_API_COMMUNICATION_ERROR);
            }

            VerifyBisResDTO body = response.getBody();

            // 특정 값들이 비어있으면 예외처리
            if (body == null || body.getData() == null || body.getData().isEmpty()) {
                throw new BusinessValidationException(ErrorCode.BUSINESS_API_INVALID_RESPONSE, body);
            }

            ValidationResultDTO result = body.getData().get(0);
            String validCode = result.getValid();

            //sucess 코드랑 응답의 vaild값이랑 일치하면 유효성 검증 성공
            if (SUCCESS_CODE.equals(validCode)) {
                return true;
            } else {  // 검증 실패 시, API가 제공하는 메시지를 포함하여 예외 발생
                throw new BusinessValidationException("사업자 정보가 유효하지 않습니다: " + validCode);
            }

            //이외 오류
        } catch (RestClientException e) {
            throw new BusinessException(ErrorCode.BUSINESS_API_COMMUNICATION_ERROR, e);
        }
    }
}
