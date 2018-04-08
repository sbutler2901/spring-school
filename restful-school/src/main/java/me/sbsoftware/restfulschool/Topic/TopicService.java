package me.sbsoftware.restfulschool.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();

        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    Topic getTopic(String id) {
        return topicRepository.findById(id).orElse(null);
    }

    Topic addTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    void updateTopic(String id, Topic topic) { topicRepository.save(topic); }

    void deleteTopic(String id) { topicRepository.deleteById(id); }
}
