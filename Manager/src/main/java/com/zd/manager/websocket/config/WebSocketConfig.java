package com.zd.manager.websocket.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;
import org.springframework.web.socket.handler.WebSocketHandlerDecorator;
import org.springframework.web.socket.handler.WebSocketHandlerDecoratorFactory;

/**
 * @author Kstar:
 * @version 2018年6月20日 上午9:24:32
 * 
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	private Logger logger = LoggerFactory.getLogger(WebSocketConfig.class);
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("my-websocket").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/topic");
		config.setApplicationDestinationPrefixes("/app");
	}
	@Override
	public void configureWebSocketTransport(
			WebSocketTransportRegistration registration) {
		registration.addDecoratorFactory(new WebSocketHandlerDecoratorFactory(){

			@Override
			public WebSocketHandler decorate(WebSocketHandler handler) {
				return new WebSocketHandlerDecorator(handler){
					@Override
					public void afterConnectionEstablished(
							WebSocketSession session) throws Exception {
						String username = session.getPrincipal().getName();
						logger.info("online:"+username);
						super.afterConnectionEstablished(session);
					}
					@Override
					public void afterConnectionClosed(WebSocketSession session,
							CloseStatus closeStatus) throws Exception {
						String username = session.getPrincipal().getName();
						logger.info("offline:"+username);
						super.afterConnectionClosed(session, closeStatus);
					}
				};
			}
		});
		super.configureWebSocketTransport(registration);
	}
}
