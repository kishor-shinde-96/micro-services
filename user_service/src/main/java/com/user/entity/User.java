package com.user.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long userId;
    private String name;
    private String phone;

    List<Contact> contacts = new ArrayList<>();

    public User(Long userId, String name, String phone) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
    }
}
