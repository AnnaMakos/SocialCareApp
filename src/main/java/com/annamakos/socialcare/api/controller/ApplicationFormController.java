package com.annamakos.socialcare.api.controller;

import com.annamakos.socialcare.api.dto.ApplicationFormBasicDTO;
import com.annamakos.socialcare.api.dto.ApplicationFormDTO;
import com.annamakos.socialcare.api.model.ApplicationForm;
import com.annamakos.socialcare.api.model.ApplicationStatus;
import com.annamakos.socialcare.api.model.User;
import com.annamakos.socialcare.api.service.ApplicationFormService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationFormController {
    private ApplicationFormService applicationFormService;

    public ApplicationFormController(ApplicationFormService applicationFormService) {
        this.applicationFormService = applicationFormService;
    }

    @RequestMapping(value = "applicationform/addform", method = RequestMethod.POST)
    public ResponseEntity<ApplicationFormDTO> addApplicationFormWithoutChildren(@RequestBody ApplicationFormBasicDTO app) {
        ApplicationFormDTO applicationFormDTO = this.applicationFormService.addApplicationFormWithoutChildren(app);
        return new ResponseEntity<>(applicationFormDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "applicationform/saveform", method = RequestMethod.PUT)
    public ResponseEntity<ApplicationFormDTO> alterApplicationFormAddChildren(@RequestBody ApplicationFormDTO applicationFormDTO) {
        ApplicationFormDTO appFormDTO = this.applicationFormService.alterApplicationFormAddChildren(applicationFormDTO);
        return new ResponseEntity<>(appFormDTO, HttpStatus.OK);
    }
}
