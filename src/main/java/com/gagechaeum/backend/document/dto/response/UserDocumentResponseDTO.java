package com.gagechaeum.backend.document.dto.response;

import com.gagechaeum.backend.document.domain.UserDocument;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDocumentResponseDTO {
    private Long userDocumentId;
    private String documentName;
    private String issuedAt;
    private long daysElapsed;
    private String fileKey;

    public static UserDocumentResponseDTO from(UserDocument userDocument) {
        LocalDate issuedAtLocalDate = userDocument.getIssuedAt().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String issuedAtString = new SimpleDateFormat("yyyy-MM-dd").format(userDocument.getIssuedAt());

        return UserDocumentResponseDTO.builder()
                .userDocumentId(userDocument.getUserDocumentId())
                .documentName(userDocument.getDocumentName())
                .issuedAt(issuedAtString)
                .daysElapsed(ChronoUnit.DAYS.between(issuedAtLocalDate, LocalDate.now()))
                .fileKey(userDocument.getFileKey())
                .build();
    }
}