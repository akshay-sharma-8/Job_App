package com.example.Spring_boot_rest.Repo;


import com.example.Spring_boot_rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo  extends JpaRepository<User,Integer> {


    User findByusername(String user);
    User save(User user);

}
