package com.annamakos.socialcare.api.controller;

import com.annamakos.socialcare.api.dto.ApplicationFormBasicDTO;
import com.annamakos.socialcare.api.dto.ApplicationFormDTO;
import com.annamakos.socialcare.api.service.ApplicationFormService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationFormController {
    private ApplicationFormService applicationFormService;

    public ApplicationFormController(ApplicationFormService applicationFormService) {
        this.applicationFormService = applicationFormService;
    }

    @RequestMapping(value =  "applicationform/show/{username}", method = RequestMethod.GET)
    public ResponseEntity<List<ApplicationFormDTO>> findAllByApplicantUsername(@PathVariable String username){
        List<ApplicationFormDTO> list = applicationFormService.findAllByApplicantUsername(username);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "applicationform/addform", method = RequestMethod.POST)
    public ResponseEntity<ApplicationFormDTO> addApplicationFormWithoutChildren(@RequestBody ApplicationFormBasicDTO app) {
        ApplicationFormDTO applicationFormDTO = this.applicationFormService.addApplicationFormWithoutChildren(app);
        return new ResponseEntity<>(applicationFormDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "applicationform/saveform/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ApplicationFormDTO> alterApplicationFormAddChildren(@PathVariable int id) {
        ApplicationFormDTO appFormDTO = this.applicationFormService.alterApplicationFormAddChildren(id);
        return new ResponseEntity<>(appFormDTO, HttpStatus.OK);
    }
}
