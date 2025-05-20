package com.example.demo.service;

import java.lang.StackWalker.Option;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Role;
import com.example.demo.model.Token;
import com.example.demo.model.User;
import com.example.demo.model.UserDTO;

@Service
public class AuthService {

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private com.example.demo.repo.AuthRepo repo;

    @Autowired
    private com.example.demo.repo.RoleRepo roleRepo;


    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public ResponseEntity<?> register(User user) {
        user.setUsername(user.getEmail());
        user.setPassword(encoder.encode(user.getPassword()));
        if(!this.isExistUser(user)){
            Map<String, Object> response = new HashMap<>();
            user.setTokens(java.util.List.of(new Token(jwtService.generateToken(user.getUsername()))));
            response.put("message", "success");
            response.put("user",new UserDTO(repo.save(user)));
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("message", "exist"));
    }

    private boolean isExistUser(User user) {
        if(repo.existsByUsername(user.getUsername())){
            return true;
        }
       return false;
    }

    public Object verify(User user) {
        System.out.println(user.getEmail()+user.getPassword());
        user.setUsername(user.getEmail());
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            System.out.println("notleeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee//////////////////////////////////////////////////////////////////////////////////////"); 
            return new Token(jwtService.generateToken(user.getUsername()));
        } else {
            System.out.println("not");
            return "fail";
        }
    }

    public Boolean validate(String token) {
        try {
            String username = jwtService.extractUserName(token);
    
            if (username != null && !username.isEmpty()) {
                return true;
            }
    
        } catch (Exception e) {
            // Log or handle invalid/expired token
            System.out.println("Token validation failed: " + e.getMessage());
        }
    
        return false;
    }

    public ResponseEntity<?> getUser(String token) {
        // TODO Auto-generated method stub
       try {
        String username=jwtService.extractUserName(token);
        if(!username.equals(null) && repo.findByUsername(username)!=null){
            return  ResponseEntity.status(HttpStatus.OK).body(repo.findByUsername(username));

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       } catch (Exception e) {
        // TODO: handle exception
       }
       return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
}
