package me.sbsoftware.restfulschool.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    @GetMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    @RequestMapping(value="/topics", method=RequestMethod.POST)
    public Topic addTopic(@RequestBody Topic topic) {
        return topicService.addTopic(topic);
    }

    @RequestMapping(value="/topics/{id}", method=RequestMethod.PUT)
    public void updateTopic(@PathVariable String id, @RequestBody Topic topic) {
        if ( id.equals(topic.getId()) ) {
            topicService.updateTopic(id, topic);
        }
    }

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