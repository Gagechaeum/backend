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
    public Boolean verifyBusinessInfo(Long businessNum, String name, LocalDate date) {
        String API_URL = "https://api.odcloud.kr/api/nts-businessman/v1/validate";
        String SUCCESS_CODE = "01";

        String validationUrl = API_URL + "?serviceKey=" + serviceKey;
        String bNoStr = String.valueOf(businessNum);

        // 날짜를 YYYYMMDD 문자열로 변환
        String startDateStr = date.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        VerifyBisReqDTO businessInfo = new VerifyBisReqDTO(bNoStr, startDateStr, name);

        // 2. 위에서 정의한 DTO를 사용해 요청 본문(payload) 객체를 생성합니다.
        VerifyBisArrayReqDTO requestPayload = new VerifyBisArrayReqDTO(
                Collections.singletonList(businessInfo)
        );

        // 3. HTTP 헤더를 설정합니다. (JSON 데이터를 보내고, JSON 응답을 기대)
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // 4. HTTP 요청 객체(HttpEntity)를 생성합니다. (헤더 + 본문)
        HttpEntity<VerifyBisArrayReqDTO> entity = new HttpEntity<>(requestPayload, headers);

        try {
            // 5. RestTemplate을 사용하여 API에 POST 요청을 보냅니다.
            ResponseEntity<VerifyBisResDTO> response = restTemplate.postForEntity(
                    validationUrl,         // 요청 URL
                    entity,                // 요청 데이터 (헤더, 본문)
                    VerifyBisResDTO.class // 응답을 받을 DTO 클래스
            );

            // 6. API 응답을 처리합니다.
            // HTTP 상태 코드가 200 (OK)이고, 응답 본문이 존재할 경우
            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {

                VerifyBisResDTO body = response.getBody();

                // 응답 데이터(data)가 비어있지 않은지 확인합니다.
                if (body.getData() != null && !body.getData().isEmpty()) {
                    // 첫 번째 검증 결과의 'valid' 코드를 가져옵니다.
                    String validCode = body.getData().get(0).getValid();
                    // 'valid' 코드가 성공 코드("01")와 일치하는지 여부를 반환합니다.
                    return SUCCESS_CODE.equals(validCode);
                }
            }
        } catch (RestClientException e) {
            // API 통신 중 네트워크 오류 등이 발생하면 콘솔에 에러를 출력하고 false를 반환합니다.
            System.err.println("사업자 정보 검증 API 호출 중 오류 발생: " + e.getMessage());
            return false;
        }

        // 그 외 모든 경우 (예: 응답 코드가 200이 아니거나, 응답 본문이 비정상적인 경우)에는 false를 반환합니다.
        return false;
    }
}
