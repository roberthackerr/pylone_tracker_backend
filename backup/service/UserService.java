package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.UserAlreadyExist;
import com.example.demo.entity.User;
import com.example.demo.repository.crudRepo;

@Service
public class UserService {
@Autowired
private crudRepo repo;
//verifier un email existence
public User addNewUser(User user) throws UserAlreadyExist{
    if (repo.existsByEmail(user.getEmail())){
        throw new UserAlreadyExist("user already exist.////////////////");
    }
return repo.save(user);
}
public boolean sendmail(String email){
return false;
}
public void removeUser(Integer id){
    repo.deleteById(id);
}
public void updateUser(User user){
    repo.save(user);
}
}
