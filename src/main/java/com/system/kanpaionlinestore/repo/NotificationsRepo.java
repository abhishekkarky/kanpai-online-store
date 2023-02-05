package com.system.kanpaionlinestore.repo;

import com.system.kanpaionlinestore.entity.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationsRepo extends JpaRepository<Notifications, Integer> {
}
