package com.example.demo.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getByIdOrEmail(Integer id,String email) {
        return userRepository.findByIdOrEmail(id,email).orElseThrow();
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(Integer id, User updatedUser) {
        User user = getById(id);
        updatedUser.setUsername(updatedUser.getEmail());
        System.out.println(id);
        BeanUtils.copyProperties(updatedUser, user, "id","password","tokens","avatar");
        return userRepository.save(user);
    }

    public User getById(Integer id) {
        // TODO Auto-generated method stub
        return userRepository.findById(id).orElseThrow();
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
