package com.annamakos.socialcare.security.message.request;

import lombok.Data;

import java.util.Set;

@Data
public class Signup {
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    private Set<String> roles;
}
