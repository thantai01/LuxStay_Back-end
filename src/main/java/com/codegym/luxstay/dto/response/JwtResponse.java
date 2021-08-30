package com.codegym.luxstay.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter @Setter
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String name;
    private Collection<?extends GrantedAuthority> roles;

    public JwtResponse() {
    }
    public JwtResponse(String token, String name, Collection<? extends GrantedAuthority> roles) {
        this.token = token;
        this.name = name;
        this.roles = roles;
    }
}
