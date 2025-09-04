package com.gagechaeum.backend.document.controller;

import com.gagechaeum.backend.common.response.CustomResponse;
import com.gagechaeum.backend.common.response.ResponseCode;
import com.gagechaeum.backend.document.dto.UserDocumentUploadRequestDto;
import com.gagechaeum.backend.document.dto.response.UserDocumentResponseDTO;
import com.gagechaeum.backend.document.service.UserDocumentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/me/documents")
@RequiredArgsConstructor
public class UserDocumentController {
	private final UserDocumentService userDocumentService;

	// 내 서류 목록 조회
	@GetMapping("")
	public CustomResponse<List<UserDocumentResponseDTO>> getUserDocuments(
			// @AuthenticationPrincipal CustomUser user // 주석 해제 후 사용
	) {
		// Long userId = user.getId();
		Long userId = 1L; // 임시 사용자 ID
		List<UserDocumentResponseDTO> documents = userDocumentService.getUserDocuments(userId);
		return CustomResponse.success(ResponseCode.SUCCESS, documents);
	}
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public CustomResponse<Object> uploadUserDocument(
		@ModelAttribute UserDocumentUploadRequestDto requestDto
//		@AuthenticationPrincipal CustomUser user
	) {
//		userDocumentService.uploadUserDocument(requestDto, user);
		userDocumentService.uploadUserDocument(requestDto);
		return CustomResponse.success(ResponseCode.SUCCESS);
	}
	
	@GetMapping("/download")
	public CustomResponse<Object> downloadUserDocuments(
		@RequestParam List<Long> ids
//		@AuthenticationPrincipal CustomUser user
	) {
//		userDocumentService.downloadUserDocuments(ids, user);
		Object response = userDocumentService.downloadUserDocuments(ids);
		return CustomResponse.success(ResponseCode.SUCCESS, response);
	}
	
	@DeleteMapping("")
	public CustomResponse<Object> deleteUserDocuments(
		@RequestParam List<Long> ids
//		@AuthenticationPrincipal CustomUser user
	) {
//		userDocumentService.deleteUserDocuments(ids, user);
		userDocumentService.deleteUserDocuments(ids);
		return CustomResponse.success(ResponseCode.SUCCESS);
	}
}