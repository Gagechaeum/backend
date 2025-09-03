package com.gagechaeum.backend.document.mapper;

import com.gagechaeum.backend.document.domain.UserDocument;

public interface UserDocumentMapper {
	int insert(UserDocument userDocument);
	
	String getFileUrlById(UserDocument userDocument);
	
	int deleteById(UserDocument userDocument);
}
