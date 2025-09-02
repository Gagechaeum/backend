package com.gagechaeum.backend.document.controller;

import com.gagechaeum.backend.common.response.CustomResponse;
import com.gagechaeum.backend.common.response.ResponseCode;
import com.gagechaeum.backend.document.dto.UserDocumentUploadRequestDto;
import com.gagechaeum.backend.document.service.UserDocumentService;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/me/documents")
@RequiredArgsConstructor
public class UserDocumentController {
	private final UserDocumentService userDocumentService;
	
	@PostMapping("")
	public CustomResponse<Object> uploadUserDocument(
		@RequestBody UserDocumentUploadRequestDto requestDto,
		@AuthenticationPrincipal CustomUser user
	) throws IOException {
		userDocumentService.uploadUserDocument(requestDto, user);
		return CustomResponse.success(ResponseCode.SUCCESS);
	}
}