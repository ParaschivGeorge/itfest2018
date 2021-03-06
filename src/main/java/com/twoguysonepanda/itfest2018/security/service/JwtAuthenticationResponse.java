package com.twoguysonepanda.itfest2018.security.service;

import com.twoguysonepanda.itfest2018.entities.User;

import java.io.Serializable;

public class JwtAuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;

    private final User user;

    public JwtAuthenticationResponse(String token, User user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return this.token;
    }

    public User getUser() {
        return user;
    }
}
