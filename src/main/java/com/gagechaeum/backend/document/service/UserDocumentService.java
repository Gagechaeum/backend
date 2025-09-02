package com.gagechaeum.backend.document.service;

import com.gagechaeum.backend.document.dto.UserDocumentUploadRequestDto;
import java.io.IOException;

public interface UserDocumentService {
	void uploadUserDocument(
		UserDocumentUploadRequestDto requestDto,
		CustomUser user
	) throws IOException;
}
