package cn.wuzongbo.tes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wuzongbo.tes.po.Department;
import cn.wuzongbo.tes.po.DepartmentExample;
import cn.wuzongbo.tes.po.Status;
import cn.wuzongbo.tes.po.User;
import cn.wuzongbo.tes.po.UserExample;
import cn.wuzongbo.tes.service.DepartmentService;
import cn.wuzongbo.tes.service.UserService;
import cn.wuzongbo.tes.util.JacksonUtil;
import cn.wuzongbo.tes.util.MD5Util;

@Controller
@RequestMapping("/enrol")
public class EnrolController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private DepartmentService DepartmentService;
	@RequestMapping("/index.do")
	public String queryTeacherList(Model model,User user) throws Exception{
	//招生办 type=5
		List<Department> departList=DepartmentService.queryDepartmentList(null);
		UserExample userExample=new UserExample();
		UserExample.Criteria criteria=userExample.createCriteria();
		criteria.andTypeEqualTo((byte)5);
		if(user.getDepartid()!=null&&user.getDepartid()>0){
			criteria.andDepartidEqualTo(user.getDepartid());
			
		}
		if(user.getUserno()!=""&&user.getUserno()!=null){
			
			criteria.andUsernoLike("%"+user.getUserno()+"%");
		}
		if(user.getUsername()!=null&&user.getUsername()!=""){
			
			criteria.andUsernameLike("%"+user.getUsername()+"%");
			
		}
	
		List<User> enrolList=userService.queryUserList(userExample);
	
		model.addAttribute("enrolList", enrolList);
		model.addAttribute("departList", departList);
		return "admin/enrol/list";
		
	}
	@RequestMapping("/toedit.do")
	public String toedit(Model model,Integer id) throws Exception{
	
		List<Department> departList=DepartmentService.queryDepartmentList(null);
		if(id!=null){
			User teacher=userService.findUserById(id);
			
			model.addAttribute("teacher", teacher);
			
		}
		model.addAttribute("departList", departList);
		return "admin/enrol/edit";
		
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
