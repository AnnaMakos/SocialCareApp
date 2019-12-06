package com.annamakos.socialcare.api.controller;

import com.annamakos.socialcare.api.dto.InstitutionDTO;
import com.annamakos.socialcare.api.dto.UserDTO;
import com.annamakos.socialcare.api.service.InstitutionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InstitutionController {

    InstitutionService institutionService;

    public InstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @RequestMapping(value = "/institutions", method = RequestMethod.GET)
    public ResponseEntity<List<InstitutionDTO>> findAllInstitutions(){
        List<InstitutionDTO> institutions = this.institutionService.findAllInstitutions();
        return new ResponseEntity<>(institutions, HttpStatus.OK);
    }
}
