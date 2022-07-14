package com.example.myanimelibrary.infrastructure.request;

public class UserRequest {

    private String login;
    private String password;
    private String pseudo;

    public UserRequest(String login, String password, String pseudo) {
        this.login = login;
        this.password = password;
        this.pseudo = pseudo;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
}
