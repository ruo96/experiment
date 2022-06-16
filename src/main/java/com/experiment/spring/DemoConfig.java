package com.experiment.spring;

import com.experiment.spring.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wuruohong
 * @date 2022-06-16 0:09
 */
@Configuration
public class DemoConfig {

    @Bean
    public User user() {
        User user = new User();
        user.setName("w1");
        return user;
    }
}
