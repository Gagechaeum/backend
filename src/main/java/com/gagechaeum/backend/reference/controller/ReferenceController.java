package com.gagechaeum.backend.reference.controller;

import com.gagechaeum.backend.common.response.CustomResponse;
import com.gagechaeum.backend.common.response.ResponseCode;
import com.gagechaeum.backend.reference.service.ReferenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class ReferenceController {
	private final ReferenceService referenceService;
	
	@GetMapping("/documents/types")
	public CustomResponse<Object> getDocumentTypes() {
		Object response = referenceService.getDocumentTypes();
		return CustomResponse.success(ResponseCode.SUCCESS, response);
	}
	
	@GetMapping("/industries/types")
	public CustomResponse<Object> getIndustryTypes() {
		Object response = referenceService.getIndustryTypes();
		return CustomResponse.success(ResponseCode.SUCCESS, response);
	}
	
	@GetMapping("/regions/types")
	public CustomResponse<Object> getRegionTypes() {
		Object response = referenceService.getRegionTypes();
		return CustomResponse.success(ResponseCode.SUCCESS, response);
	}
}
