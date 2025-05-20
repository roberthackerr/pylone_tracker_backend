package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.UserAlreadyExist;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.RoleDAO;
import com.example.demo.service.JWTService;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import com.mysql.fabric.Response;

@RestController
@RequestMapping("/api/auth")
public class UserController {
@Autowired
private UserService serv;
@Autowired
private RoleDAO rold;
@Autowired
private JWTService JWt;

@PostMapping("/register")
public ResponseEntity<?> saveUser(@RequestBody User save){
    try {
        User user=serv.addNewUser(save);
        System.out.println(JWt.generateToken("djdjdjdjdjdjdjdj"));
        //serv.check.mail(user.getEmail());
        return ResponseEntity.ok(user);
    } catch (UserAlreadyExist e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An error occurred"+e.getMessage());
    }
    catch(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred"+e.getMessage());   
    }
   
}


@DeleteMapping("/api/{id}")
public String deleteUser(@PathVariable("id") Integer id){
    serv.removeUser(id);
return "okkkk";
}
@PostMapping("/login")
public String login(){
return "sucesssszss";
}
@PostMapping("/logina")
public String logina(){
return "sucesssszss";
}

@PutMapping("/api/")
public String deleteUser(@RequestBody User save){
    serv.updateUser(save);;
return "okkkk";
}
}

