package me.sbsoftware.restfulschool.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/topics")
public class TopicController {

    private final TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    /**
     * Provides rest service for getting all topics
     * @return json response containing all existing topics
     */
    @GetMapping()
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    /**
     * Provides rest service for getting a specific topics
     * @param id of the topic being retrieved
     * @return json response containing the requested topic
     */
    @GetMapping("/{id}")
    public Topic getTopic(@PathVariable String id) {
        return topicService.getTopic(id).orElse(null);
    }

    /**
     * Provides rest service for adding a new topic
     * @param topic the topic to be added
     * @return the newly added topic
     */
    @PostMapping()
    public Topic addTopic(@RequestBody Topic topic) {
        return topicService.addTopic(topic);
    }

    /**
     * Provides rest service for updating a topic
     * @param id of the topic being updated passed in the url
     * @param topic the topic with new updates
     */
    @PutMapping(value = "/{id}")
    public Topic updateTopic(@PathVariable String id, @RequestBody Topic topic) {
        if ( id.equals(topic.getId()) ) {
            return topicService.updateTopic(topic);
        } else {
            // TODO: return error
            return null;
        }
    }

    /**
     * Provides rest service for deleting a topic
     * @param id of the topic to be deleted
     */
    @DeleteMapping(value = "/{id}")
    public void deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
    }
}

// TOPICS
// {"id":"java","name":"Java","description":"Java Description"}
// {"id":"javascript","name":"JavaScript","description":"JavaScript Description"}

// Courses
//