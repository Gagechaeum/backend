package com.gagechaeum.backend.document.mapper;

import com.gagechaeum.backend.document.domain.RequiredDocument;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RequiredDocumentMapper {
    void save(RequiredDocument requiredDocument);
}
