package com.expertcloud.learningcity.service;

import com.expertcloud.learningcity.exception.NotFoundException;
import com.expertcloud.learningcity.model.dto.user.UserRequest;
import com.expertcloud.learningcity.model.dto.user.UserResponse;
import com.expertcloud.learningcity.model.entity.User;
import com.expertcloud.learningcity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse getUser(Long userId){
        Optional<User> byId = userRepository.findById(userId);
        if (byId.isEmpty()){
            log.error("Unable to find user");
            throw new NotFoundException("Unable to find user");
        }
        return new UserResponse(byId.get());
    }

    public UserResponse saveUser(UserRequest request){

        User user = new User(request);
        user = userRepository.save(user);
        return new UserResponse(user);
    }

    public List<UserResponse> findAllUsers(){
        return userRepository.findAll().stream().map(UserResponse::new).collect(Collectors.toList());
    }

}
