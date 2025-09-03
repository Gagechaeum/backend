package com.gagechaeum.backend.document.dto;

import java.util.List;
import lombok.Data;

@Data
public class UserDocumentDeleteRequestDto {
	private List<Long> userDocumentIds;
	
	public void validate() {
		if (this.getUserDocumentIds() == null ||
			this.getUserDocumentIds().isEmpty()
		) {
			throw new IllegalArgumentException("파일 ID는 필수값이며, 1개 이상의 리스트로 전달되어야 합니다.");
		}
	}
}
