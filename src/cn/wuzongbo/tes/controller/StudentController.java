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
import com.qcloud.cos.utils.Jackson;

import cn.wuzongbo.tes.exception.CustomException;
import cn.wuzongbo.tes.po.Classes;
import cn.wuzongbo.tes.po.ClassesExample;
import cn.wuzongbo.tes.po.Department;
import cn.wuzongbo.tes.po.DepartmentAndClassesVo;
import cn.wuzongbo.tes.po.DepartmentExample;
import cn.wuzongbo.tes.po.Status;
import cn.wuzongbo.tes.po.Student;
import cn.wuzongbo.tes.po.StudentExample;
import cn.wuzongbo.tes.po.User;
import cn.wuzongbo.tes.po.UserExample;
import cn.wuzongbo.tes.service.ClassesService;
import cn.wuzongbo.tes.service.DepartmentService;
import cn.wuzongbo.tes.service.StudentService;
import cn.wuzongbo.tes.service.UserService;
import cn.wuzongbo.tes.util.JacksonUtil;
import cn.wuzongbo.tes.util.MD5Util;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private DepartmentService DepartmentService;
	@Autowired
	private UserService userService;
	@Autowired
	private ClassesService classesService;
	@RequestMapping("/index.do")
	public String queryStudentList(Model model, @RequestParam(required = true, defaultValue = "1") Integer page,
			User user) throws Exception {
		List<DepartmentAndClassesVo> departmentAndClassesVos=DepartmentService.queryDepartAndClasses();
		model.addAttribute("departmentAndClassesVos", departmentAndClassesVos);
		UserExample userExample=new UserExample();
		UserExample.Criteria criteria=userExample.createCriteria();
		criteria.andTypeEqualTo((byte)1);
		criteria.andStatusEqualTo((byte)1);
	
		if(user.getClassesid()!=null&&user.getClassesid()>0){
			
			criteria.andClassesidEqualTo(user.getClassesid());
			
		}
		if(user.getUserno()!=null&&user.getUserno()!=""){
		
			criteria.andUsernoLike("%"+user.getUserno()+"%");
			
		}
		if(user.getUsername()!=null&&user.getUsername()!=""){
			
			criteria.andUsernameLike("%"+user.getUsername()+"%");
		}
		PageHelper.startPage(page, 20);
		List<User> users=userService.queryUserList(userExample);
	
		PageInfo<User> pageInfo = new PageInfo<User>(users);
		
		model.addAttribute("page", pageInfo);
		model.addAttribute("studentList", users);
		return "admin/student/list";

	}

	@RequestMapping("/toedit.do")
	public String toedit(Model model, Integer id) throws Exception {
		DepartmentExample departmentExample=new DepartmentExample();
		
		DepartmentExample.Criteria criteria=departmentExample.createCriteria();
		criteria.andTypeEqualTo("ѧԺ");
		List<Department> departList = DepartmentService.queryDepartmentList(departmentExample);
		List<Classes> classesList = classesService.queryClassesList(null);
		if (id != null) {

			User user = userService.findUserById(id);
			model.addAttribute("student", user);
		}
		model.addAttribute("departList", departList);
		model.addAttribute("classesList", classesList);
		return "admin/student/edit";

	}

	@RequestMapping("/edit.do")
	public String edit(Integer id, User user) throws Exception {

		if (id != null) {
			userService.updateUserById(id, user);
		} else {
			
			String password=MD5Util.MD5(user.getUserno()+"88888888");
			user.setPassword(password);
			userService.insertUser(user);

		}

		return "redirect:index.do";

	}

	@RequestMapping("/delete.do")
	public String delete(Integer id) throws Exception {
		userService.deteteUserById(id);
		return "redirect:index.do";

	}

	@RequestMapping("/queryClasses.do")
	@ResponseBody
	public List<Classes> queryClasses(@RequestParam(value = "departId") Integer departId) throws Exception {

		// System.out.println(departId);
		ClassesExample classesExample = new ClassesExample();
		ClassesExample.Criteria criteria = classesExample.createCriteria();
		criteria.andDepartIdEqualTo(departId);
		return classesService.queryClassesList(classesExample);
		// return null;
	}

}
