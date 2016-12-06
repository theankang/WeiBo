package com.theankang.dao;

import com.theankang.model.Message;
import com.theankang.model.Topic;
import com.theankang.model.User;

import java.util.List;

/**
 * Created by jsdgw on 11/30/16.
 */
public interface MessageDAO {

    public void addMessage(Message msg);
    public void updateMessage(Message msg);
    public void deleteMessage(Message msg);
    public Message findMessageById(String messageId);
    public List<Message> findAllMessageByUser(User user);
    public List<Message> findAllMessageByTopic(Topic topic);
}
