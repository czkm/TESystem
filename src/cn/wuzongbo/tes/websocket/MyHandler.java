package cn.wuzongbo.tes.websocket;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
/**
 * 

* <p>Title: MyHandler</p>  

* <p>Description: </p>  

* @author 吴宗波  

* @date 2018年5月22日
 */
public class MyHandler extends TextWebSocketHandler {
	
	
	/*
	   a.在afterConnectionEstablished连接建立成功之后，记录用户的连接标识，便于后面发信息，这里我是记录将id记录在Map集合中。

       b.在handleTextMessage中可以对H5 Websocket的send方法进行处理

       c.sendMessageToUser向指定用户发送消息，传入用户标识和消息体

       d.sendMessageToAllUsers向左右用户广播消息，只需要传入消息体

       e.handleTransportError连接出错处理，主要是关闭出错会话的连接，和删除在Map集合中的记录

       f.afterConnectionClosed连接已关闭，移除在Map集合中的记录。

       g.getClientId我自己封装的一个方法，方便获取用户标识
	 */
	  private static final Logger log = Logger.getLogger(MyHandler.class);

	    // 保存所有的用户session
	 private static final ArrayList<WebSocketSession> users = new ArrayList<WebSocketSession>();
	 
	 private static final String CLIENT_ID = "userId";


	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		users.remove(session);
	}
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		users.add(session);
	}
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		super.handleTextMessage(session, message);
	}
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// TODO Auto-generated method stub
		super.handleTransportError(session, exception);
	}
	

}
