package me.sbsoftware.restfulschool.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TopicController {

    @Autowired
    private TopicService topicService;

    /**
     * Provides rest service for getting all topics
     * @return json response containing all existing topics
     */
    @GetMapping("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    /**
     * Provides rest service for getting a specific topics
     * @param id of the topic being retrieved
     * @return json response containing the requested topic
     */
    @GetMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    /**
     * Provides rest service for adding a new topic
     * @param topic the topic to be added
     * @return the newly added topic
     */
    @RequestMapping(value="/topics", method=RequestMethod.POST)
    public Topic addTopic(@RequestBody Topic topic) {
        return topicService.addTopic(topic);
    }

    /**
     * Provides rest service for updating a topic
     * @param id of the topic being updated passed in the url
     * @param topic the topic with new updates
     */
    @RequestMapping(value="/topics/{id}", method=RequestMethod.PUT)
    public void updateTopic(@PathVariable String id, @RequestBody Topic topic) {
        if ( id.equals(topic.getId()) ) {
            topicService.updateTopic(topic);
        }
    }

    /**
     * Provides rest service for deleting a topic
     * @param id of the topic to be deleted
     */
    @RequestMapping(value="/topics/{id}", method=RequestMethod.DELETE)
    public void deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
    }
}

// TOPICS
// {"id":"java","name":"Java","description":"Java Description"}
// {"id":"javascript","name":"JavaScript","description":"JavaScript Description"}

// Courses
//