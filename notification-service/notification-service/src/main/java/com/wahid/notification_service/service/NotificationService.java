package com.wahid.notification_service.service;

import com.wahid.notification_service.entity.Notification;
import com.wahid.notification_service.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    private NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public List<Notification> getAllNotifications()
    {
        return repository.getAllNotifications();
    }

    public Notification getNotificationById(String notificationId)
    {
        return repository.getNotificationById(notificationId);
    }
    public List<Notification> getNotificationByUserId(String userId)
    {
        return repository.getNotificationByUserId(userId);
    }

}
