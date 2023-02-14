package com.system.kanpaionlinestore.service;

import com.system.kanpaionlinestore.pojo.UserPojo;

public interface UserService {
    String save(UserPojo userPojo);
    UserPojo findByEmail(String email);
    void sendEmail();
    String update(UserPojo userPojo);

    void processPasswordResetRequest(String email);

    void resetPassword(String email, String OTP, String password);

}
