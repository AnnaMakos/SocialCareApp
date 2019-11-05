package com.annamakos.socialcare.security.message.request;

import lombok.Data;

@Data
public class Login {
    private String username;
    private String password;
}
