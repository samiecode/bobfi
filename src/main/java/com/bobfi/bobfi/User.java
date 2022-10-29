package com.bobfi.bobfi;

public class User {
    private int ID;
    private String username;
    private String password;
    private String email;

    public User(int id, String username, String email, String password){
        this.ID = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getID() {
        return ID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
