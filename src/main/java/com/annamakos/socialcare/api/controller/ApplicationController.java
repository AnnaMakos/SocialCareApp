package com.annamakos.socialcare.api.controller;

import com.annamakos.socialcare.api.dto.ApplicationAddDTO;
import com.annamakos.socialcare.api.dto.ApplicationDTO;
import com.annamakos.socialcare.api.service.ApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationController {
    private ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @RequestMapping(value = "application/add", method = RequestMethod.POST)
    public ResponseEntity<ApplicationDTO> addApplication(@RequestBody ApplicationAddDTO applicationAddDTO){
        ApplicationDTO applicationDTO = this.applicationService.addApplication(applicationAddDTO);
        return new ResponseEntity<>(applicationDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "application/show", method = RequestMethod.GET)
    public ResponseEntity<List<ApplicationDTO>> findAllApplications(){
        List<ApplicationDTO> applications = this.applicationService.findAllApplications();
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }


}
