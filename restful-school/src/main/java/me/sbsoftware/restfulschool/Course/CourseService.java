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


    public List<Course> getAllCourses(String topicId) {
        List<Course> courses = new ArrayList<>();

        courseRepository.findByTopicId(topicId);
        return courses;
    }

    public Course getCourse(String id) {
        return courseRepository.findById(id).orElse(null);
    }


    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
//        Topic toUpdate = topicList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
//            toUpdate.setName(topic.getName());
//            toUpdate.setDescription(topic.getDescription());
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
//        topicList.removeIf(t -> t.getId().equals(id));
//        topicList.remove(id);
    }
}
