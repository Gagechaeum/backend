package com.gagechaeum.backend.document.service;

import com.gagechaeum.backend.document.dto.UserDocumentDownloadResponseDto;
import com.gagechaeum.backend.document.dto.UserDocumentUploadRequestDto;
import com.gagechaeum.backend.document.dto.response.UserDocumentResponseDTO;

import java.util.List;

public interface UserDocumentService {

	// 내 서류 목록 조회
	List<UserDocumentResponseDTO> getUserDocuments(Long userId);

	void uploadUserDocument(
		UserDocumentUploadRequestDto requestDto
//		CustomUser user
	);
	
	UserDocumentDownloadResponseDto downloadUserDocuments(
		List<Long> ids
//		CustomUser user
	);
	
	void deleteUserDocuments(
		List<Long> ids
//		CustomUser user
	);
}
