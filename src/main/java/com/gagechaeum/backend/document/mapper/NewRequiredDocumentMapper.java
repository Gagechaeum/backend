package com.gagechaeum.backend.document.mapper;

import com.gagechaeum.backend.document.domain.NewRequiredDocument;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewRequiredDocumentMapper {
    void save(NewRequiredDocument requiredDocument);
}
