package com.system.kanpaionlinestore.service;

import com.system.kanpaionlinestore.entity.Product;
import com.system.kanpaionlinestore.entity.User;
import com.system.kanpaionlinestore.pojo.UserPojo;

import java.util.List;

public interface UserService {
    String save(UserPojo userPojo);
    UserPojo findByEmail(String email);
    void sendEmail();
    String update(UserPojo userPojo);

    void processPasswordResetRequest(String email);

    void resetPassword(String email, String OTP, String password);

    List<User> fetchAll();

    void deleteById(Integer id);

    Product fetchById(Integer id);
}
