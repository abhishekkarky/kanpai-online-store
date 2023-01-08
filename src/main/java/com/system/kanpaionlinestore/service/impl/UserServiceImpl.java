package com.system.kanpaionlinestore.service.impl;

import com.system.kanpaionlinestore.entity.User;
import com.system.kanpaionlinestore.pojo.UserPojo;
import com.system.kanpaionlinestore.repo.UserRepo;
import com.system.kanpaionlinestore.service.UserService;
import lombok.RequiredArgsConstructor;
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
        user.setPassword(userPojo.getPassword());
        userRepo.save(user);
        return "created";
    }
    @Override
    public UserPojo findByEmail(String email) {
        User user = (User) userRepo.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("Invalid User email"));
        return new UserPojo(user);
    }

    @Override
    public UserPojo findByPassword(String password) {
        User user = (User) userRepo.findByPassword(password)
                .orElseThrow(() -> new RuntimeException("Invalid User password"));
        return new UserPojo(user);
    }
}
