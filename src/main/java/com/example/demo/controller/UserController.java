package com.example.demo.controller;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

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
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.User;
import com.example.demo.model.UserDTO;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.UserService;

import io.jsonwebtoken.io.IOException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<User> users = userService.getAll();
       
        List<UserDTO> dtos = users.stream()
                                  .map(UserDTO::new)
                                  .collect(Collectors.toList());
         if (!dtos.equals(null)) {
            return ResponseEntity.ok(dtos); // 204 No Content
        }
        return ResponseEntity.noContent().build();
        
    }
    @PostMapping("/upload-avatar/{id}")
    public ResponseEntity<Map<String, String>> uploadAvatar(
            @RequestParam("avatar") MultipartFile file,
            @RequestParam("id") Integer userId
            ) throws IOException {
    
        // Optional: validate file type & size
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "No file uploaded"));
        }
    
        // Example: save to disk (or convert to Base64 for DB)
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path path = Paths.get("uploads/avatars/" + fileName);
        try {
            Files.write(path, file.getBytes());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
       
        System.out.println("okkkkkkkkkkkk");
        // Save URL or path to DB
        User user = userRepository.findById(userId).orElseThrow();
        user.setAvatar("/uploads/avatars/" + fileName);
        userRepository.save(user);
    
        return ResponseEntity.ok(Map.of("avatarUrl", user.getAvatar()));
    }
    
    @GetMapping("/get")
    public ResponseEntity<?> getById(@RequestParam(required = false) Integer id, @RequestParam(required = false) String email) {
        return ResponseEntity.ok(new UserDTO(userService.getByIdOrEmail(id, email)));
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        User createdUser = userService.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User user) {
        System.out.println(id);
        User updatedUser = userService.update(id, user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
