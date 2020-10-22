package com.expertcloud.learningcity.model.dto.user;

import com.expertcloud.learningcity.model.entity.User;
import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    private String name;
    private String username;

    public UserResponse(User u) {
        this.id = u.getId();
        this.name = u.getName();
        this.username = u.getUsername();
    }
}
