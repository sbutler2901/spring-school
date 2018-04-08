package me.sbsoftware.restfulschool.Course;

import me.sbsoftware.restfulschool.Topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * Provides rest service for getting all courses for a specific topic
     * @param topicId of parent topic for courses to be retrieved
     * @return json response containing all existing topics
     */
    @GetMapping("/topics/{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable String topicId){ return courseService.getAllCourses(topicId); }

    /**
     * Provides rest service for getting a specific course
     * @param courseId of course to be retrieved
     * @return the course requested
     */
    @GetMapping("/topics/{topicId}/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId) { return courseService.getCourse(courseId); }

    /**
     * Provides rest service for adding a course
     * @param course the course to be added
     * @param topicId id of parent topic for course
     * @return
     */
    @RequestMapping(value="/topics/{topicId}/courses", method=RequestMethod.POST)
    public Course addCourse(@RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));

        return courseService.addCourse(course);
    }

    /**
     * Provides rest service for updating a course
     * @param courseId id of course to be updated passed in the url
     * @param course the course with new updates
     */
    @RequestMapping(value="/topics/{topicId}/courses/{courseId}", method=RequestMethod.PUT)
    public void updateCourse(@PathVariable String courseId, @RequestBody Course course) {
        if ( courseId.equals(course.getId()) ) {
            courseService.updateCourse(course);
        }
    }

    /**
     * Provides rest service for deleting a course
     * @param courseId id of course to be deleted
     */
    @RequestMapping(value="/topics/{topicId}/courses/{courseId}", method=RequestMethod.DELETE)
    public void deleteCourse(@PathVariable String courseId) { courseService.deleteCourse(courseId); }
}
