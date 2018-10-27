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
			
			model.addAttribute("message", "�Բ��𣬿������Ѿ��ظ�������ϸ�����Ŀ�����");
			return "error";
		}
		else{
    	   
			scholarshipService.insert(scholarship);
			model.addAttribute("message", "��ϲ�������ύ�ɹ��������鿴�������鿴ѧУ���֪ͨ��лл");
			
			return "success";
			 
    	   
       }
		
	}
	@RequestMapping(value="/clear", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String clear() throws JsonProcessingException{
		
		scholarshipService.clear();
		
		Status status=new Status();
		
		status.setStatusCode(1);
		status.setMessage("������ճɹ�");
		return JacksonUtil.bean2Json(status);
		
	}
	/**
	 * 
	
	 * <p>Title: checkStudentNo</p>  
	
	 * <p>Description:�ж�ѧ�������Ƿ��ظ� </p>  
	
	 * @return
	 */
	private boolean checkStudentNo(String studentNo){
		
     	return	scholarshipService.checkStudentNo(studentNo);
		
	}
	
	

}
