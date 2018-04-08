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

//    private List<Topic> topicList = new ArrayList<Topic>(Arrays.asList(
//            new Topic("Java", "Java Core", "Java Description"),
//            new Topic("JavaScript", "JavaScript", "JavaScript Description"),
//            new Topic("Spring", "Spring Framework", "Spring Framework Description")
//    ));

    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();

        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id) {
        return topicRepository.findById(id).orElse(null);
    }


    public Topic addTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
        topicRepository.save(topic);
//        Topic toUpdate = topicList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
//            toUpdate.setName(topic.getName());
//            toUpdate.setDescription(topic.getDescription());
    }

    public String deleteTopic(String id) {
        topicRepository.deleteById(id);
        return id;
//        topicList.removeIf(t -> t.getId().equals(id));
//        topicList.remove(id);
    }
}
