package com.gagechaeum.backend.bookmark.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookmarkProductResponseDto {

    private String name;           // 정책명 또는 상품명
    private String type;           // "POLICY" 또는 "LOAN"
    private String organization;   // 소관기관명 또는 금융회사명
    private Long dDay;             // 마감일까지 남은 기간 (대출 상품의 경우 null)
    private String documentStatus; // 서류 개수 상태 (예: "1/5")

    private Long prepared;         // 준비된 서류 개수
    private Long required;         // 필요한 서류 개수

    public String getDocumentStatus() {
        if (prepared == null || required == null) {
            return null;
        }
        return prepared + "/" + required;
    }
}
