package com.action.trends.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.action.trends.repository.S3UploadMapper;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class S3ServiceImpl implements S3Service {

	private static final Logger LOGGER = LoggerFactory.getLogger(S3ServiceImpl.class);

	@Autowired
	private S3UploadMapper s3UploadMapper;

	@Autowired
	private AmazonS3 amazonS3;
	@Value("${aws.s3.bucket}")
	private String bucketName;

	@Override
	@Async // @Async annotation을 사용하면 해당 method가 다른 thread에서 실행되게 할 수 있다!!
	public void uploadFile(final MultipartFile multipartFile, int id, int type) {
		LOGGER.info("File upload in progress...");
		try {
			final File file = convertMultiPartFileToFile(multipartFile);
			if (type == 0) {
				uploadFileToS3Bucket(bucketName, file, id, type);
			} else if (type == 1) {
				uploadFileToS3Bucket(bucketName, file, id, type);
			}

			LOGGER.info("File upload is completed.");
			Boolean result = file.delete(); // S3 업로드 후 프로젝트에 저장된 파일 지우기
			System.out.println("Delete result?" + result);
		} catch (final AmazonServiceException ex) {
			LOGGER.info("File upload is failed.");
			LOGGER.error("Error= {} while uploading file.", ex.getMessage());
		}
	}

	private File convertMultiPartFileToFile(final MultipartFile multipartFile) {
		final File file = new File(multipartFile.getOriginalFilename());
		try (final FileOutputStream outputStream = new FileOutputStream(file)) {
			outputStream.write(multipartFile.getBytes());
		} catch (final IOException ex) {
			LOGGER.error("Error converting the multi-part file to file= ", ex.getMessage());
		}
		return file;
	}

	private void uploadFileToS3Bucket(final String bucketName, final File file, int id, int type) {
		if (type == 0) {
			String uniqueFileName = LocalDateTime.now() + "_" + Integer.toString(id);
			LOGGER.info("Uploading file with name= " + uniqueFileName);

			final PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, uniqueFileName, file);
			amazonS3.putObject(putObjectRequest);

			String url = "https://trendsaction.s3.ap-northeast-2.amazonaws.com/" + uniqueFileName;
			s3UploadMapper.uploadProfileImage(id, url);
		} else if (type == 1) {
			String uniqueFileName = LocalDateTime.now() + "_board" + Integer.toString(id);
			LOGGER.info("Uploading file with name= " + uniqueFileName);

			final PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, uniqueFileName, file);
			amazonS3.putObject(putObjectRequest);

			String url = "https://trendsaction.s3.ap-northeast-2.amazonaws.com/" + uniqueFileName;
			s3UploadMapper.uploadBoardProfileImage(id, url);
		}

	}
}
