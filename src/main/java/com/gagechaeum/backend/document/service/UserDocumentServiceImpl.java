package com.gagechaeum.backend.document.service;

import com.gagechaeum.backend.common.util.S3ClientUtil;
import com.gagechaeum.backend.document.domain.UserDocument;
import com.gagechaeum.backend.document.dto.UserDocumentDeleteRequestDto;
import com.gagechaeum.backend.document.dto.UserDocumentUploadRequestDto;
import com.gagechaeum.backend.document.mapper.UserDocumentMapper;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDocumentServiceImpl implements UserDocumentService {
    private final UserDocumentMapper userDocumentMapper;
    private final S3ClientUtil s3ClientUtil;
    
    @Override
    public void uploadUserDocument(
        UserDocumentUploadRequestDto requestDto
//        CustomUser user
    ) {
        requestDto.validate();
        
        Long userId = 1L; // TODO: CustomUser ID로 변경
        
        String key = "userDocuments/" +
            userId + "/" +
//            user.getId() + "/" +
            requestDto.getDocumentId() + "/" +
            requestDto.getDocumentName();
        
        try {
            String s3Url = s3ClientUtil.uploadFile(requestDto.getFile(), key);
            
            UserDocument userDocument = UserDocument
                .builder().userId(userId)
//            .userId(user.getId())
                .documentId(requestDto.getDocumentId())
                .issuedAt(requestDto.getIssuedAt())
                .fileUrl(s3Url)
                .build();
            
            userDocumentMapper.insert(userDocument);
            
        } catch (IOException e) {
            throw new RuntimeException("파일 업로드 중 오류가 발생했습니다.");
        }
    }
    
    public void deleteUserDocument(
        UserDocumentDeleteRequestDto requestDto
//        CustomUser user
    ) {
        requestDto.validate();
        
        Long userId = 1L; // TODO: CustomUser ID로 변경
        
        for (Long userDocumentId : requestDto.getUserDocumentIds()) {
            UserDocument userDocument = UserDocument
                .builder().userId(userId)
//            .userId(user.getId())
                .userDocumentId(userDocumentId)
                .build();
            
            String fileUrl = userDocumentMapper.getFileUrlById(userDocument);
            
            if (fileUrl != null) {
                s3ClientUtil.deleteFile(fileUrl);
                userDocumentMapper.deleteByUserDocumentId(userDocumentId);
            }
        }
    }
}
