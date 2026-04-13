package com.kirill.aws_example_project.service;

import com.kirill.aws_example_project.configuration.S3Configuration;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;



@Service
@AllArgsConstructor
public class S3Service {
    private final S3Client s3Client;
    private final S3Configuration configuration;

    public ResponseInputStream<GetObjectResponse> getFileFromS3(String key) {
        return s3Client.getObject(GetObjectRequest.builder()
                .bucket(configuration.getBucket())
                .key(key)
                .build());
    }
}
