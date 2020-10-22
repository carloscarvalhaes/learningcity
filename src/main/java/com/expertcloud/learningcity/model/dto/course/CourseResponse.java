package com.expertcloud.learningcity.model.dto.course;

import com.expertcloud.learningcity.model.entity.Course;
import lombok.Data;

@Data
public class CourseResponse {

    private Long id;
    private String name;
    private String description;

    public CourseResponse(Course course){
        this.id = course.getId();
        this.name = course.getName();
        this.description = course.getDescription();
    }

}
