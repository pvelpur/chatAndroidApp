package com.example.chatapp;

public class UserObject {

    private  String name,
                    phonenum;

    public UserObject(String name, String phonenum){
        this.name = name;
        this.phonenum = phonenum;
    }

    public String getName(){
        return name;
    }


    public String getPhonenum() {
        return phonenum;
    }
}
