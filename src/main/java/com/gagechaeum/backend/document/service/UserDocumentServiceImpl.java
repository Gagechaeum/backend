package com.gagechaeum.backend.document.service;

import com.gagechaeum.backend.common.util.S3ClientUtil;
import com.gagechaeum.backend.document.domain.UserDocument;
import com.gagechaeum.backend.document.dto.UserDocumentDownloadResponseDto;
import com.gagechaeum.backend.document.dto.UserDocumentUploadRequestDto;
import com.gagechaeum.backend.document.dto.response.UserDocumentResponseDTO;
import com.gagechaeum.backend.document.mapper.UserDocumentMapper;
import com.gagechaeum.backend.user.domain.User;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDocumentServiceImpl implements UserDocumentService {
    private final UserDocumentMapper userDocumentMapper;
    private final S3ClientUtil s3ClientUtil;

    // 내 서류 목록 조회
    @Override
    @Transactional(readOnly = true)
    public List<UserDocumentResponseDTO> getUserDocuments(Long userId) {
        List<UserDocument> userDocuments = userDocumentMapper.findUserDocumentsByUserId(userId);
        return userDocuments.stream()
                .map(UserDocumentResponseDTO::from)
                .collect(Collectors.toList());
    }

    @Override
    public void uploadUserDocument(UserDocumentUploadRequestDto requestDto, User user) {
        requestDto.validate();
        
        Long userId = user.getUserId();
        
        String key = "userDocuments/" +
            userId + ":" +
            requestDto.getDocumentId() + ":" +
            requestDto.getDocumentName() + ".pdf";
        
        try {
            s3ClientUtil.uploadFile(requestDto.getFile(), key);
            
            UserDocument userDocument = UserDocument
                .builder()
                .userId(userId)
                .documentId(requestDto.getDocumentId())
                .documentName(requestDto.getDocumentName())
                .issuedAt(requestDto.getIssuedAt())
                .fileKey(key)
                .build();
            
            userDocumentMapper.deleteByName(userId, userDocument.getDocumentName());
            userDocumentMapper.insert(userDocument);
            
        } catch (IOException e) {
            throw new RuntimeException("파일 업로드 중 오류가 발생했습니다.");
        }
    }
    
    public UserDocumentDownloadResponseDto downloadUserDocuments(List<Long> ids, User user) {
        if (ids == null || ids.isEmpty()) {
            throw new IllegalArgumentException("ids는 필수 쿼리 파라미터입니다.");
        }
        
        Long userId = user.getUserId();
        
        if (ids.size() == 1) {
            return UserDocumentDownloadResponseDto.builder()
                .fileUrl(downloadSingleFile(userId, ids.get(0)))
                .build();
        }
        
        return UserDocumentDownloadResponseDto.builder()
            .zipFile(downloadMultiFiles(userId, ids))
            .build();
    }
    
    public void deleteUserDocuments(List<Long> ids, User user) {
        if (ids == null || ids.isEmpty()) {
            throw new IllegalArgumentException("ids는 필수 쿼리 파라미터입니다.");
        }
        
        Long userId = user.getUserId();
        
        for (Long userDocumentId : ids) {
            String fileKey = userDocumentMapper.getFileKeyById(userId, userDocumentId);
            
            try {
                if (fileKey != null) {
                    s3ClientUtil.deleteFile(fileKey);
                    userDocumentMapper.deleteById(userId, userDocumentId);
                }
            } catch (Exception e) {
                throw new RuntimeException("파일 삭제 중 오류가 발생했습니다.", e);
            }
        }
    }
    
    private String downloadSingleFile(Long userId, Long userDocumentId) {
        UserDocument userDocument = userDocumentMapper.getById(userId, userDocumentId);
        
        if (userDocument != null) {
            return s3ClientUtil.getFileUrl(userDocument.getFileKey());
        }
        throw new IllegalArgumentException("존재하지 않는 파일입니다.");
    }
    
    private byte[] downloadMultiFiles(Long userId, List<Long> ids) {
        try (
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ZipOutputStream zipOutputStream = new ZipOutputStream(baos)
        ) {
            for (Long userDocumentId : ids) {
                UserDocument userDocument = userDocumentMapper.getById(userId, userDocumentId);
                
                if (userDocument != null) {
                    writeSingleEntry(userDocument, zipOutputStream);
                }
            }
            zipOutputStream.finish();
            return baos.toByteArray();
            
        } catch (IOException e) {
            throw new RuntimeException("파일 다운로드 중 오류가 발생했습니다.", e);
        }
    }
    
    private void writeSingleEntry(
        UserDocument userDocument,
        ZipOutputStream zipOutputStream
    ) throws IOException {
        try (InputStream s3InputStream = s3ClientUtil.downloadFile(userDocument.getFileKey())) {
            String fileName = userDocument.getDocumentName() + ".pdf";
            
            ZipEntry zipEntry = new ZipEntry(fileName);
            zipOutputStream.putNextEntry(zipEntry);
            
            byte[] buffer = new byte[1024];
            int len;
            while ((len = s3InputStream.read(buffer)) > 0) {
                zipOutputStream.write(buffer, 0, len);
            }
            
            zipOutputStream.closeEntry();
        }
    }
}
