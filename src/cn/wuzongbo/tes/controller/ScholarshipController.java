package cn.wuzongbo.tes.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import cn.wuzongbo.tes.po.Scholarship;
import cn.wuzongbo.tes.po.Status;
import cn.wuzongbo.tes.service.ScholarshipService;
import cn.wuzongbo.tes.util.JacksonUtil;

@Controller
@RequestMapping("/scholarship")
public class ScholarshipController {
	@Autowired
	private ScholarshipService scholarshipService;
	@RequestMapping("/add")
	public String add(Model model,Scholarship scholarship){
		
		scholarship.setCreatetime(new Date());
		boolean isCheck=checkStudentNo(scholarship.getStudentno());

		if(isCheck){
			
			model.addAttribute("message", "对不起，考生号已经重复，请仔细检查你的考生号");
			return "error";
		}
		else{
    	   
			scholarshipService.insert(scholarship);
			model.addAttribute("message", "恭喜，数据提交成功，如果想查看结果，请查看学校相关通知，谢谢");
			
			return "success";
			 
    	   
       }
		
	}
	@RequestMapping(value="/clear", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String clear() throws JsonProcessingException{
		
		scholarshipService.clear();
		
		Status status=new Status();
		
		status.setStatusCode(1);
		status.setMessage("数据清空成功");
		return JacksonUtil.bean2Json(status);
		
	}
	/**
	 * 
	
	 * <p>Title: checkStudentNo</p>  
	
	 * <p>Description:判断学生考号是否重复 </p>  
	
	 * @return
	 */
	private boolean checkStudentNo(String studentNo){
		
     	return	scholarshipService.checkStudentNo(studentNo);
		
	}
	
	

}
