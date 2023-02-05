package com.system.kanpaionlinestore.config;

import com.system.kanpaionlinestore.pojo.UserPojo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public UserPojo userPojo() {
        return new UserPojo();
    }
}
