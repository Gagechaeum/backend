package com.gagechaeum.backend.document.mapper;

import com.gagechaeum.backend.document.domain.Document;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DocumentMapper {
    List<Document> findAll();
}
