package com.annamakos.socialcare.controller;

import com.annamakos.socialcare.model.User;
import com.annamakos.socialcare.service.UserService;
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

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User addUser(@RequestParam String name, @RequestParam String surname){
        return this.userService.addUser(name, surname);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> showUsers(){
        return this.userService.showUsers();
    }
}
