package com.droid08.SpringSecurtyEx.service;

import com.droid08.SpringSecurtyEx.entity.Users;
import com.droid08.SpringSecurtyEx.repository.UsersRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    protected UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public List<Users> getAllUsers(){
        List<Users> users = new ArrayList<>();
        users = usersRepository.findAll();
        return users;
    }

    public Users register(Users user){
        user.setPassword(encoder.encode(user.getPassword())); // encode password and save in db
        return usersRepository.save(user);
    }
}
