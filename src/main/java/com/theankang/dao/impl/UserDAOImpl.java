package com.theankang.dao.impl;

import com.theankang.dao.UserDAO;
import com.theankang.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jsdgw on 11/28/16.
 */
@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    /*
     *获取和当前线程绑定的Session
     */
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addUser(User user) {
        getSession().save(user);
    }

    public void updateUser(User user) {
        //String hql = "update User user set user.userNickname = ? where user.userId = ?";
        //getSession().createQuery(hql).setParameter(0, user.getUserNickname()).setParameter(1, user.getUserId()).executeUpdate();
        getSession().update(user);
    }

    public void deleteUser(User user) {
        getSession().delete(user);
    }

    public User findUserById(String userId) {
        String hql = "from User user where user.userId = :userId";
        Query query = getSession().createQuery(hql);
        query.setParameter("userId", userId);
        User user = (User) query.uniqueResult();
        return user;
    }

    public User findUserByNickName(String userNickname) {
        String hql = "from User user where user.userNickname = :userNickname";
        Query query = getSession().createQuery(hql);
        query.setParameter("userNickname", userNickname);
        User user = (User) query.uniqueResult();
        return user;
    }

    public List<User> findAllUser() {
        String hql = "from User user";
        Query query = getSession().createQuery(hql);
        List<User> userList = query.list();
        return userList;
    }

    public User findUserByMessageId(String messageId) {
        return null;
    }
}
