package cn.wuzongbo.tes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wuzongbo.tes.po.Department;
import cn.wuzongbo.tes.po.DepartmentExample;
import cn.wuzongbo.tes.po.User;
import cn.wuzongbo.tes.po.UserExample;
import cn.wuzongbo.tes.service.DepartmentService;
import cn.wuzongbo.tes.service.UserService;
import cn.wuzongbo.tes.util.MD5Util;

/**
 * 

* <p>Title: AdviserController</p>  

* <p>Description:班主任控制类 </p>  

* @author 吴宗波  

* @date 2018年6月14日
 */
@Controller
@RequestMapping("/adviser")
public class AdviserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private DepartmentService DepartmentService;
	@RequestMapping("/index.do")
	public String queryAdviserList(Model model,@RequestParam(required=true,defaultValue="1") Integer page,User user) throws Exception{	
		
		//获取部门
		List<Department> departments=DepartmentService.queryDepartmentList(null);
		
		PageHelper.startPage(page, 10);
		UserExample userExample=new UserExample();
		UserExample.Criteria criteria=userExample.createCriteria();
		criteria.andTypeEqualTo((byte)4);
		
		if(user.getUserno()!=""&&user.getUserno()!=null){
			
			criteria.andUsernoLike("%"+user.getUserno()+"%");
		}
		if(user.getUsername()!=null&&user.getUsername()!=""){
			
			criteria.andUsernameLike("%"+user.getUsername()+"%");
			
		}
//		
		List<User> adviserList=userService.queryUserList(userExample);
//		
		PageInfo<User> pageInfo=new PageInfo<User>(adviserList);
		model.addAttribute("page", pageInfo);
		model.addAttribute("adviserList", adviserList);
		model.addAttribute("departments", departments);
		
		return "admin/adviser/list";
		
	}
	@RequestMapping("/toedit.do")
	public String toedit(Model model,Integer id) throws Exception{
		DepartmentExample departmentExample=new DepartmentExample();
		DepartmentExample.Criteria criteria=departmentExample.createCriteria();
		criteria.andTypeEqualTo("处室");
		List<Department> departList=DepartmentService.queryDepartmentList(departmentExample);
		if(id!=null){
			User adviser=userService.findUserById(id);
			
			model.addAttribute("adviser", adviser);
			
		}
		model.addAttribute("departList", departList);
		return "admin/adviser/edit";
		
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
