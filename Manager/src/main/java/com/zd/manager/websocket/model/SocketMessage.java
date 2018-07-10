package com.zd.manager.websocket.model;

import java.util.Date;

/**
 * @author Kstar:
 * @version 2018年6月20日 上午9:28:12
 * 
 */
public class SocketMessage {
	
	public String username;
	
	public String avatar;
	
	public String nickname;
	
	public String content;
	
	public Date sendTime;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
}
