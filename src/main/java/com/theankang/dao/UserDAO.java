package com.theankang.dao;

import java.util.List;
import com.theankang.model.User;

/**
 * Created by jsdgw on 11/28/16.
 */
public interface UserDAO {

    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(User user);
    public User findUserById(String userId);
    public User findUserByNickName(String userNickName);
    public User findUserByEmail(String email);

    // To Do..
    public List<User> findAllUser();
    public User findUserByMessageId(String messageId);

}
