package com.expertcloud.learningcity.model.entity;

import com.expertcloud.learningcity.model.dto.course.CourseRequest;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String folderImage;

    @OneToMany(mappedBy = "course")
    private List<Lecture> lectures;

    public Course (CourseRequest request){
        this.name = request.getName();
        this.description = request.getDescription();
    }

}
