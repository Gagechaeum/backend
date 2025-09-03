package com.gagechaeum.backend.document.service;

import com.gagechaeum.backend.document.dto.UserDocumentDownloadResponseDto;
import com.gagechaeum.backend.document.dto.UserDocumentUploadRequestDto;
import java.util.List;

public interface UserDocumentService {
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
