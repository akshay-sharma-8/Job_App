package com.example.Spring_boot_rest.service;


import com.example.Spring_boot_rest.Repo.UserRepo;
import com.example.Spring_boot_rest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Register {

    @Autowired
    private UserRepo repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User  SaveUser(User user){

        user.setPassword(encoder.encode(user.getPassword()));

        return repo.save(user);

    }



}
