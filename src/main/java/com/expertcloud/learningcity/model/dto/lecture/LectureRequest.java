package com.expertcloud.learningcity.model.dto.lecture;

import lombok.Data;

@Data
public class LectureRequest {

    private String name;
    private String description;
    private Long courseId;

}
