package com.theankang.service.impl;

import com.theankang.dao.UserDAO;
import com.theankang.model.User;
import com.theankang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by jsdgw on 12/10/16.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO=userDAO;
    }

    public void addUser(User user) {
        userDAO.addUser(user);
    }

    public ModelAndView login(String email, String password, String url) {

//        if(email == null || email.equals("")) {
//            return new ModelAndView(url,"error","用户名为空");
//        }
//
//        if(password == null || password.equals("")) {
//            return new ModelAndView(url,"error","密码不能为空");
//        }
//
//        User userFromDB = userDAO.findUserByEmail(email);
//        if(userFromDB.getUserPassword().equals(password)) {
//            String successUrl = "/user/info.jsp";
//            return new ModelAndView(successUrl, userFromDB);
//        }
//
//        return new ModelAndView(url,"error","密码不正确");
        return null;
    }

    public boolean checkLogin(String email, String password) {

        if(email == null || email.equals("")
                || password == null || password.equals("")) {
            return false;
        }else {
            User userFromDB = userDAO.findUserByEmail(email);
            if(userFromDB.getUserPassword().equals(password)) {
                return true;
            }
            return false;
        }
    }

    public User findUserByEmail(String email) {

        User userFromDB = userDAO.findUserByEmail(email);

        return userFromDB;
    }

    public User findUserById(String id) {
        return userDAO.findUserById(id);
    }

    public void update(User user) {
        userDAO.updateUser(user);
    }
}
