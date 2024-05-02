package com.ms.user.service;

import com.ms.user.entity.User;
import com.ms.user.producer.UserProducer;
import com.ms.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSevice {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProducer userProducer;

    @Transactional
    public User saveUser(User username) {
        username = userRepository.save(username);
        userProducer.publishMessageEmail(username);
        return username;
    }
}
