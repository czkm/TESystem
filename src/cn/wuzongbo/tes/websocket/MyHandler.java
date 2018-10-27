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

* @author ���ڲ�  

* @date 2018��5��22��
 */
public class MyHandler extends TextWebSocketHandler {
	
	
	/*
	   a.��afterConnectionEstablished���ӽ����ɹ�֮�󣬼�¼�û������ӱ�ʶ�����ں��淢��Ϣ���������Ǽ�¼��id��¼��Map�����С�

       b.��handleTextMessage�п��Զ�H5 Websocket��send�������д���

       c.sendMessageToUser��ָ���û�������Ϣ�������û���ʶ����Ϣ��

       d.sendMessageToAllUsers�������û��㲥��Ϣ��ֻ��Ҫ������Ϣ��

       e.handleTransportError���ӳ�������Ҫ�ǹرճ���Ự�����ӣ���ɾ����Map�����еļ�¼

       f.afterConnectionClosed�����ѹرգ��Ƴ���Map�����еļ�¼��

       g.getClientId���Լ���װ��һ�������������ȡ�û���ʶ
	 */
	  private static final Logger log = Logger.getLogger(MyHandler.class);

	    // �������е��û�session
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
