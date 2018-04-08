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

    @GetMapping("/topics/{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable String topicId){
        return courseService.getAllCourses(topicId);
    }

    @GetMapping("/topics/{topicId}/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId) {
        return courseService.getCourse(courseId);
    }

    @RequestMapping(value="/topics/{topicId}/courses", method=RequestMethod.POST)
    public Course addCourse(@RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        return courseService.addCourse(course);
    }

    @RequestMapping(value="/topics/{topicId}/courses/{courseId}", method=RequestMethod.PUT)
    public void updateCourse(@PathVariable String courseId, @RequestBody Course course) {
        if ( courseId.equals(course.getId()) ) {
            courseService.updateCourse(course);
        }
    }

    @RequestMapping(value="/topics/{topicId}/courses/{courseId}", method=RequestMethod.DELETE)
    public void deleteCourse(@PathVariable String courseId) {
        courseService.deleteCourse(courseId);
    }
}
