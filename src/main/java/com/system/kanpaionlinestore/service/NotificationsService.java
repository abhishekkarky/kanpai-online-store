package com.system.kanpaionlinestore.service;

import com.system.kanpaionlinestore.entity.Notifications;
import com.system.kanpaionlinestore.pojo.NotificationsPojo;
import com.system.kanpaionlinestore.pojo.UserPojo;

import java.util.List;

public interface NotificationsService {
    String save(NotificationsPojo notificationsPojo);
    List<Notifications> fetchAll();
    Notifications fetchById(Integer id);

    void deleteById(Integer id);
}
