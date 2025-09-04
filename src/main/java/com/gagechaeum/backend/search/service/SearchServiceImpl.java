package com.gagechaeum.backend.search.service;

import com.gagechaeum.backend.search.domain.SearchResult;
import com.gagechaeum.backend.search.dto.response.SearchResponseDTO;
import com.gagechaeum.backend.search.mapper.SearchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final SearchMapper searchMapper;

    @Override
    @Transactional(readOnly = true)
    public SearchResponseDTO searchGlobal(String keyword, int page, int size) {
        // 1. 페이징을 위한 offset 계산
        int offset = page * size;

        // 2. DB에서 데이터 조회 (검색 결과 목록 + 전체 개수)
        List<SearchResult> searchResults = searchMapper.findGlobalResultsByKeyword(keyword, offset, size);
        long totalElements = searchMapper.countGlobalResultsByKeyword(keyword);

        // 3. Domain 객체를 DTO로 변환
        List<SearchResponseDTO.SearchResultDTO> resultDTOs = searchResults.stream()
                .map(SearchResponseDTO.SearchResultDTO::from)
                .collect(Collectors.toList());

        // 4. 페이징 정보 계산
        int totalPages = (int) Math.ceil((double) totalElements / size);
        SearchResponseDTO.PageInfo pageInfo = SearchResponseDTO.PageInfo.builder()
                .page(page)
                .size(size)
                .totalElements(totalElements)
                .totalPages(totalPages)
                .build();

        // 5. 최종 응답 DTO 조립 후 반환
        return SearchResponseDTO.builder()
                .pageInfo(pageInfo)
                .results(resultDTOs)
                .build();
    }
}

