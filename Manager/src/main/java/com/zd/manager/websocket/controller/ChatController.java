package com.zd.manager.websocket.controller;

import java.security.Principal;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zd.manager.account.service.UserService;
import com.zd.manager.websocket.model.SocketMessage;

/**
 * @author Kstar:
 * @version 2018年6月20日 上午10:55:35
 * 
 */
@Controller
@RequestMapping("/websocket")
public class ChatController {
	
	@Autowired
	private SimpMessagingTemplate temp;
	
	@Resource
	private UserService userservice;
	
	public void all(Principal principal,String message){
		
	}
	private SocketMessage createMessage(String username,String message){
		SocketMessage socketMessage = new SocketMessage();
		socketMessage.setUsername(username);
		socketMessage.setSendTime(new Date());
		socketMessage.setContent(message);
		return socketMessage;
	}
	
}
