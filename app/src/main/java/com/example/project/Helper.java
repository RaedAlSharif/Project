package com.example.project;

public class Helper {


    String password;
    String username;
    int score;

    public Helper(){

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Helper(String username , String password , int score) {

        this.password = password;
        this.username = username;
        this.score = score;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }




    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }


}