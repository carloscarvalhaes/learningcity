package com.expertcloud.learningcity.service;

import com.expertcloud.learningcity.exception.NotFoundException;
import com.expertcloud.learningcity.model.dto.course.CourseResponse;
import com.expertcloud.learningcity.model.dto.lecture.LectureRequest;
import com.expertcloud.learningcity.model.dto.lecture.LectureResponse;
import com.expertcloud.learningcity.model.entity.Course;
import com.expertcloud.learningcity.model.entity.Lecture;
import com.expertcloud.learningcity.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.expertcloud.learningcity.util.GenericMessages.UNABLE_TO_FIND_LECTURE;

@Slf4j
@Service
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;
    private final CourseService courseService;

    public LectureResponse getLecture(Long lectureId) {
        Optional<Lecture> byId = lectureRepository.findById(lectureId);
        if (byId.isEmpty()) {
            log.error(UNABLE_TO_FIND_LECTURE);
            throw new NotFoundException(UNABLE_TO_FIND_LECTURE);
        }
        return toResponse(byId.get());
    }

    public LectureResponse saveLecture(LectureRequest request) {
        Lecture lecture = toEntity(request);
        lecture = lectureRepository.save(lecture);
        return toResponse(lecture);
    }

    public List<LectureResponse> findAllLectures() {
        return lectureRepository.findAll().stream().map(this::toResponse).collect(Collectors.toList());
    }

    public void removeLecture(Long lectureId) {
        try {
            lectureRepository.deleteById(lectureId);
        } catch (Exception e) {
            log.error("Unable to remove lecture");
        }
    }

    /*
                Mapping functions
     */

    private Lecture toEntity(LectureRequest request){
        Lecture lecture = new Lecture();
        lecture.setName(request.getName());
        lecture.setDescription(request.getDescription());
        Course course = courseService.getCourse(request.getCourseId());
        lecture.setCourse(course);
        return lecture;
    }

    private LectureResponse toResponse(Lecture lecture){
        LectureResponse response = new LectureResponse();
        response.setId(lecture.getId());
        response.setName(lecture.getName());
        response.setDescription(lecture.getDescription());
        response.setDescription(lecture.getDuration());
        response.setCourse(new CourseResponse(lecture.getCourse()));
        return response;
    }

}
