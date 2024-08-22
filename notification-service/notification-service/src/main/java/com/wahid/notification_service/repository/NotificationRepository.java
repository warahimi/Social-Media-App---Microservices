package com.wahid.notification_service.repository;

import com.wahid.notification_service.entity.Notification;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class NotificationRepository {
    private List<Notification> notifications;

    public NotificationRepository()
    {
        this.notifications = new ArrayList<>();

        notifications.add(new Notification("1N","1","Notification 1N"));
        notifications.add(new Notification("2N","2","Notification 2N"));
        notifications.add(new Notification("3N","1","Notification 3N"));
        notifications.add(new Notification("4N","1","Notification 4N"));
        notifications.add(new Notification("5N","3","Notification 5N"));
        notifications.add(new Notification("6N","4","Notification 6N"));
        notifications.add(new Notification("7N","2","Notification 7N"));
        notifications.add(new Notification("8N","1","Notification 8N"));
        notifications.add(new Notification("9N","4","Notification 9N"));
        notifications.add(new Notification("10N","2","Notification 10N"));
        notifications.add(new Notification("11N","3","Notification 11N"));
    }

    public List<Notification> getAllNotifications()
    {
        return this.notifications;
    }
    public Notification getNotificationById(String notificationId)
    {
        return notifications.stream()
                .filter(n -> n.getNotificationId().equals(notificationId))
                .findFirst()
                .orElse(null);
    }
    public List<Notification> getNotificationByUserId(String userId)
    {
        List<Notification> result = notifications.stream()
                .filter(notification -> notification.getUserId().equals(userId))
                .collect(Collectors.toList());

        return result;
    }

}
