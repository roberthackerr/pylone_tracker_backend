package com.example.demo.service;

import java.sql.Date;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Notification;
import com.example.demo.model.NotificationDTO;
import com.example.demo.repo.NotificationRepository;
import com.example.demo.repo.UserRepository;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepo;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService sv;

    public List<NotificationDTO> getAllByUser(Long userId) {
        return notificationRepo.findByUserIdOrderByTimeDesc(userId)
                .stream().map(NotificationDTO::new).toList();
    }

    public NotificationDTO markAsRead(Long id) {
        Notification notif = notificationRepo.findById(id).orElseThrow();
        notif.setReadn((byte)1);
        return new NotificationDTO(notificationRepo.save(notif));
    }

    public void deleteNotification(Long id) {
        notificationRepo.deleteById(id);
    }

    @SuppressWarnings("deprecation")
    public NotificationDTO createNotification(NotificationDTO dto) {
        Notification notif = new Notification();
        notif.setTitle(dto.getTitle());
        notif.setMessage(dto.getMessage());
        notif.setAvatar(sv.getById(dto.getDestId()).getAvatar());
        notif.setUser(userRepository.getById( dto.getUserId()) );
        notif.setTime(Date.from(java.time.LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        notif.setReadn(Byte.parseByte("0")); // default as unread
    
        Notification saved = notificationRepo.save(notif);
        return new NotificationDTO(saved);
    }
    
}

