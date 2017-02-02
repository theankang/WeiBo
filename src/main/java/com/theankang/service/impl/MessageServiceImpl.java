package com.theankang.service.impl;

import com.theankang.dao.MessageDAO;
import com.theankang.model.Message;
import com.theankang.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jsdgw on 1/27/17.
 */
@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageDAO messageDAO;


    public void saveMessage(Message message) {

        messageDAO.addMessage(message);
    }
}
