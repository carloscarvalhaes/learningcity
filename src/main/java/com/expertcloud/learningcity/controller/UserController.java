package com.expertcloud.learningcity.controller;

import com.expertcloud.learningcity.model.dto.user.UserRequest;
import com.expertcloud.learningcity.model.dto.user.UserResponse;
import com.expertcloud.learningcity.service.UserService;
import com.expertcloud.learningcity.util.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long userId){

        Validator.idNotNull(userId);

        UserResponse user = userService.getUser(userId);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAllUsers(){

        List<UserResponse> allUsers = userService.findAllUsers();
        return ResponseEntity.ok().body(allUsers);
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request){

        Validator.requestNotNull(request);

        UserResponse userResponse = userService.saveUser(request);
        return ResponseEntity.created(null).body(userResponse);
    }




}
