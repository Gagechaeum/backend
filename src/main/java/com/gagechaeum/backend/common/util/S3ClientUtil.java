package com.gagechaeum.backend.common.util;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequiredArgsConstructor
public class S3ClientUtil {
	private final AmazonS3 s3Client;
	@Value("${cloud.aws.s3.bucket}") private String bucketName;
	
	// 파일 업로드
	public void uploadFile(MultipartFile file, String key) throws IOException {
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(file.getSize());
		
		s3Client.putObject(bucketName, key, file.getInputStream(), metadata);
	}
	
	// 파일 다운로드 url
	public String getFileUrl(String key) {
		GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName, key)
			.withMethod(HttpMethod.GET)
			.withExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 5));
		
		URL url = s3Client.generatePresignedUrl(request);
		return url.toString();
	}
	
	// 파일 다운로드 zip
	public InputStream downloadFile(String key) throws IOException {
		S3Object s3Object = s3Client.getObject(bucketName, key);
		return s3Object.getObjectContent();
	}

	// 파일 삭제
	public void deleteFile(String key) {
		s3Client.deleteObject(bucketName, key);
	}
}
