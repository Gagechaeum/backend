package com.gagechaeum.backend.policy.controller;

import com.gagechaeum.backend.common.response.CustomResponse;
import com.gagechaeum.backend.common.response.ResponseCode;
import com.gagechaeum.backend.common.response.ResponseCode;
import com.gagechaeum.backend.policy.service.NewPolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/new-policies")
public class NewPolicyController {

    private final NewPolicyService newPolicyService;

    @PostMapping("/{serviceId}/documents")
    public CustomResponse<Void> fetchAndSavePolicyDocuments(@PathVariable String serviceId) {
        newPolicyService.fetchAndSavePolicyDocuments(serviceId);
        return CustomResponse.success(ResponseCode.SUCCESS);
    }
}

