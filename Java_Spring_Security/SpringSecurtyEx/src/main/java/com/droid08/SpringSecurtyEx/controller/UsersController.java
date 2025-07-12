package com.droid08.SpringSecurtyEx.controller;

import com.droid08.SpringSecurtyEx.entity.Users;
import com.droid08.SpringSecurtyEx.service.UsersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    protected UsersService usersService;

    public UsersController(UsersService usersService){
        this.usersService = usersService;
    }

    @GetMapping("/users")
    public List<Users> getAllUsers(){
        return usersService.getAllUsers();
    }

    @PostMapping("/register")
    public Users registerUser(@RequestBody Users user){
        return usersService.register(user);
    }
}
