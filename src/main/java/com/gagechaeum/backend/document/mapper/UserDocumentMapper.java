package com.gagechaeum.backend.document.mapper;

import com.gagechaeum.backend.document.domain.UserDocument;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDocumentMapper {
	// 내 서류 목록 조회
	List<UserDocument> findUserDocumentsByUserId(Long userId);

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
