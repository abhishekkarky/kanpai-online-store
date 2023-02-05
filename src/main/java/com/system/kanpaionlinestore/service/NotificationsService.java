package com.system.kanpaionlinestore.service;

import com.system.kanpaionlinestore.entity.Notifications;
import com.system.kanpaionlinestore.entity.Product;
import com.system.kanpaionlinestore.pojo.NotificationsPojo;

import java.io.IOException;
import java.util.List;

public interface NotificationsService {
    String save(NotificationsPojo notificationsPojo);
    List<Notifications> fetchAll();
}
