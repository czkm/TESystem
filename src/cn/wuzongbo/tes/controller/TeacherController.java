package cn.wuzongbo.tes.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wuzongbo.tes.exception.CustomException;
import cn.wuzongbo.tes.po.Department;
import cn.wuzongbo.tes.po.DepartmentExample;
import cn.wuzongbo.tes.po.Status;
import cn.wuzongbo.tes.po.Student;
import cn.wuzongbo.tes.po.Teacher;
import cn.wuzongbo.tes.po.TeacherExample;
import cn.wuzongbo.tes.po.User;
import cn.wuzongbo.tes.po.UserExample;
import cn.wuzongbo.tes.service.DepartmentService;
import cn.wuzongbo.tes.service.TeacherService;
import cn.wuzongbo.tes.service.UserService;
import cn.wuzongbo.tes.util.JacksonUtil;
import cn.wuzongbo.tes.util.MD5Util;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	private UserService userService;
	@Autowired
	private DepartmentService DepartmentService;
	@RequestMapping("/index.do")
	public String queryTeacherList(Model model,@RequestParam(required=true,defaultValue="1") Integer page,User user) throws Exception{
		
		List<Department> departList=DepartmentService.queryDepartmentList(null);
		PageHelper.startPage(page, 10);
		UserExample userExample=new UserExample();
		UserExample.Criteria criteria=userExample.createCriteria();
		List<Byte> types=new ArrayList<>();
		types.add((byte)2);
		types.add((byte)24);
		
		criteria.andTypeIn(types);
		if(user.getDepartid()!=null&&user.getDepartid()>0){
			criteria.andDepartidEqualTo(user.getDepartid());
			
		}
		if(user.getUserno()!=""&&user.getUserno()!=null){
			
			criteria.andUsernoLike("%"+user.getUserno()+"%");
		}
		if(user.getUsername()!=null&&user.getUsername()!=""){
			
			criteria.andUsernameLike("%"+user.getUsername()+"%");
			
		}
//		
		List<User> teacherList=userService.queryUserList(userExample);
//		
		PageInfo<User> pageInfo=new PageInfo<User>(teacherList);
		model.addAttribute("page", pageInfo);
		model.addAttribute("teacherList", teacherList);
		model.addAttribute("departList", departList);
		return "admin/teacher/list";
		
	}
	@RequestMapping("/toedit.do")
	public String toedit(Model model,Integer id) throws Exception{
		DepartmentExample departmentExample=new DepartmentExample();
		DepartmentExample.Criteria criteria=departmentExample.createCriteria();
		criteria.andTypeEqualTo("学院");
		List<Department> departList=DepartmentService.queryDepartmentList(departmentExample);
		if(id!=null){
			User teacher=userService.findUserById(id);
			
			model.addAttribute("teacher", teacher);
			
		}
		model.addAttribute("departList", departList);
		return "admin/teacher/edit";
		
	}
	@RequestMapping("/edit.do")
	public String edit(Integer id,User user) throws Exception{
		
		if(id!=null){
			
			
			userService.updateUserById(id, user);
		}
		else{
			String password=MD5Util.MD5(user.getUserno()+"88888888");
			user.setPassword(password);
			userService.insertUser(user);
			
		}
		return "redirect:index.do";
		
	}
	@RequestMapping("/delete.do")
	public String delete(Integer id) throws Exception{
		
		userService.deteteUserById(id);
		
		return "redirect:index.do";
		
	}
	
	   //更改部门
		@RequestMapping(value = "/changedepart.do", produces = "text/html;charset=UTF-8")
		@ResponseBody
		public String checkdepartName(Integer teacherId, Integer departId) throws Exception{
			
			Status status = null;
			long row =userService.changeDepart(teacherId, departId);
			if (row > 0) {

				status = new Status();
				status.setStatusCode(1);
				status.setMessage("部门修改成功");
			} else {

				status = new Status();
				status.setStatusCode(0);
				status.setMessage("部门修改失败，请联系管理员");
			}

			return JacksonUtil.bean2Json(status);
			
		}
	

}
