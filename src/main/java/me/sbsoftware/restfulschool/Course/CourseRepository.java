package me.sbsoftware.restfulschool.Course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {
    // Custom methods desired to be implemented by JPA should use camel case and the function name
    // defines what is expected of JPA
    // For example courses are desired to be found by topic however the actual DB column must be express
    // therefore using "Topic" and then referencing its id property which acts as a foreign key in the Db
    // resulting in "TopicID"
    public List<Course> findByTopicId(String topicID);
}
