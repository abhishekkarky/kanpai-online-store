package com.system.kanpaionlinestore.service.impl;

import com.system.kanpaionlinestore.config.PasswordEncoderUtil;
import com.system.kanpaionlinestore.entity.User;
import com.system.kanpaionlinestore.exception.AppException;
import com.system.kanpaionlinestore.pojo.UserPojo;
import com.system.kanpaionlinestore.repo.UserRepo;
import com.system.kanpaionlinestore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    public final UserRepo userRepo;
    @Override
    public String save(UserPojo userPojo) {
        User user=new User();
        user.setFName(userPojo.getFName());
        user.setLName(user.getLName());
        user.setEmail(userPojo.getEmail());
        user.setPassword(PasswordEncoderUtil.getInstance().encode(userPojo.getPassword()));
        userRepo.save(user);
        return "created";
    }
    @Override
    public UserPojo findByEmail(String email) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new AppException("Invalid User email", HttpStatus.BAD_REQUEST));
        return new UserPojo(user);
    }
}
