package com.example.demo.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;
@Repository
public interface crudRepo extends CrudRepository<User,Integer>{
    void deleteUserById(Integer id);
    User findByEmail(String email);
    void deleteUserByName(String name);
   // Optional<User> findUserByEmail(String email);

   boolean existsByName(String username);
   
   // Check if a user exists by email
   boolean existsByEmail(String email);
}

    
    // Check if a user exists by username
