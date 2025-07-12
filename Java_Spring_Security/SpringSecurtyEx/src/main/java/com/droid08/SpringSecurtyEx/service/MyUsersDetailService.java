package com.droid08.SpringSecurtyEx.service;

import com.droid08.SpringSecurtyEx.entity.Users;
import com.droid08.SpringSecurtyEx.entity.UsersPrincipal;
import com.droid08.SpringSecurtyEx.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUsersDetailService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByUsername(username);

        if(user == null){
            System.out.println("----Users not found----");
        }
        return new UsersPrincipal(user);
    }
}
