package cn.wuzongbo.tes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wuzongbo.tes.po.SystemModule;
import cn.wuzongbo.tes.po.SystemModuleExample;
import cn.wuzongbo.tes.po.SystemModuleVo;
import cn.wuzongbo.tes.service.SystemModuleService;


@Controller
@RequestMapping("/menu")
public class SystemModuleController {
	@Autowired
	private SystemModuleService systemModuleService;
	@RequestMapping("/index")
	public String querySystemModuleList(Model model,SystemModule systemModule) throws Exception{
		
		SystemModuleExample systemModuleExample=new SystemModuleExample();
		
		SystemModuleExample.Criteria criteria=systemModuleExample.createCriteria();
		if(systemModule.getTitle()!=null&&systemModule.getTitle()!=null){
			criteria.andTitleLike("%"+systemModule.getTitle()+"%");
			
		}
			
		List<SystemModuleVo> systemModuleList=systemModuleService.findSystemModuleVo((short) 0);
		model.addAttribute("menuList", systemModuleList);
		return "admin/menu/list";
		
	}
	@RequestMapping("/toedit")
	public String toedit(Model model,Short id,Short parentId) throws Exception{
		List<SystemModuleVo> systemModuleList=systemModuleService.findSystemModuleVo((short) 0);
		if(parentId!=null){
			
			SystemModule  systemModule=new SystemModule();
			systemModule.setParentId(parentId);
			model.addAttribute("module", systemModule);
				
		}
		
		if(id!=null){
			SystemModule  systemModule=systemModuleService.findSystemModuleById(id);
			
			model.addAttribute("module", systemModule);
			
		}
		model.addAttribute("menuList", systemModuleList);
		return "admin/menu/edit";
		
	}
	@RequestMapping("/edit")
	public String edit(Short id,SystemModule systemModule) throws Exception{
		
		if(id!=null){
			
			systemModuleService.updateSystemModuleById(id, systemModule);
		}
		else{
			
			systemModuleService.insertSystemModule(systemModule);
			
		}
		return "redirect:index";
		
	}
	@RequestMapping("/delete")
	public String delete(Short id) throws Exception{
		
		systemModuleService.deteteSystemModuleById(id);
		
		return "redirect:index";
		
	}


}
