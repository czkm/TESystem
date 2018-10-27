package cn.wuzongbo.tes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wuzongbo.tes.po.Course;
import cn.wuzongbo.tes.po.CourseExample;
import cn.wuzongbo.tes.po.Department;
import cn.wuzongbo.tes.po.DepartmentExample;
import cn.wuzongbo.tes.po.Status;
import cn.wuzongbo.tes.po.User;
import cn.wuzongbo.tes.service.CourseService;
import cn.wuzongbo.tes.util.JacksonUtil;
import cn.wuzongbo.tes.util.MD5Util;



@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
//	//添加商品信息
//		@RequestMapping("/add")
//		public String add() throws Exception{
//					
//			return "items/addItems";	    				
//		}
//		@RequestMapping("/addItems")
//		public String addItems(Items items) throws Exception{
//			itemsService.insert(items);		
//			return "redirect:queryItems.action";	    				
//		}
    //查询所有课程
	@RequestMapping("/index.do")
	public String index(Model model,Course course) throws Exception{
		CourseExample courseExample=new CourseExample();
		CourseExample.Criteria criteria=courseExample.createCriteria();
		courseExample.setDistinct(true);
		//定义查询条件为status=1的所有课程
		//criteria.andStatusEqualTo((byte)1);
		if(course.getCoursename()!=null&&course.getCoursename()!=""){
			criteria.andCoursenameLike("%"+course.getCoursename()+"%");
		}
		if(course.getCoursecode()!=null&&course.getCoursecode()>0){
			criteria.andCoursecodeEqualTo(course.getCoursecode());
		}
		if(course.getScore()!=null&&course.getScore()>0){
			criteria.andScoreEqualTo(course.getScore());
		}
		List<Course> allCourse=courseService.selectCourseName(courseExample);
		model.addAttribute("allCourse", allCourse);
		
		return "admin/course/demo";
		//return "admin/course/";
		
	}
	@RequestMapping(value="/changestatus.do")
	public String changeStatus(Course record) throws Exception{
		courseService.updateByPrimaryKeySelective(record);
		
          // int row=userService.changeStatus(userId, status1);
			
		/*	if(row>0){				
				status=new Status();
				status.setStatusCode(1);
				status.setMessage("�û�״̬���ĳɹ�,�����µ�¼");
			}
			else{			
				status=new Status();
				status.setStatusCode(2);
				status.setMessage("�û�״̬����ʧ�ܣ�����ϵ����Ա");
			}	*/										
			return "redirect:index.do";
		
	}
	@RequestMapping("/toedit")
	public String toedit(Model model,Integer id) throws Exception{
		CourseExample courseExample=new CourseExample();
		CourseExample.Criteria criteria=courseExample.createCriteria();
		criteria.andIdEqualTo(id);
		Course course=courseService.findCourseById(id);
		System.out.println(id);
		
		model.addAttribute("course", course);
		return "admin/course/edit";
		
	}
	/*@RequestMapping("/edit.do")
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
		
	}*/
	
	
	//插入课程信息
	@RequestMapping("/add")
	public String add() throws Exception{
		
		return "admin/course/edit";	    				
	}
	@RequestMapping("/toedit.do")
	public String addCourse(Course course) throws Exception{
		courseService.insertCourse(course);
		System.out.println("sss");
		return "redirect:index.do";
		
	}
	//删除课程信息
	@RequestMapping("/delete.do")
	public String deleteByID(Integer id) throws Exception{
		courseService.deleteById(id);
		
		
		return "redirect:index.do";	    				
	}
	
}
