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

    /**
     * Performs request to DB retrieving all courses
     * @return all courses found in DB
     */
    List<Course> getAllCourses(String topicId) { return courseRepository.findByTopicId(topicId); }

    /**
     * Requests a specific course from the DB
     * @param id of the course to be retrieved
     * @return the course found matching the id provide if it exists, null otherwise
     */
    Course getCourse(String id) { return courseRepository.findById(id).orElse(null); }

    /**
     * Adds a new course to the DB
     * @param course to be added to the Db
     * @return the course saved in the DB
     */
    Course addCourse(Course course) { return courseRepository.save(course); }

    // TODO: ensure course exists
    /**
     * Updates a course in the DB
     * @param course to be updated in the DB
     */
    void updateCourse(Course course) { courseRepository.save(course); }

    // TODO: Handle error thrown
    /**
     * Deletes a course from the DB
     * @param id of the course to be deleted
     */
    void deleteCourse(String id) { courseRepository.deleteById(id); }
}
