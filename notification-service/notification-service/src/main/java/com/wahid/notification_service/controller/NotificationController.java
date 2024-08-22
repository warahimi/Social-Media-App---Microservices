package com.wahid.notification_service.controller;

import com.wahid.notification_service.entity.Notification;
import com.wahid.notification_service.service.NotificationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {
    private NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @GetMapping
    public List<Notification> getAllNotification()
    {
        return service.getAllNotifications();
    }

    @GetMapping("/{notificationId}")
    public Notification getNotificationById(@PathVariable String notificationId)
    {
        return service.getNotificationById(notificationId);
    }
    @GetMapping("/user/{userId}")
    public List<Notification> getNotificationByUserId(@PathVariable String userId)
    {
        return service.getNotificationByUserId(userId);
    }
}
