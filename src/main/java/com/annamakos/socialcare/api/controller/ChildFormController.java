package com.annamakos.socialcare.api.controller;

import com.annamakos.socialcare.api.dto.ChildFormBasicDTO;
import com.annamakos.socialcare.api.dto.ChildFormDTO;
import com.annamakos.socialcare.api.service.ChildFormService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChildFormController {
    private ChildFormService childFormService;

    public ChildFormController(ChildFormService childFormService) {
        this.childFormService = childFormService;
    }

    @RequestMapping(value = "applicationform/addchild/{id}", method = RequestMethod.POST)
    public ResponseEntity<ChildFormDTO> addChildForm(@RequestBody ChildFormBasicDTO childFormBasicDTO, @PathVariable int id) {
        ChildFormDTO childFormDTO = this.childFormService.addChildForm(childFormBasicDTO, id);
        return new ResponseEntity<>(childFormDTO, HttpStatus.OK);
    }
}
