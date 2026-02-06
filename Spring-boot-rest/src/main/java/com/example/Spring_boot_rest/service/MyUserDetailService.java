package com.example.Spring_boot_rest.service;


import com.example.Spring_boot_rest.Repo.UserRepo;
import com.example.Spring_boot_rest.model.User;
import com.example.Spring_boot_rest.model.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.sound.midi.Soundbank;


@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repo.findByusername(username);

                if(user == null){
                    System.out.println("user not found");
                    throw new UsernameNotFoundException("User not found");
                }

        return new UserPrinciple(user);
    }
}
