package me.sbsoftware.restfulschool.Topic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicServiceTest {

    @MockBean
    private TopicRepository topicRepository;

    @Autowired
    private TopicService topicService;

    private Topic javaTopic = new Topic("java", "Java", "Java Description");
    private Topic jsTopic = new Topic("javascript", "Javascript", "Javascript Description");

    @Test
    public void getAllTopics() {
        when(topicRepository.findAll()).thenReturn(Arrays.asList(javaTopic, jsTopic));

        List<Topic> topicList = topicService.getAllTopics();
        assert(topicList.equals(topicRepository.findAll()));
    }

    @Test
    public void getTopic() {
        when(topicRepository.findById("java")).thenReturn(Optional.of(javaTopic));
        when(topicRepository.findById("javascript")).thenReturn(Optional.empty());

        assert(topicService.getTopic("java").equals(javaTopic));
        assert(topicService.getTopic("javascript") == null);
        assert(topicService.getTopic(null) == null);
    }

    @Test
    public void addTopic() {
        when(topicRepository.save(javaTopic)).thenReturn(javaTopic);

        assert(topicService.addTopic(javaTopic).equals(javaTopic));
        assert(topicService.addTopic(null) == null);
    }

    @Test
    public void updateTopic() {
        when(topicRepository.save(javaTopic)).thenReturn(javaTopic);
        when(topicRepository.existsById(javaTopic.getId())).thenReturn(true);
        when(topicRepository.save(jsTopic)).thenReturn(null);

        assert(topicService.updateTopic(javaTopic).equals(javaTopic));
        assert(topicService.updateTopic(jsTopic) == null);
        assert(topicService.updateTopic(null) == null);
    }

    @Test
    public void deleteTopic() {
        when(topicRepository.existsById("java")).thenReturn(true);
        when(topicRepository.existsById("javascript")).thenReturn(false);

        assert(topicService.deleteTopic("java").equals("java"));
        assert(topicService.deleteTopic("javascript") == null);
        assert(topicService.deleteTopic(null) == null);
    }
}