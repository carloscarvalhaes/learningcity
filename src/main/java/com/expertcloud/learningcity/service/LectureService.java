package com.expertcloud.learningcity.service;

import com.expertcloud.learningcity.model.entity.Lecture;
import com.expertcloud.learningcity.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;

    public Lecture getLecture(Long lectureId){
        return lectureRepository.findById(lectureId).orElse(null);
    }

}
