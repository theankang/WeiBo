//package com.theankang.service.impl;
//
//import com.theankang.dao.CommentDAO;
//import com.theankang.dao.MessageDAO;
//import com.theankang.dao.TopicDAO;
//import com.theankang.dao.UserDAO;
//import com.theankang.model.Comment;
//import com.theankang.model.Message;
//import com.theankang.model.Topic;
//import com.theankang.model.User;
//import com.theankang.service.RegisterService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * Created by jsdgw on 11/29/16.
// */
//@Service
//public class RegisterServiceImpl implements RegisterService {
//
//    @Autowired
//    private UserDAO userDao;
//    private MessageDAO messageDao;
//    private TopicDAO topicDAO;
//    private CommentDAO commentDAO;
//
//    public RegisterServiceImpl(MessageDAO messageDao, TopicDAO topicDAO) {
//        this.messageDao = messageDao;
//        this.topicDAO = topicDAO;
//    }
//
//    public void Register(User user) {
//        userDao.addUser(user);
//        //userDao.updateUser(user);
//        //userDao.deleteUser(user);
//    }
//
//    public User findUser(String userId) {
//        User user = userDao.findUserById(userId);
//        return user;
//    }
//
//    public List<Message> findAllMessageService(User user) {
//        List<Message> messageList = messageDao.findAllMessageByUser(user);
//        return messageList;
//    }
//
//    public List<Topic> findAllTopic() {
//        List<Topic> topicList = topicDAO.findAllTopic();
//        for(Topic t : topicList) {
//            System.out.println(t.toString());
//        }
//        return topicDAO.findAllTopic();
//    }
//
//    public Comment findCommentById(String replyId) {
//        return commentDAO.findCommentById(replyId);
//    }
//
//}
