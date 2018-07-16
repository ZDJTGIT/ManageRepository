package com.zd.manager.websocket.controller;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@ServerEndpoint("/websocket")
@Component
public class MyWebSocket{
	Logger logger = LoggerFactory.getLogger(MyWebSocket.class);
	//记录当前在线连接数。
	private static int onlineCount = 0;
	
	//线程安全set，存放每个客户端的MyWebSocket对象
	private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();
	
	//客户端会话，给客户端回消息
	private Session session;
	
	//连接调用
	@OnOpen
	public void onOpen(Session session) {
		this.session = session;
		webSocketSet.add(this);
		addOnlineCount();
		try {
			sendMessage("当前在线人数:"+getOnlineCount()+"人");
		}catch (IOException e) {
			logger.error(e.getStackTrace().toString());
		}
	}
	
	//关闭调用
	@OnClose
	public void onClose() {
		webSocketSet.remove(this);
		subOnlineCount();
	}
	
	//收到客户端消息后调用的方法
	@OnMessage
	public void onMessage(String message,Session session) {
		for (MyWebSocket socket : webSocketSet) {
			try {
				socket.sendMessage(message);
			} catch (IOException e) {
				logger.error(e.getStackTrace().toString());
			}
		}
	}
	
	//发生错误调用
	public void onError(Session session,Throwable error) {
		logger.error(error.getStackTrace().toString());
	}
	
	//给当前连接者发送消息
	public void sendMessage(String message) throws IOException {
		this.session.getBasicRemote().sendText(message);
	}
	
	//群发消息
	public static void senInfo(String message) {
		for (MyWebSocket socket : webSocketSet) {
			try {
				socket.sendMessage(message);
			}catch (IOException e) {
				continue;
			}
		}
	}
	
	//获取连接人数
	public static synchronized int getOnlineCount() {
		return MyWebSocket.onlineCount;
	}
	
	//增加连接人数
	public static synchronized void addOnlineCount() {
		MyWebSocket.onlineCount++;
	}
	
	//减少连接人数
	public static synchronized void subOnlineCount() {
		MyWebSocket.onlineCount--;
	}
}