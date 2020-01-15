package com.annamakos.socialcare.api.controller;

import com.annamakos.socialcare.api.dto.UserDTO;
import com.annamakos.socialcare.api.dto.VisitDTO;
import com.annamakos.socialcare.api.service.VisitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VisitController {
    VisitService visitService;

    public VisitController(VisitService visitService){
        this.visitService = visitService;
    }

    @RequestMapping(value = "/visits", method = RequestMethod.GET)
    public ResponseEntity<List<VisitDTO>> findAllVisits(){
        List<VisitDTO> visits = this.visitService.findAllVisits();
        return new ResponseEntity<>(visits, HttpStatus.OK);
    }


}
