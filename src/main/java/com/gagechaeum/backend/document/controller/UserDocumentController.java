package com.gagechaeum.backend.document.controller;

import com.gagechaeum.backend.common.response.CustomResponse;
import com.gagechaeum.backend.common.response.ResponseCode;
import com.gagechaeum.backend.document.dto.UserDocumentDeleteRequestDto;
import com.gagechaeum.backend.document.dto.UserDocumentUploadRequestDto;
import com.gagechaeum.backend.document.service.UserDocumentService;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/me/documents", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
@RequiredArgsConstructor
public class UserDocumentController {
	private final UserDocumentService userDocumentService;
	
	@PostMapping("")
	public CustomResponse<Object> uploadUserDocument(
		@ModelAttribute UserDocumentUploadRequestDto requestDto
//		@AuthenticationPrincipal CustomUser user
	) {
//		userDocumentService.uploadUserDocument(requestDto, user);
		userDocumentService.uploadUserDocument(requestDto);
		return CustomResponse.success(ResponseCode.SUCCESS);
	}
	
	@DeleteMapping("")
	public CustomResponse<Object> deleteUserDocument(
		@RequestBody UserDocumentDeleteRequestDto requestDto
//		@AuthenticationPrincipal CustomUser user
	) {
//		userDocumentService.deleteUserDocument(requestDto, user);
		userDocumentService.deleteUserDocument(requestDto);
		return CustomResponse.success(ResponseCode.SUCCESS);
	}
}