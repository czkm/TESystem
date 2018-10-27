package cn.wuzongbo.tes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wuzongbo.tes.po.Department;
import cn.wuzongbo.tes.po.DepartmentExample;
import cn.wuzongbo.tes.po.Status;
import cn.wuzongbo.tes.service.DepartmentService;
import cn.wuzongbo.tes.util.JacksonUtil;

@Controller
@RequestMapping("/depart")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	@RequestMapping("/index.do")
	public String queryDeaprtList(Model model,Department department) throws Exception{
		List<Department> departList=null;
		DepartmentExample departmentExample=null;
		if(department.getDepartName()!=null){	
			departmentExample=new DepartmentExample();
			DepartmentExample.Criteria criteria=departmentExample.createCriteria();
			criteria.andDepartNameLike("%"+department.getDepartName()+"%");
			departList=departmentService.queryDepartmentList(departmentExample);	
		}
		
			
	    departList=departmentService.queryDepartmentList(departmentExample);
	
		
		model.addAttribute("list",departList);
		
		return "admin/department/list";
		
	}
	@RequestMapping("/toedit.do")
	public String toedit(Model model,Integer id) throws Exception{
		if(id!=null){
			
			Department department=departmentService.findDepartmentById(id);
			model.addAttribute("department", department);
		}
		return "admin/department/edit";
		
		
	}
	@RequestMapping("/edit.do")
	public String edit(Integer id,Department department) throws Exception{
		
		if(id!=null){
			departmentService.updateDepartmentById(id, department);
			
		}
		else{
			
			departmentService.insertDepartment(department);
			
		}
		
		
		return "redirect:index.do";
		
	}
	
	@RequestMapping("/delete.do")
	public String delete(Integer id) throws Exception{
		
		departmentService.deteteDepartmentById(id);
		
		return "redirect:index.do";
		
	}
	@RequestMapping(value = "/checkdepartname", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String checkdepartName(String departName) throws Exception{
		
		Status status = null;
		long row =departmentService.checkDepartName(departName);
		if (row > 0) {

			status = new Status();
			status.setStatusCode(0);
			status.setMessage("部门名称重复，请重新填写");
		} else {

			status = new Status();
			status.setStatusCode(1);
			status.setMessage("部门名称不重复，请继续操作");
		}

		return JacksonUtil.bean2Json(status);
		
	}
	

}
