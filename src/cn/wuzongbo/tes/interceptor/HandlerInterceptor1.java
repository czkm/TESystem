package cn.wuzongbo.tes.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class HandlerInterceptor1  implements HandlerInterceptor{
	//����handler����֮��
	//ͳһ���쳣����ͳһ����־����
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("HandlerInterceptor1...afterCompletion");
		
	}
	//����handler����֮��ִ��ModelAndView֮ǰ
	//����Щ���õ����ݺ���ͼ
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("HandlerInterceptor1...postHandle");
		
	}
	//����handler����֮ǰ
	//���������֤�������Ȩ����ʾ��ǰ�û�û��
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("HandlerInterceptor1..preHandle");
		return true;
	}

}
