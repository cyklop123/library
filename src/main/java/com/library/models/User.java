package com.library.models;

import com.library.enums.Role;

public class User {
    protected String login;
    protected String pass;
    final protected Role role;

    public User(String login, String pass, Role role) {
        this.login = login;
        this.pass = pass;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", role=" + role +
                '}';
    }

    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
        this.role = Role.USER;
    }
}
