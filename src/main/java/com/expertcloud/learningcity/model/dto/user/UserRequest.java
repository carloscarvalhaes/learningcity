package com.expertcloud.learningcity.model.dto.user;

import lombok.Data;

@Data
public class UserRequest {

    private String name;
    private String username;
    private String email;
    private String password;

}
