package me.sbsoftware.restfulschool.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    /**
     * Performs request to DB retrieving all topics
     * @return all topics found in DB
     */
    List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();

        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    /**
     * Requests a specific topic from the DB
     * @param id of the topic to be retrieved
     * @return the topic found matching the id provide if it exists, null otherwise
     */
    Topic getTopic(String id) { return topicRepository.findById(id).orElse(null); }

    /**
     * Adds a new topic to the DB
     * @param topic to be added to the DB
     * @return the topic saved in the DB
     */
    Topic addTopic(Topic topic) { return topicRepository.save(topic); }

    // TODO: ensure topic exists: throw exception: https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html#existsById-ID-
    /**
     * Updates a topic in the DB
     * @param topic to be updated in the DB
     * @return the topic updated in the DB
     */
    Topic updateTopic(Topic topic) { return topicRepository.save(topic); }

    // TODO: handle deletion of topic which has child courses
    // TODO: handle thrown error
    /**
     * Deletes a topic from the DB
     * @param id of the topic to be deleted
     */
    void deleteTopic(String id) { topicRepository.deleteById(id); }
}
