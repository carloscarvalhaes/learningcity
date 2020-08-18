package com.expertcloud.learningcity.repository;

import com.expertcloud.learningcity.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
}
