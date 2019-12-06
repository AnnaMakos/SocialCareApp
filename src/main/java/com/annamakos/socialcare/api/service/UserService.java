package com.annamakos.socialcare.api.service;

import com.annamakos.socialcare.api.dto.UserBasicDTO;
import com.annamakos.socialcare.api.dto.UserDTO;
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
    RoleService roleService;
    InstitutionService institutionService;

    public UserService(UserRepository userRepository, RoleService roleService, InstitutionService institutionService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.institutionService = institutionService;
    }


    public UserDTO alterUserRole(String username, String name) {
        User user = findByUsername(username);
        RoleName roleName = roleService.findRoleNameByName(name);
        Role role = roleService.findRoleByName(roleName);
        Set<Role> userRoles = user.getRoles();
        userRoles.add(role);
        user.setRoles(userRoles);
        userRepository.save(user);
        UserDTO userDTO = new UserDTO(user);
        return userDTO;
    }

    public UserDTO alterUserInstitution(String username, int institutionId) {
        User user = findByUsername(username);
        user.getRoles().forEach(role -> {
           if(role.getName().equals(RoleName.ROLE_OFFICIAL)){
               user.setInstitution(institutionService.findInstitutionById(institutionId));
               userRepository.save(user);
           }
        });
        UserDTO userDTO = new UserDTO(user);
        return userDTO;
    }

    public List<UserDTO> findAllUsers() {
        List<User> list = this.userRepository.findAll();
        List<UserDTO> usersDTO = new ArrayList<>();
        list.forEach(user -> {
            usersDTO.add(new UserDTO(user));
        });
        return usersDTO;
    }

    public List<UserDTO> findUsersByInstitution(int id) {
        List<UserDTO> users = new ArrayList<>();

        userRepository.findAllByInstitutionId(id).forEach(user -> {
            users.add(new UserDTO(user));
        });
        return users;
    }

    public List<UserBasicDTO> findOfficialsByInstitution(int id) {
        List<UserBasicDTO> users = new ArrayList<>();

        userRepository.findAllByInstitutionId(id).forEach(user -> {
            users.add(new UserBasicDTO(user));
        });
        return users;
    }

    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));
        return user;
    }

    public List<UserDTO> findByRole(String name) {
        RoleName roleName = roleService.findRoleNameByName(name);
        List<User> users = userRepository.findAllByRolesName(roleName);
        List<UserDTO> usersDTO = new ArrayList<>();
        users.forEach(user -> {
            usersDTO.add(new UserDTO(user));
        });

        return usersDTO;
    }

    public List<UserBasicDTO> findOfficials() {
        RoleName roleName = roleService.findRoleNameByName("ROLE_OFFICIAL");
        List<User> users = userRepository.findAllByRolesName(roleName);
        List<UserBasicDTO> usersBasicDTO = new ArrayList<>();
        users.forEach(user -> {
            usersBasicDTO.add(new UserBasicDTO(user));
        });

        return usersBasicDTO;
    }
}
