package com.example.myanimelibrary.domain;

public class User {

    private String id;
    private String login;
    private String password;
    private String pseudo;

    public User(String id, String login, String password, String pseudo) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.pseudo = pseudo;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getId() {
        return id;
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
}
