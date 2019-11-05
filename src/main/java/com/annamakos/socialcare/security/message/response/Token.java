package com.annamakos.socialcare.security.message.response;

import lombok.Data;

@Data
public class Token {
    private String token;
    private String type = "Bearer";

    public Token(String accessToken){
        this.token = accessToken;
    }
}
