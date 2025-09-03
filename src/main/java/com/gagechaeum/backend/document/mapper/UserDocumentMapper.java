package com.gagechaeum.backend.document.mapper;

import com.gagechaeum.backend.document.domain.UserDocument;
import org.apache.ibatis.annotations.Param;

public interface UserDocumentMapper {
	int insert(UserDocument userDocument);
	
	String getFileUrlById(UserDocument userDocument);
	
	int deleteByUserDocumentId(Long userDocumentId);
}
