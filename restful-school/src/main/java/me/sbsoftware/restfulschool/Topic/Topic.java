package me.sbsoftware.restfulschool.Topic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.sbsoftware.restfulschool.Course.Course;

import javax.persistence.*;

@Entity
@Table(name="topic")
public class Topic {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="topic_id")
    private String id;

    @Column(name="topic_name")
    private String name;

    @Column(name="topic_desc")
    private String description;

//    @OneToMany
//    private Course[] courses;

    public Topic(String id, String name, String description) {
        if ( id == null ) throw new IllegalArgumentException("id was null");
        if ( name == null ) throw new IllegalArgumentException("name was null");
        if ( description == null ) throw new IllegalArgumentException("description was null");

        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() { return "Topic: id: " + this.id + ", name: " + this.name + ", description: " + this.description; }

    public Boolean equals(Topic topic) {
        return (this.id.equals(topic.id) && this.name.equals(topic.name) && this.description.equals(topic.description));
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }
}
