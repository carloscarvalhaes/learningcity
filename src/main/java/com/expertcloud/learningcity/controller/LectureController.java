package com.expertcloud.learningcity.controller;

import com.expertcloud.learningcity.model.dto.lecture.LectureRequest;
import com.expertcloud.learningcity.model.dto.lecture.LectureResponse;
import com.expertcloud.learningcity.service.LectureService;
import com.expertcloud.learningcity.util.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/lecture")
public class LectureController {

    private final LectureService lectureService;

    @GetMapping("/{lectureId}")
    public ResponseEntity<LectureResponse> getLecture(@PathVariable Long lectureId){

        Validator.idNotNull(lectureId);

        LectureResponse lecture = lectureService.getLecture(lectureId);
        log.info("Get lecture: {}", lecture);
        return ResponseEntity.ok().body(lecture);
    }

    @GetMapping
    public ResponseEntity<List<LectureResponse>> findAllLectures() {
        List<LectureResponse> allLectures = lectureService.findAllLectures();
        log.info("Get all lectures");
        return ResponseEntity.ok().body(allLectures);
    }

    @PostMapping
    public ResponseEntity<LectureResponse> createLecture(@RequestBody LectureRequest request){

        Validator.requestNotNull(request);

        LectureResponse lectureResponse = lectureService.saveLecture(request);
        log.info("Lecture created: {}", lectureResponse);
        return ResponseEntity.ok().body(lectureResponse);
    }

    @DeleteMapping("{/courseId}")
    public ResponseEntity<HttpStatus> removeLecture(@PathVariable Long lectureId){

        Validator.idNotNull(lectureId);

        lectureService.removeLecture(lectureId);
        log.info("Lecture removed: {}", lectureId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
