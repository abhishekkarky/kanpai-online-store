package com.system.kanpaionlinestore.service.impl;

import com.system.kanpaionlinestore.entity.Notifications;
import com.system.kanpaionlinestore.entity.Product;
import com.system.kanpaionlinestore.pojo.NotificationsPojo;
import com.system.kanpaionlinestore.repo.NotificationsRepo;
import com.system.kanpaionlinestore.service.NotificationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationsService {
    private final NotificationsRepo notificationsRepo;

    @Override
    public String save(NotificationsPojo notificationsPojo) {
        Notifications notifications = new Notifications();
        if(notifications.getId()!=null){
            notifications.setId(notificationsPojo.getId());
        }
        notifications.setTopic(notificationsPojo.getTopic());
        notifications.setDescription(notificationsPojo.getDescription());
        notificationsRepo.save(notifications);
        return "created";
    }

    @Override
    public List<Notifications> fetchAll() {
        return this.notificationsRepo.findAll();
    }
}
