package com.theankang.dao.impl;

import com.theankang.dao.CommentDAO;
import com.theankang.model.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by jsdgw on 12/2/16.
 */
@Repository
public class CommentDAOImpl implements CommentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    /*
     *获取和当前线程绑定的Session
     */
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addComment(Comment comment) {
        getSession().save(comment);
    }

    public void updateComment(Comment comment) {
        getSession().update(comment);
    }

    public void deleteComment(Comment comment) {
        getSession().delete(comment);
    }

    public Comment findCommentById(String replyId) {
        String hql = "from Comment comment where comment.replyId = :replyId";
        Query query = getSession().createQuery(hql);
        query.setParameter("replyId", replyId);
        Comment comment = (Comment) query.uniqueResult();
        return comment;
    }
}
