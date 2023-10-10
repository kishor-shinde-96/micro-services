package com.user.controller;

import com.user.entity.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    private final RestTemplate restTemplate;

    @Autowired
    public UserController(UserService userService, RestTemplate restTemplate) {
        this.userService = userService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long userId){
      User user=  this.userService.getUser(userId);
        List contact =this.restTemplate.getForObject("http://contact-service/contact/user/"+user.getUserId(), List.class);
        user.setContacts(contact);
        return user;
    }
}
