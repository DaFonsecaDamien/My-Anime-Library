package com.example.myanimelibrary.infrastructure.request;

public class UserRequest {

    private String username;
    private String password;
    private String pseudo;

    public UserRequest(String username, String password, String pseudo) {
        this.username = username;
        this.password = password;
        this.pseudo = pseudo;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
}
