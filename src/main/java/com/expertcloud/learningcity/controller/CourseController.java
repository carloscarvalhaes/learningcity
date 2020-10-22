package com.expertcloud.learningcity.controller;

import com.expertcloud.learningcity.model.dto.course.CourseRequest;
import com.expertcloud.learningcity.model.dto.course.CourseResponse;
import com.expertcloud.learningcity.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseResponse> getCourse(@PathVariable Long courseId){
        Assert.notNull(courseId, "Id cannot be null");
        CourseResponse course = courseService.getCourse(courseId);
        return ResponseEntity.ok().body(course);
    }

    @GetMapping
    public ResponseEntity<List<CourseResponse>> findAllCourses(){
        List<CourseResponse> allCourses = courseService.findAllCourses();
        return ResponseEntity.ok().body(allCourses);
    }

    @PostMapping
    public ResponseEntity<CourseResponse> createCourse(@RequestBody CourseRequest request){

        Assert.notNull(request, "Request cannot be null");

        CourseResponse courseResponse = courseService.saveCourse(request);
        return ResponseEntity.created(null).body(courseResponse);

    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<HttpStatus> removeCourse(@PathVariable Long courseId){

        Assert.notNull(courseId, "Id cannot be null");

        courseService.removeCourse(courseId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}