package com.gagechaeum.backend.search.controller;

import com.gagechaeum.backend.common.response.CustomResponse;
import com.gagechaeum.backend.common.response.ResponseCode;
import com.gagechaeum.backend.search.dto.response.SearchResponseDTO;
import com.gagechaeum.backend.search.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/search")
    public ResponseEntity<CustomResponse<SearchResponseDTO>> search(
            @RequestParam("keyword") String keyword,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "20") int size) {

        SearchResponseDTO searchResponse = searchService.searchGlobal(keyword, page, size);

        return ResponseEntity
                .status(ResponseCode.SUCCESS.getHttpStatus())
                .body(CustomResponse.success(ResponseCode.SUCCESS, searchResponse));
    }
}

