package com.annamakos.socialcare.aws;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Data
public class AWSClient {

    @Value("${aws.access.key}")
    private String accessKey;

    @Value("${aws.secret.key}")
    private String secretKey;
    private AmazonS3 amazonS3;

    @PostConstruct
    private void initAWS()  {
        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
        this.amazonS3 = AmazonS3ClientBuilder
                .standard()
                .withRegion("eu-west-3")
                .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
                .build();
    }


}
