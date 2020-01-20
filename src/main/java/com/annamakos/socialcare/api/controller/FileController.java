package com.annamakos.socialcare.api.controller;

import com.annamakos.socialcare.api.service.FileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {
    private FileService fileService;

    public FileController(FileService fileService){
        this.fileService = fileService;
    }

    @RequestMapping(value = "files/upload/application/{id}", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> uploadFile(@RequestPart(value = "file") MultipartFile multipartFile, @PathVariable long id) {
        fileService.uploadApplicationFile(multipartFile, id);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
