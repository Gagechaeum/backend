package com.gagechaeum.backend.document.service;

import com.gagechaeum.backend.common.util.S3ClientUtil;
import com.gagechaeum.backend.document.domain.UserDocument;
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
//        UserDocumentUploadRequestDto requestDto,
//        CustomUser user
    ) throws IOException {
        if (requestDto.getFile() == null ||
            requestDto.getFile().isEmpty() ||
            requestDto.getDocumentId() == null ||
            requestDto.getDocumentName() == null ||
            requestDto.getIssuedAt() == null
        ) {
            throw new IllegalArgumentException("파일과 메타데이터는 필수값이며, 빈 파일은 허용되지 않습니다.");
        }
        
        Long userId = 1L;
        
        String key = "userDocuments/" +
            userId + "/" +
//            user.getId() + "/" +
            requestDto.getDocumentId() + "/" +
            requestDto.getDocumentName();
        String s3Url = s3ClientUtil.uploadFile(requestDto.getFile(), key);
        
        UserDocument userDocument = UserDocument.
            builder().
            userId(userId).
//            userId(user.getId()).
            documentId(requestDto.getDocumentId()).
            issuedAt(requestDto.getIssuedAt()).
            fileUrl(s3Url).
            build();
        
        userDocumentMapper.insert(userDocument);
    }
}
