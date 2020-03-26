package com.annamakos.socialcare.api.controller;

import com.annamakos.socialcare.api.dto.ApplicationFormDTO;
import com.annamakos.socialcare.api.dto.ChildFormDTO;
import com.annamakos.socialcare.api.service.ChildFormService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChildFormController {
    private ChildFormService childFormService;

    public ChildFormController(ChildFormService childFormService) {
        this.childFormService = childFormService;
    }

    @RequestMapping(value = "applicationform/addchild", method = RequestMethod.POST)
    public ResponseEntity<ChildFormDTO> addChildForm(
            @RequestBody String name,
            @RequestBody String surname,
            @RequestBody String PESEL,
            @RequestBody String citizenship,
            @RequestBody ApplicationFormDTO applicationFormDTO
    ) {
        ChildFormDTO childFormDTO = this.childFormService.addChildForm(
                name,
                surname,
                PESEL,
                citizenship,
                applicationFormDTO);
        return new ResponseEntity<>(childFormDTO, HttpStatus.OK);
    }
}
