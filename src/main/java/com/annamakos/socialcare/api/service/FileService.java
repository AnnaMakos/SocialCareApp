package com.annamakos.socialcare.api.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.annamakos.socialcare.api.model.Application;
import com.annamakos.socialcare.aws.AWSClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
@Data
public class FileService {

    private AWSClient awsClient;
    private AmazonS3 amazonS3;
    private ApplicationService applicationService;

    @Value("${aws.bucket.name}")
    private String bucketName;
    @Value("${aws.bucket.endpoint}")
    private String bucketEndpoint;

    public FileService(AWSClient awsClient, ApplicationService applicationService) {
        this.awsClient = awsClient;
        this.amazonS3 = awsClient.getAmazonS3();
        this.applicationService = applicationService;
    }

    public void uploadFileToS3Bucket(String fileName, File file) {
        amazonS3.putObject(new PutObjectRequest(bucketName, fileName, file).withCannedAcl(CannedAccessControlList.PublicRead));
    }


    private File convertMultipartToFile(MultipartFile file) throws IOException {
        File convertedFile = new File(file.getOriginalFilename());
        FileOutputStream fileOutputStream = new FileOutputStream(convertedFile);
        fileOutputStream.write(file.getBytes());
        fileOutputStream.close();
        return convertedFile;
    }

    public void uploadApplicationFile(MultipartFile multipartFile, long id) {
        String path = "";
        Application application = applicationService.findById(id);

        try {
            File file = convertMultipartToFile(multipartFile);
            String fileName = file.getName();
            path = bucketEndpoint + "/" + fileName;
            uploadFileToS3Bucket(fileName, file);
            application.setPath(path);
            applicationService.saveApplication(application);
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("File loading problem");
        }

    }
}
