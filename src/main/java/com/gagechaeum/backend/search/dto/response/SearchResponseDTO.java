package com.gagechaeum.backend.search.dto.response;

import com.gagechaeum.backend.search.domain.SearchResult;
import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter
@Builder
public class SearchResponseDTO {
    private PageInfo pageInfo;
    private List<SearchResultDTO> results;

    @Getter
    @Builder
    public static class PageInfo {
        private int page;
        private int size;
        private long totalElements;
        private int totalPages;
    }

    @Getter
    @Builder
    public static class SearchResultDTO {
        private String type;
        private String id;
        private String name;
        private String industryName;

        public static SearchResultDTO from(SearchResult domain) {
            return SearchResultDTO.builder()
                    .type(domain.getType())
                    .id(domain.getId())
                    .name(domain.getName())
                    .industryName(domain.getIndustryName())
                    .build();
        }
    }
}
