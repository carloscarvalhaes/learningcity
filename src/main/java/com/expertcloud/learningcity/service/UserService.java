package com.expertcloud.learningcity.service;

import com.expertcloud.learningcity.model.User;
import com.expertcloud.learningcity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUser(Long userId){
        return userRepository.findById(userId).orElse(null);
    }

}
