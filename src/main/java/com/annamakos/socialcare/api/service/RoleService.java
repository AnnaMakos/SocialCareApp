package com.annamakos.socialcare.api.service;

import com.annamakos.socialcare.api.model.Role;
import com.annamakos.socialcare.api.model.RoleName;
import com.annamakos.socialcare.api.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class RoleService {
    RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findRoleByName(RoleName name) {
        Role role = roleRepository.findByName(name).orElseThrow(
                () -> new NoSuchElementException("Role not found"));
        return role;
    }

    public RoleName findRoleNameByName(String name) {
        RoleName roleName = null;
        switch (name) {
            case "ROLE_USER":
                roleName = RoleName.ROLE_USER;
                break;
            case "ROLE_ADMIN":
                roleName = RoleName.ROLE_ADMIN;
                break;
            case "ROLE_OFFICIAL":
                roleName = RoleName.ROLE_OFFICIAL;
                break;
        }
        return roleName;
    }

}
