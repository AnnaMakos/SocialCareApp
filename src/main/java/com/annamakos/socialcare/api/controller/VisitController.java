package com.annamakos.socialcare.api.controller;

import com.annamakos.socialcare.api.dto.UserDTO;
import com.annamakos.socialcare.api.dto.VisitDTO;
import com.annamakos.socialcare.api.service.VisitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/visits/alter/{username}/{id}", method = RequestMethod.PUT)
    public ResponseEntity<VisitDTO> alterVisitToTaken(@PathVariable String username, @PathVariable long id){
        VisitDTO visitDTO = this.visitService.alterVisitToTaken(username, id);
        System.out.println("=>>> visit id: " + id + " username: " + username);
        return new ResponseEntity<>(visitDTO, HttpStatus.OK);
    }


}
