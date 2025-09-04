package com.gagechaeum.backend.search.service;

import com.gagechaeum.backend.search.dto.response.SearchResponseDTO;

public interface SearchService {
    SearchResponseDTO searchGlobal(String keyword, int page, int size);
}

