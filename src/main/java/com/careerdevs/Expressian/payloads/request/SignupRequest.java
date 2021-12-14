package com.careerdevs.Expressian.payloads.request;

import java.util.Set;

public class SignupRequest {
    private String username;
    private String password;
    private Set<String> roles;

    public SignupRequest(Set<String> roles, String username, String password) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
