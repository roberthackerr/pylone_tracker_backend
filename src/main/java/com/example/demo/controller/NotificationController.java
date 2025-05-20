package com.example.demo.controller;

import com.example.demo.model.NotificationDTO;
import com.example.demo.service.NotificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin(origins = "*") // optional: for allowing frontend access
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // 1. Get all notifications for a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<NotificationDTO>> getNotificationsByUser(@PathVariable Long userId) {
        List<NotificationDTO> notifications = notificationService.getAllByUser(userId);
        return ResponseEntity.ok(notifications);
    }

    // 2. Mark a notification as read
    @PutMapping("/{id}/read")
    public ResponseEntity<NotificationDTO> markAsRead(@PathVariable Long id) {
        NotificationDTO updated = notificationService.markAsRead(id);
        return ResponseEntity.ok(updated);
    }

    // 3. Delete a notification
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping
public ResponseEntity<NotificationDTO> createNotification(@RequestBody NotificationDTO dto) {
    NotificationDTO saved = notificationService.createNotification(dto);
    return ResponseEntity.ok(saved);
}
}
