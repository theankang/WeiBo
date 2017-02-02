package com.theankang.controller;

import com.theankang.model.Message;
import com.theankang.model.User;
import com.theankang.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Created by jsdgw on 1/27/17.
 */
@Controller
public class MessageControllerOld {

    @Autowired
    private MessageService messageService;

//    @RequestMapping(value = "/user/${user}/msg/add", method = RequestMethod.POST)
//    public String addMessage(@PathVariable User user, @ModelAttribute Message msg) {
//
//        Date currentTime = new Date();
//        msg.setMessagePublishedTime(currentTime);
//        msg.setUser(user);
//        messageService.saveMessage(msg);
//        return "/user/"+user.getUserId()+"/weibos";
//    }
//
//    @RequestMapping(value = "/user/{id}/weibos")
//    public String toMessagesPage(@PathVariable String id) {
//
//
//        return "user/all_weibos";
//    }

}
