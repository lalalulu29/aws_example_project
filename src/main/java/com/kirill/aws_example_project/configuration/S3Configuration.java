package com.kirill.aws_example_project.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("aws.s3")
public class S3Configuration {
    private String region;
    private String accessKey;
    private String secretAccessKey;
    private String bucket;
}
