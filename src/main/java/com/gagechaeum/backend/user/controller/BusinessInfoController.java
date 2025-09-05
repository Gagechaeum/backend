package com.gagechaeum.backend.user.controller;

import com.gagechaeum.backend.common.response.CustomResponse;
import com.gagechaeum.backend.common.response.ResponseCode;
import com.gagechaeum.backend.security.account.domain.CustomUserDetails;
import com.gagechaeum.backend.user.dto.BusinessInfoDTO;
import com.gagechaeum.backend.user.dto.BusinessInfoRequestDTO;
import com.gagechaeum.backend.user.mapper.BusinessInfoMapper;
import com.gagechaeum.backend.user.service.BusinessInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/BusinessInfo")
@RequiredArgsConstructor
public class BusinessInfoController {

    private final BusinessInfoService service;

    @PostMapping("/save-bis-info")
    public CustomResponse<Object> saveBisInfo(@AuthenticationPrincipal CustomUserDetails userDetails, @RequestBody BusinessInfoRequestDTO reqDto) {

        service.save(userDetails.getUserId(),reqDto);
        return CustomResponse.success(ResponseCode.SUCCESS, reqDto);
    }

    @GetMapping("/save-bis-info")
    public CustomResponse<Object> saveBisInfo(BusinessInfoDTO reqDto) {

        return CustomResponse.success(ResponseCode.SUCCESS, response);
    }

    @GetMapping("/update-bis-info")
    public CustomResponse<Object> saveBisInfo(BusinessInfoDTO reqDto) {

        return CustomResponse.success(ResponseCode.SUCCESS, response);
    }

    @GetMapping("/select-bis-info")
    public CustomResponse<Object> saveBisInfo(BusinessInfoDTO reqDto) {

        return CustomResponse.success(ResponseCode.SUCCESS, response);
    }

    @GetMapping("/delete-bis-info")
    public CustomResponse<Object> saveBisInfo(BusinessInfoDTO reqDto) {

        return CustomResponse.success(ResponseCode.SUCCESS, response);
    }

    @GetMapping("/is-bis-real")
    public CustomResponse<Object> saveBisInfo(BusinessInfoDTO reqDto) {

        return CustomResponse.success(ResponseCode.SUCCESS, response);
    }
}
