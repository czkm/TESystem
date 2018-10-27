package cn.wuzongbo.tes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wuzongbo.tes.exception.CustomException;
import cn.wuzongbo.tes.po.Criteria;
import cn.wuzongbo.tes.po.CriteriaExample;
import cn.wuzongbo.tes.po.CriteriaVo;
import cn.wuzongbo.tes.po.Status;
import cn.wuzongbo.tes.service.CriteriaService;
import cn.wuzongbo.tes.util.JacksonUtil;

@Controller
@RequestMapping(value="/criteria")
public class CriteriaController {
	@Autowired
	private CriteriaService criteriaService;
	@RequestMapping("/index.do")
	public String index(Model model,Criteria criteria,@RequestParam(value="pid",defaultValue="1") Integer pid) throws Exception{
		List<CriteriaVo> criteriaVos=criteriaService.findCriteriaVo(0,null);
		CriteriaExample criteriaExample=new CriteriaExample();
		
		CriteriaExample.Criteria criteria1=criteriaExample.createCriteria();
		List<CriteriaVo> criteriaList=criteriaService.findCriteriaVo(pid,criteriaExample);;
		 if(criteria.getParentId()!=null){
			
			 criteriaList=criteriaService.findCriteriaVo(criteria.getParentId(),criteriaExample);
		}
		
	
		model.addAttribute("criteriaVos", criteriaVos);
		model.addAttribute("criteriaList", criteriaList);
		
		return "admin/criteria/list";
		
	}
	@RequestMapping("/toedit.do")
	public String toedit(Model model ,Criteria criteria) throws Exception{
		List<CriteriaVo>  criteriaVos=criteriaService.findCriteriaVo(0, null);
		if(criteria.getParentId()!=null){
			
			  model.addAttribute("criteria", criteria);
		}
		if(criteria.getId()!=null){
			
		   criteria=criteriaService.findCriteriaById(criteria.getId());
		  model.addAttribute("criteria", criteria);
		
		}
		model.addAttribute("criteriaVos", criteriaVos);
		return "admin/criteria/edit";
		
	}
	
	@RequestMapping("/edit.do")
	public String edit(Integer id,Criteria criteria) throws Exception{
		
		if(id!=null){
			
			criteriaService.updateCriteriaById(id, criteria);
			
			
		}
		else{
			
			criteriaService.insertCriteria(criteria);
		}
		
		
		return "forward:index.do?pid="+criteria.getParentId();
		
	}
	@RequestMapping("/delete.do")
	public String delete(Integer id) throws Exception{
		Criteria criteria=criteriaService.findCriteriaById(id);
		
	  //判断是否还有子项
	  List<Criteria> criteriaList=	criteriaService.queryCriteriaListByParentd(id);
	  if(criteriaList!=null&&criteriaList.size()>0){
		  new CustomException("还有子数据，不能够删除");
			
			
	  }
	  else{
		  
		  
		  criteriaService.deteteCriteriaById(id);
		  
		  
	  }
		return "forward:index.do?pid="+criteria.getParentId();
		
	}
	@RequestMapping(value = "/checkcriterianame", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String checkCriteriaName(String criteriaName) throws Exception{
		
		Status status = null;
		long row=criteriaService.checkCriteriaName(criteriaName);
		if (row > 0) {

			status = new Status();
			status.setStatusCode(0);
			status.setMessage("标准名称重复，请重新填写");
		} else {

			status = new Status();
			status.setStatusCode(1);
			status.setMessage("标准名称不重复，请继续操作");
		}

		return JacksonUtil.bean2Json(status);
	}
}
