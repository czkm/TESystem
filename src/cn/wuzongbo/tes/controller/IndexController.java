package cn.wuzongbo.tes.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import cn.wuzongbo.tes.po.Config;
import cn.wuzongbo.tes.po.ConfigExample;
import cn.wuzongbo.tes.po.Status;
import cn.wuzongbo.tes.po.User;
import cn.wuzongbo.tes.service.ConfigService;
import cn.wuzongbo.tes.service.UserService;
import cn.wuzongbo.tes.util.DateUtil;
import cn.wuzongbo.tes.util.JacksonUtil;
import cn.wuzongbo.tes.util.MD5Util;
/**
 * 
* <p>Title: IndexController</p>  

* <p>Description: 首页控制器
* 主要是不需要授权的页面跳转
* </p>  
* @author 吴宗波  

* @date 2018年3月13日
 */
@Controller
public class IndexController {
	@Autowired
	private ConfigService configService;
	
	@Autowired
	private UserService userService;
	
	
	/**
	 * 
	 * <p>Title: index</p>  
	
	 * <p>Description: 设置系统默认首页
	 * @RequestMapping("/")
	 * </p>  
	 * @return 跳转路径
	 * @throws Exception 
	 */
	@RequestMapping("/")
	public String index() throws Exception {
		
		//判断系统平台是否开放
		//平台开始时间
		String starttimeKey="starttime";
		String endtimeKey="endtime";
		
		ConfigExample configExample=new ConfigExample();
		
		ConfigExample.Criteria criteria=configExample.createCriteria();
		criteria.andNameEqualTo(starttimeKey);
		
		String strattime=configService.queryConfigList(configExample).get(0).getValue();
		
		ConfigExample configExample1=new ConfigExample();
		ConfigExample.Criteria criteria1=configExample1.createCriteria();
		criteria1.andNameEqualTo(endtimeKey);
		String endtime=configService.queryConfigList(configExample1).get(0).getValue();
		Date starttimeDate=null; 
		Date endtimeDate=null; 
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd"); 
		starttimeDate=formatter.parse(strattime);
		  
		 endtimeDate=formatter.parse(strattime);
		 Date nowTime=new Date();
		
		boolean isopen=DateUtil.isEffectiveDate(nowTime, starttimeDate, endtimeDate);
		
		return "default/layui/index";
		
	}
	/**
	 * 
	 * <p>Title: tologin</p>  
	 * <p>Description:跳转到用户登录页面 </p>  
	 * @throws Exception 
	 * @return跳转路径
	 */
	@RequestMapping("/tologin")
	public String tologin() throws Exception {
			
		
		return "default/layui/user/login";
	}
	/**
	 * 
	
	 * <p>Title: tologin</p>  
	
	 * <p>Description:跳转到用户注册页面 </p>  
	
	 * @return跳转路径
	 */
	@RequestMapping("/toreg")
	public String toreg() {
		
		return "default/layui/user/reg";
	}
	/**
	 * 
	
	 * <p>Title: login</p>  
	
	 * <p>Description: </p>  
	
	 * @param loginname 工号/学号
	 * @param password 密码
	 * @param type 学生/教师/督导 1/2/3
	 * @return 跳转路径
	 * @throws Exception 
	 */
	@RequestMapping(value="/login",produces="text/html;charset=UTF-8" )
	@ResponseBody
	public String login(HttpSession session,User user,String code) throws Exception{
		Status status=null;
		
		String verifyCode=String.valueOf(session.getAttribute("verCode"));
		if(verifyCode.equals(code)){
		
	       
		
		String userNo=user.getUserno();
		String password=MD5Util.MD5(userNo+user.getPassword());
		user=userService.login(userNo, password);
		if(user!=null&&user.getId()>0){
			session.setAttribute("user", user);
			
			status=new Status();
			status.setStatusCode(1);
			status.setMessage("登录成功");
			
		}
		else{
			
			status=new Status();
			status.setStatusCode(2);
			status.setMessage("登录失败");
			
		}
		}
		else{
			status=new Status();
			status.setStatusCode(3);
			status.setMessage("验证码错误");
		}
		
	
		return JacksonUtil.bean2Json(status);
	}
	@RequestMapping("/adminlogin")
	public String toAdminLogin(){
		
		return "admin/login";
		
	}
	
	@RequestMapping("/footer")
	public String footer(){
		
		return "default/layui/common/footer";
	}
	@RequestMapping("/towelcome")
	public String towelcome(){
		
		return "admin/welcome";
		
	}
	@RequestMapping("/tologinout")
	public String loginout(HttpSession session){
		
		if(session.getAttribute("user")!=null){
			
			session.setAttribute("user", null);
			
		};
		
		return "redirect:tologin";
	}
	
	@RequestMapping("/toscholarship")
	public String toScholarship(Model model) throws Exception{
		
		ConfigExample starttimeExample=new ConfigExample();
		ConfigExample.Criteria starttimeCriteria=starttimeExample.createCriteria();
		starttimeCriteria.andNameEqualTo("scholarship_starttime");
		List<Config> starttimeconfigs=configService.queryConfigList(starttimeExample);
          ConfigExample endtimeExample=new ConfigExample();
		ConfigExample.Criteria endtimeCriteria=endtimeExample.createCriteria();
		endtimeCriteria.andNameEqualTo("scholarship_endtime");
		List<Config> endtimeconfigs=configService.queryConfigList(endtimeExample);
	    Date starttime=DateUtil.stringToDate(starttimeconfigs.get(0).getValue());
	    
	    Date endtime=DateUtil.stringToDate(endtimeconfigs.get(0).getValue());
	    
	   boolean ok=   DateUtil.isEffectiveDate(new Date(), starttime, endtime);
	   
	   if(ok){
		   
		  model.addAttribute("isOpen", true);
		  model.addAttribute("endtime", endtime);
	   }
	   else{
		   
		   model.addAttribute("isOpen", false);
	   }
	    
		
		return "default/layui/scholarship";
		
	}
	@RequestMapping("/toinquiries")
	public String toInquiries(){
		
		
		return "default/layui/inquiries";
		
	}
	

}
