package com.gagechaeum.backend.document.mapper;

import com.gagechaeum.backend.document.domain.NewDocument;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewDocumentMapper {
    List<NewDocument> findAll();
}
