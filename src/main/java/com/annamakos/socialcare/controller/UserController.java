package com.annamakos.socialcare.controller;

import com.annamakos.socialcare.model.User;
import com.annamakos.socialcare.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

//    @RequestMapping(value = "/user", method = RequestMethod.POST)
//    public User addUser(@RequestParam String name, @RequestParam String surname){
//        return this.userService.addUser(name, surname);
//    }
//
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> showUsers(){
        List<User> userList =  this.userService.showUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
}
