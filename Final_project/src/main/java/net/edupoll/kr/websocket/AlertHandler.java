package net.edupoll.kr.websocket;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import net.edupoll.kr.entity.AccountVo;

public class AlertHandler extends TextWebSocketHandler {

		@Autowired
		Map users;
		
	
		@Override
		public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		/*
		String id = session.getId();	
		Map<String,Object> map = session.getAttributes();
		System.out.println("size = " + map.size());
		for(String key :map.keySet()) {
			
			Object obj = map.get(key);
			System.out.println(key + " = " +obj);
		}*/
			
			if(session.getAttributes().containsKey("loginUser")) {
				AccountVo vo  = (AccountVo) session.getAttributes().get("loginUser");
				
				users.put(vo.getUserId(), session);
			}
			
		}
	
		@Override
		public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
			if(session.getAttributes().containsKey("loginUser")) {
				AccountVo vo  = (AccountVo) session.getAttributes().get("loginUser");
				
				users.remove(vo.getUserId());
			}
		}
}
