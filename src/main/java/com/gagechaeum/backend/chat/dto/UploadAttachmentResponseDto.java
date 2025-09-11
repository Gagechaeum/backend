package com.gagechaeum.backend.chat.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UploadAttachmentResponseDto {
	private List<UploadedAttachmentDto> attachments;
}
