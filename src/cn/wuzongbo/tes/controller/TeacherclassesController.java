package cn.wuzongbo.tes.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.wuzongbo.tes.exception.CustomException;
import cn.wuzongbo.tes.po.DepartmentAndClassesVo;
import cn.wuzongbo.tes.po.Teacherclasses;
import cn.wuzongbo.tes.service.DepartmentService;
import cn.wuzongbo.tes.service.TeacherclassesService;

@Controller
@RequestMapping("/teacherclasses")
public class TeacherclassesController {
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private TeacherclassesService teacherclassesService;
	@RequestMapping("/index")
	public String index(){
		
		
		return "admin/teacherclasses/list";
		
	}
	@RequestMapping("/toedit")
	public String toedit(Model model) throws Exception{
		List<DepartmentAndClassesVo> departmentAndClassesVos=departmentService.queryDepartAndClasses();
		
		model.addAttribute("departmentAndClassesVos", departmentAndClassesVos);
		return "admin/teacherclasses/edit";
		
	}
	@RequestMapping("/edit")
	public String edit(@RequestParam("classesIds") Integer[] classesIds,Integer id,Teacherclasses teacherclasses) throws Exception{
	if(id!=null){
		for(Integer classesId:classesIds){
			teacherclasses.setCeatetime(new Date());
			teacherclasses.setTeacherId(1);
			teacherclasses.setClassesId(classesId);
		
			int row=	teacherclassesService.updateTeacherclassesById(id, teacherclasses);
		}
		
	}
	else{
		
		for(Integer classesId:classesIds){
			teacherclasses.setCeatetime(new Date());
			teacherclasses.setTeacherId(1);
			teacherclasses.setClassesId(classesId);
		
			int row=	teacherclassesService.insertTeacherclasses(teacherclasses);
		}
		
	}
			
	
	
		
		return "admin/teacherclasses/list";
		
	}

}
