package cn.wuzongbo.tes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import cn.wuzongbo.tes.po.Recruit;
import cn.wuzongbo.tes.po.RecruitExample;
import cn.wuzongbo.tes.po.Status;
import cn.wuzongbo.tes.service.RecruitService;
import cn.wuzongbo.tes.util.JacksonUtil;

@Controller
@RequestMapping("/recruit")
public class RecruitController {
	
	@Autowired
	private RecruitService recruitService;
	
	@RequestMapping(value = "/query", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String  query(Recruit recruit) throws Exception {
		
		RecruitExample recruitExample=new RecruitExample();
		RecruitExample.Criteria criteria=recruitExample.createCriteria();
		criteria.andNameEqualTo(recruit.getName());
		criteria.andStudentnoEqualTo(recruit.getStudentno());
		Recruit recruit2=null;
		List<Recruit> recruits=recruitService.query(recruitExample);
		if(recruits!=null&&recruits.size()>0){
			
			recruit2=recruits.get(0);
		}
		
		return JacksonUtil.bean2Json(recruit2);
	}

	@RequestMapping(value="/clear", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String clear() throws JsonProcessingException{
		
		recruitService.clear();
		
		Status status=new Status();
		
		status.setStatusCode(1);
		status.setMessage("数据清空成功");
		return JacksonUtil.bean2Json(status);
		
	}
}
