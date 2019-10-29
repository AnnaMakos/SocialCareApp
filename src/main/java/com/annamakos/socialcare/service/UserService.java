package com.annamakos.socialcare.service;

import com.annamakos.socialcare.model.User;
import com.annamakos.socialcare.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User addUser(String name, String surname){
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        this.userRepository.save(user);
        return user;
    }

    public List<User> showUsers(){
        List<User> list = new ArrayList<>();
        list = this.userRepository.findAll();
        return list;
    }
}
