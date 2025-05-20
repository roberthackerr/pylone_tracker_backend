package com.example.demo.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class NotificationDTO {
    private Integer destId;
    private Integer userId;
    private Long id;
    private String title;
    private String message;
    private String avatar;
    private Byte read;
    private Date time;

    public NotificationDTO(Notification notif) {
        this.id = notif.getId();
        this.title = notif.getTitle();
        this.message = notif.getMessage();
        this.avatar = notif.getAvatar();
        this.read = notif.getReadn();
        this.time = notif.getTime();
        this.userId=notif.getUser().getId();
    }

    // Getters and Setters
}

