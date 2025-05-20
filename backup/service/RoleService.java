package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Role;
import com.example.demo.repository.RoleDAO;
@Service
public class RoleService {
    @Autowired
    private RoleDAO roleDAOs;
public Role createNewRol(Role role){
    return roleDAOs.save(role);
}
}
