package com.theankang.service;

import com.theankang.model.User;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by jsdgw on 11/29/16.
 */
public interface UserService {

    public void addUser(User user);
    public ModelAndView login(String email, String password, String url);
    public boolean checkLogin(String email, String password);
    public User findUserByEmail(String email);
    public User findUserById(String id);
    public void update(User user);

}
