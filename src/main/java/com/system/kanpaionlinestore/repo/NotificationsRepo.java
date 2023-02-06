package com.system.kanpaionlinestore.repo;

import com.system.kanpaionlinestore.entity.Notifications;
import com.system.kanpaionlinestore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotificationsRepo extends JpaRepository<Notifications, Integer> {
}
