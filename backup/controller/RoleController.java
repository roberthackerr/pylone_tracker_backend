package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;

@RestController
public class RoleController {
@Autowired
private RoleService roleServices;
@PostMapping("/creatnewrole")
public Role createNewRole(@RequestBody Role role){
    System.out.println("ouiii");
    Role rl=roleServices.createNewRol(role);
    return rl;
}
}
