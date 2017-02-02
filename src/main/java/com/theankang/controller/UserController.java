package com.theankang.controller;

import com.theankang.model.User;
import com.theankang.service.UserService;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by jsdgw on 12/10/16.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration_success")
    public String registrationSuccess() {
        return "registration_success";
    }

    /*
     * NOTE: redirect:URI
     * the URI still need a requestMapping to deal
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("userForm") User user) {

        Date currentDate = new Date();
        user.setRegistrationDate(currentDate);
        userService.addUser(user);

        return "redirect:/registration_success";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String toRegister() {

        return "register";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("userLogin") User userLogin, HttpSession httpSession) {

        String email = userLogin.getEmail();
        String password = userLogin.getUserPassword();

        if(!userService.checkLogin(email, password)) {
            return new ModelAndView(new RedirectView("login_error"));
        }
        User userFromDB = userService.findUserByEmail(email);
        String url = "user/" + userFromDB.getUserId().toString() + "/home";
        httpSession.setAttribute("user", userFromDB);
        return new ModelAndView(new RedirectView(url));
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin(@ModelAttribute("userLogin") User userLogin) {


        return "login";
    }

    @RequestMapping(value = "/login_error")
    public String toLoginError() {

        return "login_error";
    }

    @RequestMapping(value = "/user/{id}/home")
    public String toUserHome(@PathVariable String id, HttpSession httpSession) {
        System.out.println("-------------/user/{id}/home-------------");
        System.out.println(((User)httpSession.getAttribute("user")).getAttentionGroupSet().toString());
        return "/user/home";
    }

    @RequestMapping(value = "/user/logout")
    public String logout(HttpSession httpSession) {

        httpSession.removeAttribute("user");
        System.out.println("This is /user/logout");
        return "redirect:/index";
    }

    @RequestMapping(value = "/user/{id}/profile")
    public String toUserProfile(@PathVariable String id, HttpSession httpSession) {

        System.out.println("This is /user/{id}/profile");
        return "/user/profile";
    }










    @RequestMapping(value = "/user/info/{id}", method = RequestMethod.GET)
    public ModelAndView userInfo(@PathVariable String id) {

        String url = "/user/info";
        ModelAndView modelAndView = new ModelAndView(url);
        User userFromDB = userService.findUserById(id);
        List<User> userList = new LinkedList<User>();
        userList.add(userFromDB);
        modelAndView.addObject("user", userList);
        System.out.println(modelAndView.toString());
        return modelAndView;
    }

    @RequestMapping(value = "/user/edit_user/{id}", method = RequestMethod.GET)
    public ModelAndView toEditInfo(@PathVariable String id, Map<String, Object> map) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/editinfo");
        modelAndView.addObject("user", userService.findUserById(id));

        return modelAndView;
    }


    @RequestMapping(value = "/user/editinfo/{id}", method = RequestMethod.POST)
    public String editInfoPost(@PathVariable String id, User user) {

        User oldUser = userService.findUserById(id);
        oldUser.setUserNickname(user.getUserNickname());
        oldUser.setUserName(user.getUserName());
        oldUser.setEmail(user.getEmail());
        oldUser.setUserPassword(user.getUserPassword());
        oldUser.setUserInfo(user.getUserInfo());
        userService.update(oldUser);
        return "redirect:/user/info/"+id;
    }


}
