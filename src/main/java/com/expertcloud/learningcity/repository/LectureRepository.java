package com.expertcloud.learningcity.repository;

import com.expertcloud.learningcity.model.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
}
