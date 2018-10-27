package cn.wuzongbo.tes.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wuzongbo.tes.po.Admin;
import cn.wuzongbo.tes.po.AdminExample;
import cn.wuzongbo.tes.po.Status;
import cn.wuzongbo.tes.po.SystemModuleVo;
import cn.wuzongbo.tes.service.AdminService;
import cn.wuzongbo.tes.service.SystemModuleService;
import cn.wuzongbo.tes.util.JacksonUtil;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private SystemModuleService systemModuleService;
	@RequestMapping("/index.do")
	public String queryAdminsList(Model model,@RequestParam(required=true,defaultValue="1") Integer page,Admin admin) throws Exception{
		List<Admin> admins=null;
		AdminExample adminExample=null;
		if(admin.getLoginname()!=null){
		 adminExample=new AdminExample();	
		 AdminExample.Criteria criteria=adminExample.createCriteria();
		 criteria.andAdminNameLike("%"+admin.getLoginname());
		 
		}
		PageHelper.startPage(page, 10);//这个要在开始位置，就是说在list之前定义
		 admins=adminService.queryAdminsList(adminExample);
		PageInfo<Admin> p=new PageInfo<Admin>(admins);
		
		model.addAttribute("page", p);
		model.addAttribute("admins", admins);
		
		return "admin/admin/list";
		
	}
	@RequestMapping("/login")
	public String login(Model model,HttpSession session,@Validated Admin admin,BindingResult bindingResult) throws Exception{
		
	if(bindingResult.hasErrors()){
			
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			
			for(ObjectError objectError:allErrors){
				
				
				System.out.println(objectError.getDefaultMessage());
			}
			
			model.addAttribute("allErrors", allErrors);	

			return "admin/login";
			
		}
	
		
		 admin=adminService.login(admin.getLoginname(),admin.getPassword());
		if(admin!=null){
			
		    session.setAttribute("admin", admin);
		    
		    
		    //加载菜单
		    List<SystemModuleVo> systemModuleVoList=systemModuleService.findSystemModuleVo((short) 0);
		   //int size= systemModuleVoList.size();
		    model.addAttribute("menuList", systemModuleVoList);
			return "admin/index";
		}
		else{
			
			return "redirect:tologin";
		}
		
	}
	
	@RequestMapping("/tologin")
	public String tologin() throws Exception{
		
		
		
		return "admin/login";
	}
	@RequestMapping("/tologinout")
	public String toLoginOut(HttpSession session){
		
		if(session.getAttribute("admin")!=null){
			session.setAttribute("admin", null);
			
		}
		return "redirect:tologin";
		
	}
	
	@RequestMapping("/toedit.do")
	public String toedit(Model model,Integer id) throws Exception{
		if(id!=null){
			
			Admin admin=adminService.findAdminById(id);
		    model.addAttribute("admin", admin);
		    
			
		}
		
		
		return "admin/admin/edit";
		
	}
	@RequestMapping("/edit.do")
	public String edit(Integer id,Admin admin) throws Exception{
		
		if(id!=null){
	
			
			adminService.updateAdminById(id, admin);
		}
		else{
			
			admin.setPassword("88888888");//设置默认密码
			adminService.insertAdmin(admin);
		}
		
		return "redirect:index.do";
		
	}
	@RequestMapping("/delete.do")
	public String delete(Integer id) throws Exception{
		adminService.deteteAdminById(id);
		return "redirect:index.do";
		
	}
	@RequestMapping(value = "/checkadminname" ,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String checkAdminName(String loginname) throws Exception{
		
		Status status=null;
		
		long row=adminService.checkLoginname(loginname);
		
		if(row>0){
			
			status=new Status();
			status.setStatusCode(0);
			status.setMessage("登录名重复，请重新填写");
		}
		else{
			
			status=new Status();
			status.setStatusCode(1);
			status.setMessage("登录名不重复，请继续操作");
		}
		
		return JacksonUtil.bean2Json(status);
	}
	
	@RequestMapping(value = "/cahngestatus" ,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String cahngeStatus(int id,int status) throws Exception{
		
		Status status1=null;
		
		long row=adminService.changeStatus(id, (byte)status);
		
		if(row>0){
			
			status1=new Status();
			status1.setStatusCode(1);
			status1.setMessage("状态修改成功");
		}
		else{
			
			status1=new Status();
			status1.setStatusCode(0);
			status1.setMessage("状态修改失败");
		}
		
		return JacksonUtil.bean2Json(status1);
	}
	
	
}
