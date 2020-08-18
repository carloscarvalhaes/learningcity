package com.expertcloud.learningcity.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long idCourse;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String duration;

    @Column
    private String streamVideo;

}
