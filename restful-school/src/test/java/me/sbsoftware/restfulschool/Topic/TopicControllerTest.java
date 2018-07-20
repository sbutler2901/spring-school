package me.sbsoftware.restfulschool.Topic;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TopicController.class)
public class TopicControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TopicService topicService;

    private Topic javaTopic = new Topic("java", "Java", "Java Description");
    private Topic jsTopic = new Topic("javascript", "Javascript", "Javascript Description");

    @Test
    public void getAllTopics() throws Exception {
        Mockito.when(topicService.getAllTopics()).thenReturn(Arrays.asList(javaTopic, jsTopic));

        mockMvc.perform(get("/topics"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.*", Matchers.hasSize(2)))
                .andExpect(jsonPath("$.[0].id", Matchers.is(javaTopic.getId())))
                .andExpect(jsonPath("$.[1].id", Matchers.is(jsTopic.getId())));

        Mockito.verify(topicService).getAllTopics();
    }

    @Test
    public void getTopic() throws Exception {
        Mockito.when(topicService.getTopic("java")).thenReturn(Optional.of(javaTopic));

        mockMvc.perform(get("/topics/java"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is(javaTopic.getId())))
                .andExpect(jsonPath("$.name", Matchers.is(javaTopic.getName())))
                .andExpect(jsonPath("$.description", Matchers.is(javaTopic.getDescription())));


        Mockito.verify(topicService).getTopic("java");
    }

    @Test
    public void addTopic() throws Exception {
        Mockito.when(topicService.addTopic(any(Topic.class))).thenReturn(javaTopic);

        mockMvc.perform(post("/topics")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(javaTopic.toJson()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is(javaTopic.getId())))
                .andExpect(jsonPath("$.name", Matchers.is(javaTopic.getName())))
                .andExpect(jsonPath("$.description", Matchers.is(javaTopic.getDescription())));
                /*.andDo(mvcResult -> {
                    System.out.println(mvcResult.getResponse().getHeaderNames());
                    System.out.println("test: " + mvcResult.getResponse().getContentAsString());
                });*/

        Mockito.verify(topicService).addTopic(any(Topic.class));
    }

    @Test
    public void updateTopic() throws Exception {
        Mockito.when(topicService.updateTopic(any(Topic.class))).thenReturn(javaTopic);

        mockMvc.perform(put("/topics/java")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(javaTopic.toJson()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is(javaTopic.getId())))
                .andExpect(jsonPath("$.name", Matchers.is(javaTopic.getName())))
                .andExpect(jsonPath("$.description", Matchers.is(javaTopic.getDescription())));

        Mockito.verify(topicService).updateTopic(any(Topic.class));
    }

    @Test
    public void deleteTopic() throws Exception {

        mockMvc.perform(delete("/topics/java")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(javaTopic.toJson()))
                .andExpect(status().isOk());

        Mockito.verify(topicService).deleteTopic("java");
    }
}