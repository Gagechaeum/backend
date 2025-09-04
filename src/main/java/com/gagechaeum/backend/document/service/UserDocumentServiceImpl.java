package com.gagechaeum.backend.document.service;

import com.gagechaeum.backend.common.util.S3ClientUtil;
import com.gagechaeum.backend.document.domain.UserDocument;
import com.gagechaeum.backend.document.dto.UserDocumentDownloadResponseDto;
import com.gagechaeum.backend.document.dto.UserDocumentUploadRequestDto;
import com.gagechaeum.backend.document.dto.response.UserDocumentResponseDTO;
import com.gagechaeum.backend.document.mapper.UserDocumentMapper;
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
            s3ClientUtil.uploadFile(requestDto.getFile(), key);
            
            UserDocument userDocument = UserDocument
                .builder().userId(userId)
//            .userId(user.getId())
                .documentId(requestDto.getDocumentId())
                .issuedAt(requestDto.getIssuedAt())
                .fileKey(key)
                .build();
            
            userDocumentMapper.insert(userDocument);
            
        } catch (IOException e) {
            throw new RuntimeException("파일 업로드 중 오류가 발생했습니다.");
        }
    }
    
    public UserDocumentDownloadResponseDto downloadUserDocuments(
        List<Long> ids
//        CustomUser user
    ) {
        if (ids == null || ids.isEmpty()) {
            throw new IllegalArgumentException("ids는 필수 쿼리 파라미터입니다.");
        }
        
        Long userId = 1L; // TODO: CustomUser ID로 변경
        
        if (ids.size() == 1) {
            return UserDocumentDownloadResponseDto.builder()
                .file(downloadSingleFile(userId, ids.get(0)))
                .build();
        }
        
        return UserDocumentDownloadResponseDto.builder()
            .zipFile(downloadMultiFiles(userId, ids))
            .build();
    }
    
    public void deleteUserDocuments(
        List<Long> ids
//        CustomUser user
    ) {
        if (ids == null || ids.isEmpty()) {
            throw new IllegalArgumentException("ids는 필수 쿼리 파라미터입니다.");
        }
        
        Long userId = 1L; // TODO: CustomUser ID로 변경
        
        for (Long userDocumentId : ids) {
            UserDocument userDocument = UserDocument
                .builder().userId(userId)
//            .userId(user.getId())
                .userDocumentId(userDocumentId)
                .build();
            
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
    
    private InputStream downloadSingleFile(Long userId, Long userDocumentId) {
        UserDocument userDocument = userDocumentMapper.getById(userId, userDocumentId);
        
        if (userDocument != null) {
            try {
                return s3ClientUtil.downloadFile(userDocument.getFileKey());
            } catch (IOException e) {
                throw new RuntimeException("파일 다운로드 중 오류가 발생했습니다.", e);
            }
        }
        throw new IllegalArgumentException("유효하지 않은 파일입니다.");
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
    ) {
        try (InputStream s3InputStream = s3ClientUtil.downloadFile(userDocument.getFileKey())) {
            String fileName = userDocument.getDocumentName();
            
            ZipEntry zipEntry = new ZipEntry(fileName);
            zipOutputStream.putNextEntry(zipEntry);
            
            byte[] buffer = new byte[1024];
            int len;
            while ((len = s3InputStream.read(buffer)) > 0) {
                zipOutputStream.write(buffer, 0, len);
            }
            
            zipOutputStream.closeEntry();
        } catch (IOException e) {
            log.error("파일 다운로드에 실패했습니다: " + userDocument.getDocumentName(), e);
        }
    }
}
