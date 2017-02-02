package com.theankang.controller;

import com.theankang.common.BaseController;
import com.theankang.model.Message;
import com.theankang.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by jsdgw on 1/27/17.
 */
@Controller
public class MessageController extends BaseController {

    @RequestMapping(value = "/user/{id}/msg/add", method = RequestMethod.POST)
    public String addMessage(@PathVariable String id, @ModelAttribute Message msg, HttpSession session) {

        User user = (User) session.getAttribute("user");
        msg.setMessagePublishedTime(new Date());
        msg.setMessageFavorite(0);
        msg.setMessageForward(0);
        msg.setMessageReply(0);
        msg.setUser(user);
        messageService.saveMessage(msg);
        return "redirect:/user/"+ user.getUserId() + "/all_weibos";
    }

    @RequestMapping(value = "/user/{id}/all_weibos")
    public String toUserAllWeibos(@PathVariable String id) {

        return "user/all_weibos";
    }

}
