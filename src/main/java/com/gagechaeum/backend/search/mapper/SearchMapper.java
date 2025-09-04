package com.gagechaeum.backend.search.mapper;

import com.gagechaeum.backend.search.domain.SearchResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface SearchMapper {

    // 키워드로 정책과 대출을 통합 검색 (페이징 적용)
    List<SearchResult> findGlobalResultsByKeyword(@Param("keyword") String keyword,
                                                  @Param("offset") int offset,
                                                  @Param("size") int size);

    // 키워드에 해당하는 전체 결과 수 카운트 (페이징 미적용)
    long countGlobalResultsByKeyword(@Param("keyword") String keyword);
}
