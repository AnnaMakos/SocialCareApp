package com.annamakos.socialcare.security.controller;

import com.annamakos.socialcare.api.model.Role;
import com.annamakos.socialcare.api.model.RoleName;
import com.annamakos.socialcare.api.model.User;
import com.annamakos.socialcare.api.repository.RoleRepository;
import com.annamakos.socialcare.api.repository.UserRepository;
import com.annamakos.socialcare.security.message.request.Signup;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class SignupController {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    RoleRepository roleRepository;

    public SignupController(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<String> registerUser(@RequestBody Signup signup) {
        if (userRepository.existsByUsername(signup.getUsername())) {
            return new ResponseEntity<>("Username is already used.", HttpStatus.BAD_REQUEST);
        }

        if (userRepository.existsByEmail(signup.getEmail())) {
            return new ResponseEntity<>("Email is already used.", HttpStatus.BAD_REQUEST);
        }
        User user = new User(signup.getName(), signup.getSurname(), signup.getUsername(), signup.getEmail(), signup.getPesel(), signup.getStreet(), signup.getStreetNumber(), signup.getLocalNumber(), signup.getPostcode(), signup.getCity(),
                passwordEncoder.encode(signup.getPassword()));
        Set<Role> roles = new HashSet<>();
        signup.getRoles().forEach(role -> {
            switch (role) {
                case "admin":
                    Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Admin role not found."));
                    roles.add(adminRole);
                    break;
                case "user":
                    Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("User role not found."));
                    roles.add(userRole);
                    break;
                case "official":
                    Role officialRole = roleRepository.findByName(RoleName.ROLE_OFFICIAL)
                            .orElseThrow(() -> new RuntimeException("Official role not found."));
                    roles.add(officialRole);
                    break;
            }

        });
        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok("User registered.");
    }
}
