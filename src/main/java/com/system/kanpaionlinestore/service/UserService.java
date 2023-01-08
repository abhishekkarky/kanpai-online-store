package com.system.kanpaionlinestore.service;

import com.system.kanpaionlinestore.pojo.UserPojo;

public interface UserService {
    String save(UserPojo userPojo);
    UserPojo findByEmail(String email);
    UserPojo findByPassword(String password);
}
