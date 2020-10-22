package com.expertcloud.learningcity.model.entity;

import com.expertcloud.learningcity.model.dto.user.UserRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "system_user")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String username;
    private String email;
    private String password;

    public User (UserRequest request){
        this.name = request.getName();
        this.email = request.getEmail();
        this.username = request.getUsername();
        this.password = request.getPassword();
    }

}
