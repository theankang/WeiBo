package com.theankang.dao.impl;

import com.theankang.dao.TopicDAO;
import com.theankang.model.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * Created by jsdgw on 12/1/16.
 */

@Repository
public class TopicDAOImpl implements TopicDAO{
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addTopic(Topic topic) {
        getSession().save(topic);
    }

    public void deleteTopic(Topic topic) {
        getSession().delete(topic);
    }

    public Topic findTopicById(String topicId) {

        String hql = "from Topic topic where topic.topicId = :topicId";
        Query query = getSession().createQuery(hql);
        query.setParameter("topicId", topicId);
        Topic topic = (Topic) query.uniqueResult();
        return topic;
    }

    public List<Topic> findAllTopic() {
        String hql = "from Topic topic";
        Query query = getSession().createQuery(hql);
        List<Topic> topicList = query.list();
        return topicList;
    }

}
