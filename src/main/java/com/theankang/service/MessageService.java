package com.theankang.service;

import com.theankang.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jsdgw on 1/27/17.
 */

public interface MessageService {

    public void saveMessage(Message message);

}
