package com.expertcloud.learningcity.service;

import com.expertcloud.learningcity.exception.NotFoundException;
import com.expertcloud.learningcity.model.dto.course.CourseRequest;
import com.expertcloud.learningcity.model.dto.course.CourseResponse;
import com.expertcloud.learningcity.model.entity.Course;
import com.expertcloud.learningcity.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.expertcloud.learningcity.util.GenericMessages.UNABLE_TO_FIND_COUSE;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseResponse getCourseRequest(Long courseId) {
        Optional<Course> byId = courseRepository.findById(courseId);
        if (byId.isEmpty()) {
            log.error(UNABLE_TO_FIND_COUSE);
            throw new NotFoundException(UNABLE_TO_FIND_COUSE);
        }
        return new CourseResponse(byId.get());
    }

    protected Course getCourse(Long courseId) {
        Optional<Course> byId = courseRepository.findById(courseId);
        if (byId.isEmpty()) {
            log.error(UNABLE_TO_FIND_COUSE);
            throw new NotFoundException(UNABLE_TO_FIND_COUSE);
        }
        return byId.get();
    }

    public CourseResponse saveCourse(CourseRequest request) {
        Course course = new Course(request);
        course = courseRepository.save(course);
        return new CourseResponse(course);
    }

    public List<CourseResponse> findAllCourses() {
        return courseRepository.findAll().stream().map(CourseResponse::new).collect(Collectors.toList());
    }

    public void removeCourse(Long courseId) {
        try {
            courseRepository.deleteById(courseId);
        } catch (RuntimeException e) {
            log.error("Unable to remove course");
        }
    }

}
