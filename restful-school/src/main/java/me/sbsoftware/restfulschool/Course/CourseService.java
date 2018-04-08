package me.sbsoftware.restfulschool.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;


    List<Course> getAllCourses(String topicId) {
        List<Course> courses = new ArrayList<>();

        courseRepository.findByTopicId(topicId);
        return courses;
    }

    Course getCourse(String id) {
        return courseRepository.findById(id).orElse(null);
    }

    Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    void updateCourse(Course course) { courseRepository.save(course); }

    void deleteCourse(String id) { courseRepository.deleteById(id); }
}
