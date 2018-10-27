package cn.wuzongbo.tes.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.wuzongbo.tes.exception.CustomException;
import cn.wuzongbo.tes.po.DepartmentAndClassesVo;
import cn.wuzongbo.tes.po.TeacherExample;
import cn.wuzongbo.tes.po.Teacherclasses;
import cn.wuzongbo.tes.po.TeacherclassesExample;
import cn.wuzongbo.tes.po.User;
import cn.wuzongbo.tes.po.UserClasses;
import cn.wuzongbo.tes.po.UserClassesExample;
import cn.wuzongbo.tes.service.DepartmentService;
import cn.wuzongbo.tes.service.UserClassesService;
import cn.wuzongbo.tes.service.UserService;

@Controller
@RequestMapping("/userclasses")
public class UserClassesController {
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private UserClassesService userClassesService;
	@RequestMapping("/index.do")
	public String index(){
		
		
		return "admin/teacherclasses/list";
		
	}
	@RequestMapping("/toedit.do")
	public String toedit(HttpSession session, Model model) throws Exception{
		List<DepartmentAndClassesVo> departmentAndClassesVos=departmentService.queryDepartAndClasses();
		model.addAttribute("departmentAndClassesVos", departmentAndClassesVos);
		UserClassesExample userClassesExample=new UserClassesExample();
		UserClassesExample.Criteria criteria=userClassesExample.createCriteria();
		User user=(User)session.getAttribute("user");
		
		criteria.andUserIdEqualTo(user.getId());
		
		List<UserClasses> userClassesList=userClassesService.queryUserClassesList(userClassesExample);
		
		return "admin/teacherclasses/edit";
		
	}
	@RequestMapping("/edit.do")
	public String edit(@RequestParam("classesIds") Integer[] classesIds,Integer id,UserClasses userClasses) throws Exception{
	if(id!=null){
		for(Integer classesId:classesIds){
			userClasses.setCeatetime(new Date());
			userClasses.setId(id);
			userClasses.setClassesId(classesId);
		
			int row=	userClassesService.updateUserClassesById(id, userClasses);
		}
		
	}
	else{
		
		for(Integer classesId:classesIds){
			userClasses.setCeatetime(new Date());
			userClasses.setUserId(1);
			userClasses.setClassesId(classesId);
		
			int row=	userClassesService.insertUserClasses(userClasses);
		}
		
	}
			
	
	
		
		return "admin/teacherclasses/list";
		
	}

}
