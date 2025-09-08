package com.gagechaeum.backend.user.controller;

import com.gagechaeum.backend.common.response.CustomResponse;
import com.gagechaeum.backend.common.response.ResponseCode;
import com.gagechaeum.backend.security.account.domain.CustomUserDetails;
import com.gagechaeum.backend.user.dto.BusinessInfoDTO;
import com.gagechaeum.backend.user.dto.BusinessInfoRequestDTO;
import com.gagechaeum.backend.user.dto.VerifyBisReqDTO;
import com.gagechaeum.backend.user.mapper.BusinessInfoMapper;
import com.gagechaeum.backend.user.service.BusinessInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping("/api/BusinessInfo")
@RequiredArgsConstructor
public class BusinessInfoController {

    private final BusinessInfoService service;

    @PostMapping("/save")
    public CustomResponse<Object> saveBisInfo(@AuthenticationPrincipal CustomUserDetails userDetails, @RequestBody BusinessInfoRequestDTO reqDto) {
        service.save(userDetails.getUserId(),reqDto);
        return CustomResponse.success(ResponseCode.SUCCESS, reqDto);
    }

    @PutMapping("/update")
    public CustomResponse<BusinessInfoDTO> updateBisInfo(@RequestBody BusinessInfoDTO reqDto) {
        service.update(reqDto);
        return CustomResponse.success(ResponseCode.SUCCESS, reqDto);
    }

    @GetMapping("/select")
    public CustomResponse<CustomUserDetails> selectBisInfo(@AuthenticationPrincipal CustomUserDetails userDetails) {
        service.selectAll(userDetails.getUserId());
        return CustomResponse.success(ResponseCode.SUCCESS, userDetails);
    }

    @GetMapping("/delete")
    public CustomResponse<Object> deleteBisInfo(BusinessInfoDTO reqDto) {
        service.delete(reqDto.getBusinessInfoId());
        return CustomResponse.success(ResponseCode.SUCCESS);
    }

    @GetMapping("/verifyBisNum")
    public CustomResponse<Boolean> verifyBisInfo(@AuthenticationPrincipal CustomUserDetails userDetails, @RequestParam Long bisNum, @RequestParam LocalDate startDate) {
        Boolean Validation=service.verifyBusinessInfo(userDetails.getTrueName(), bisNum, startDate);
        return CustomResponse.success(ResponseCode.BISNUM_VERIFY_SUCCESS, Validation);
    }
}
