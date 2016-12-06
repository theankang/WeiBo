package com.theankang.dao.impl;

import com.theankang.dao.MessageDAO;
import com.theankang.model.Message;
import com.theankang.model.Topic;
import com.theankang.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jsdgw on 11/30/16.
 */
@Repository
public class MessageDAOImpl implements MessageDAO{

    @Autowired
    private SessionFactory sessionFactory;

    /*
     *获取和当前线程绑定的Session
     */
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    public void addMessage(Message msg) {
        getSession().save(msg);
    }

    public void updateMessage(Message msg) {
        getSession().update(msg);
    }

    public void deleteMessage(Message msg) {
        getSession().delete(msg);
    }

    public Message findMessageById(String messageId) {
        String hql = "from Message msg where msg.messageId = :messageId";
        Query query = getSession().createQuery(hql);
        query.setParameter("messageId", messageId);
        Message msg = (Message) query.uniqueResult();
        return msg;
    }

    public List<Message> findAllMessageByUser(User user) {

        String hql = "from Message msg where msg.user = :user";
        Query query = getSession().createQuery(hql);
        query.setParameter("user", user);

        List<Message> messageList = query.list();
        return messageList;
    }

    public List<Message> findAllMessageByTopic(Topic topic) {

        String hql = "from Message msg where msg.topic = :topic";
        Query query = getSession().createQuery(hql);
        query.setParameter("topic", topic);

        List<Message> messageList = query.list();
        return messageList;
    }

}
