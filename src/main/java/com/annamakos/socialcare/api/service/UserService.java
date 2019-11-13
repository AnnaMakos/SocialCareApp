package com.annamakos.socialcare.api.service;

import com.annamakos.socialcare.api.model.Institution;
import com.annamakos.socialcare.api.model.Role;
import com.annamakos.socialcare.api.model.RoleName;
import com.annamakos.socialcare.api.model.User;
import com.annamakos.socialcare.api.repository.InstitutionRepository;
import com.annamakos.socialcare.api.repository.RoleRepository;
import com.annamakos.socialcare.api.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    UserRepository userRepository;
    RoleRepository roleRepository;
    InstitutionRepository institutionRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, InstitutionRepository institutionRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.institutionRepository = institutionRepository;
    }

    public User alterUserToOfficial(String username) {

        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));
        if (user != null) {
            Set<Role> userRoles;
            userRoles = user.getRoles();
            Role role = roleRepository.findByName(RoleName.ROLE_OFFICIAL).orElseThrow(() ->
                    new RuntimeException("Role not found"));
            if (role != null) {
                userRoles.add(role);
                user.setRoles(userRoles);
                userRepository.save(user);
            }
        }
        return user;
    }

    public User alterInstitutionForOfficial(String username, String institutionName) {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));

        if (user != null) {
            user.setInstitution(institutionRepository.findByName(institutionName).orElseThrow(() ->
                    new RuntimeException("Institution not found")));
            userRepository.save(user);
        }
        return user;
    }

    public List<User> showUsers() {
        List<User> list = new ArrayList<>();
        list = this.userRepository.findAll();
        return list;
    }

    public Set<User> findUsersByInstitution(int id) {
        Set<User> users = new HashSet<>();

        userRepository.findAllByInstitutionId(id).forEach(user -> {
            if (user.isPresent()) {
                users.add(user.orElseThrow(() -> new UsernameNotFoundException("User not found")));
            }
        });
        return users;
    }
}
