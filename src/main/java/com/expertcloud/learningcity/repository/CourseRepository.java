package com.expertcloud.learningcity.repository;

import com.expertcloud.learningcity.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
