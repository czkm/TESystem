package cn.wuzongbo.tes.controller;

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
import cn.wuzongbo.tes.po.Supervisor;
import cn.wuzongbo.tes.po.SupervisorExample;
import cn.wuzongbo.tes.po.User;
import cn.wuzongbo.tes.po.UserExample;
import cn.wuzongbo.tes.service.DepartmentService;
import cn.wuzongbo.tes.service.SupervisorService;
import cn.wuzongbo.tes.service.UserService;
import cn.wuzongbo.tes.util.JacksonUtil;
import cn.wuzongbo.tes.util.MD5Util;

@Controller
@RequestMapping("supervisor")
public class SupervisorController {
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
		criteria.andTypeEqualTo((byte)3);
		
		if(user.getDepartid()!=null&&user.getDepartid()>0){
			criteria.andDepartidEqualTo(user.getDepartid());
			
		}
		if(user.getUsername()!=null&&user.getUsername()!=null){
			
			criteria.andUsernameLike("%"+user.getUsername()+"%");
			
		}
		if(user.getUserno()!=null&&user.getUserno()!=""){
			
			criteria.andUsernoLike("%"+user.getUserno()+"%");
		}
//		
		List<User> userList=userService.queryUserList(userExample);
//		
		PageInfo<User> pageInfo=new PageInfo<User>(userList);
		model.addAttribute("page", pageInfo);
		model.addAttribute("supervisorList", userList);
		model.addAttribute("departList", departList);
		return "admin/supervisor/list";
		
	}
	@RequestMapping("/toedit.do")
	public String toedit(Model model,Integer id) throws Exception{
		
		List<Department> departList=DepartmentService.queryDepartmentList(null);
		if(id!=null){
			User user=userService.findUserById(id);
			model.addAttribute("supervisor", user);
			
		}
	
		model.addAttribute("departList", departList);
		return "admin/supervisor/edit";
		
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

}
