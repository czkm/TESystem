package cn.wuzongbo.tes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wuzongbo.tes.po.CriteriaClasses;
import cn.wuzongbo.tes.po.CriteriaClassesExample;
import cn.wuzongbo.tes.po.Status;
import cn.wuzongbo.tes.service.CriteriaClassesService;
import cn.wuzongbo.tes.util.JacksonUtil;

@Controller
@RequestMapping("/criteriaclasses")
public class CriteriaClassesController {
	@Autowired
	private CriteriaClassesService criteriaClassesService;
	@RequestMapping("/index.do")
	public String index(Model model) throws Exception{
		CriteriaClassesExample criteriaClassesExample=new CriteriaClassesExample();
		
		CriteriaClassesExample.Criteria criteria=criteriaClassesExample.createCriteria();
		criteria.andStatusEqualTo((byte)1);
		List<CriteriaClasses> criteriaClassesList=criteriaClassesService.query(criteriaClassesExample);
		model.addAttribute("criteriaClassesList", criteriaClassesList);
		return "admin/criteriaclasses/list";
		
	}
	@RequestMapping("/toedit.do")
	public String toedit(Model model,Integer id) throws Exception{
		
		if(id!=null){
			
		   CriteriaClasses criteriaClasses=	criteriaClassesService.getSinggle(id);
		   model.addAttribute("criteriaClasses", criteriaClasses);
			
		}
		
		return "admin/criteriaclasses/edit";
		

		
	}
	@RequestMapping("/edit.do")
	public String edit(Integer id,CriteriaClasses criteriaClasses) throws Exception{
		if(id!=null&&id>0){
			criteriaClassesService.update(criteriaClasses);
			
		}
		else{
			
			criteriaClassesService.insert(criteriaClasses);
		}
		
		return "redirect:index.do";
		
	}
	@RequestMapping("/delete.do")
	public String delete(Integer id) throws Exception{
		
		criteriaClassesService.delete(id);
		return "redirect:index.do";
	}
	
	
	/**
	 * 
	
	 * <p>Title: checkUserno</p>  
	
	 * <p>Description: 判断工号|学号是否重复</p>  
	
	 * @param userno
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/checkcriterianame" ,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String checkCriteriaName(String criteriaName) throws Exception{
		
		Status status=null;
		
		boolean row=criteriaClassesService.checkCriteriaName(criteriaName);
		
		if(row){
			status=new Status();
			status.setStatusCode(0);
			status.setMessage("评学标准重复，请重新填写");
		}
		else{
			
			status=new Status();
			status.setStatusCode(1);
			status.setMessage("评学标准不重复，请继续操作");
		}
		
		return JacksonUtil.bean2Json(status);
		
		
	}
	

}
