package cn.wuzongbo.tes.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class HandlerInterceptor1  implements HandlerInterceptor{
	//进入handler方法之后，
	//统一的异常处理，统一的日志处理
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("HandlerInterceptor1...afterCompletion");
		
	}
	//进入handler方法之后，执行ModelAndView之前
	//将这些公用的数据和视图
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("HandlerInterceptor1...postHandle");
		
	}
	//进入handler方法之前
	//用于身份认证、身份授权，表示当前用户没有
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("HandlerInterceptor1..preHandle");
		return true;
	}

}
