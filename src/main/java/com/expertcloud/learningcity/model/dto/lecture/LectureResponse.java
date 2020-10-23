package com.expertcloud.learningcity.model.dto.lecture;

import com.expertcloud.learningcity.model.dto.course.CourseResponse;
import lombok.Data;

@Data
public class LectureResponse {

    private Long id;
    private String name;
    private String description;
    private String duration;
    private CourseResponse course;
}
