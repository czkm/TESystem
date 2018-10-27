package cn.wuzongbo.tes.websocket;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import cn.wuzongbo.tes.po.User;

public class WebSocketInterceptor implements HandshakeInterceptor {

	@Override
	public void afterHandshake(ServerHttpRequest req, ServerHttpResponse res, WebSocketHandler webSocketHandler, Exception exception) {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public boolean beforeHandshake(ServerHttpRequest req, ServerHttpResponse res, WebSocketHandler webSocketHandler,
			Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		
		if(req instanceof ServletServerHttpRequest){
			ServletServerHttpRequest servletServerHttpRequest=(ServletServerHttpRequest)req;
			HttpSession session =servletServerHttpRequest.getServletRequest().getSession();
			 Map parameterMap = servletServerHttpRequest.getServletRequest().getParameterMap();
			if(session!=null){
				User user=(User)session.getAttribute("user");
				map.put("userId", user.getUserno());
			}
			
		}
		return true;
	}

}
