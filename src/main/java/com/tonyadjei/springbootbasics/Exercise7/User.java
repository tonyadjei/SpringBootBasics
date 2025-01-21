package com.tonyadjei.springbootbasics.Exercise7;


import lombok.*;

@Getter
@Setter
@ToString
public class User {
    private String name;
    private String email;
    private int id;
    private static int nextIDCount = 1;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.id = nextIDCount++;
    }
}
