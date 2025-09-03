package com.gagechaeum.backend.document.mapper;

import com.gagechaeum.backend.document.domain.UserDocument;
import org.apache.ibatis.annotations.Param;

public interface UserDocumentMapper {
	int insert(UserDocument userDocument);
	
	UserDocument getById(
		@Param("userId") Long userId,
		@Param("userDocumentId") Long userDocumentId
	);
	
	String getFileKeyById(
		@Param("userId") Long userId,
		@Param("userDocumentId") Long userDocumentId
	);
	
	int deleteById(
		@Param("userId") Long userId,
		@Param("userDocumentId") Long userDocumentId
	);
}
