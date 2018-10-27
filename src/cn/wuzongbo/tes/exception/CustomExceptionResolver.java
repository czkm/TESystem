package cn.wuzongbo.tes.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 

* <p>Title: CustomExceptionResolver</p>  

* <p>Description:全局异常处理器 </p>  

* @author 吴宗波  

* @date 2018年2月27日
 */
public class CustomExceptionResolver implements HandlerExceptionResolver  {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception e) {
		// TODO Auto-generated method stub
		
		CustomException ce=null;
		if(e instanceof CustomException){
			
			ce=(CustomException)e;
		}
		else{
			
			ce=new CustomException(e.getMessage());
			
		}
		
		String message=ce.getMessage();
		ModelAndView mav=new ModelAndView();
		mav.addObject("message", message);
		mav.setViewName("error");
		
		return mav;
	}

}
