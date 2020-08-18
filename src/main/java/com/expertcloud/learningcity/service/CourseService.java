package com.expertcloud.learningcity.service;

import com.expertcloud.learningcity.model.Course;
import com.expertcloud.learningcity.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public Course getCourse(Long courseId){
        return courseRepository.findById(courseId).orElse(null);
    }

}
