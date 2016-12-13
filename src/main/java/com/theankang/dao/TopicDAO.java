package com.theankang.dao;

import com.theankang.model.Topic;

import java.util.List;

/**
 * Created by jsdgw on 11/28/16.
 */
public interface TopicDAO {

    public void addTopic(Topic topic);
    public void deleteTopic(Topic topic);
    public Topic findTopicById(String topicId);
    public List<Topic> findAllTopic();

}
