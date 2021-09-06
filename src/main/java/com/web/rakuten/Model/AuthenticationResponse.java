package com.web.rakuten.Model;

public class AuthenticationResponse {
    public final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJWT(){
        return jwt;
    }

    
}
