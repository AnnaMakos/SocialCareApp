package com.annamakos.socialcare.api.controller;

import com.annamakos.socialcare.api.dto.UserBasicDTO;
import com.annamakos.socialcare.api.dto.UserDTO;
import com.annamakos.socialcare.api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        List<UserDTO> userList = this.userService.findAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/users/institution/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findUsersByInstitution(@PathVariable int id) {
        List<UserDTO> users = userService.findUsersByInstitution(id);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/officials/institution/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<UserBasicDTO>> findOfficialsByInstitution(@PathVariable int id) {
        List<UserBasicDTO> users = userService.findOfficialsByInstitution(id);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/users/alterrole/{username}/{role}", method = RequestMethod.PUT)
    public ResponseEntity<UserDTO> alterUserRole(@PathVariable String username, @PathVariable String role) {
        UserDTO user = userService.alterUserRole(username, role);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/users/alterinstitution/{username}/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserDTO> alterUserInstitution(@PathVariable String username, @PathVariable int id) {
        UserDTO user = userService.alterUserInstitution(username, id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/users/{rolename}", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findUsersByRole(@PathVariable String rolename) {
        List<UserDTO> users = userService.findByRole(rolename);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/officials", method = RequestMethod.GET)
    public ResponseEntity<List<UserBasicDTO>> findOfficials() {
        List<UserBasicDTO> users = userService.findOfficials();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/current", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getCurrentUser(){
        UserDTO userDTO = userService.getCurrentUser();
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

}
