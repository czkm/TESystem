package cn.wuzongbo.tes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import cn.wuzongbo.tes.mapper.ClassCourseMapper;
import cn.wuzongbo.tes.po.ClassCourse;
import cn.wuzongbo.tes.po.ClassCourseExample;
import cn.wuzongbo.tes.po.ClassCourseVo;
import cn.wuzongbo.tes.po.Classes;
import cn.wuzongbo.tes.po.ClassesExample;
import cn.wuzongbo.tes.service.ClassCourseService;
import cn.wuzongbo.tes.service.ClassesService;
import cn.wuzongbo.tes.util.JacksonUtil;

/**
 * @author ������
 * NO�� 35
 *2018��8��7��
 */
/*@Controller
@RequestMapping("/classcourse")
public class ClassCourseController {
	@Autowired
	private ClassCourseService classCourseService;
	@Autowired
	private ClassesService classesService;
	@RequestMapping("/index.do")
	public String selectByExample(Model model,ClassCourse classCourse) throws Exception{
		ClassCourseExample example=new ClassCourseExample();
		ClassCourseExample.Criteria criteria = example.createCriteria();
		if(classCourse.getClassid()!=null){
			criteria.andClassidEqualTo(classCourse.getClassid());
			Integer classid = classCourse.getClassid();
			Classes classes = classesService.findClassesById(classid);
			model.addAttribute("classes", classes);
			
		}
		criteria.andStatusEqualTo((byte)1);
		List<ClassCourseVo> classCourseList = classCourseService.selectOtherNamefromOtherTable();
		model.addAttribute("classCourseList", classCourseList);
		return "admin/classcourse/list";
		
	}
	
	@RequestMapping("deleteclasscourse.do")
	public String deleteByPrimaryKey(ClassCourse classCourse){
		Integer id = classCourse.getId();
		classCourseService.deleteByPrimaryKey(id);
		return "redirect:selectclasscourse.do";
		
	}
	
	@RequestMapping("toeditclasscourse.do")
	public String toedit(Model model,ClassCourse classCourse) {
		if(classCourse.getId()!=null){
			ClassCourse classCo = classCourseService.selectByPrimaryKey(classCourse.getClassid());
			model.addAttribute("classCo", classCo);
		}
		return "admin/classcourse/edit";
		
	}
	

}*/

@Controller
@RequestMapping("/classcourse")
public class ClassCourseController {
	@Autowired
	private ClassCourseService classCourseService;
	@RequestMapping("/index.do")
	public String selectByExample(Model model,ClassCourseVo classCourseVo) throws Exception{
	
		if(classCourseVo.getClassname()!=null){
			List<ClassCourseVo> classCourseList = classCourseService.selectOtherNamefromOtherTablename(classCourseVo.getClassname());
			model.addAttribute("classCourseList", classCourseList);
		} else {
		List<ClassCourseVo> classCourseList = classCourseService.selectOtherNamefromOtherTable();
		model.addAttribute("classCourseList", classCourseList);
	}
		return "admin/classcourse/list";
		
	}
	
	@RequestMapping("delete.do")
	public String deleteByPrimaryKey(ClassCourse classCourse){
		Integer id = classCourse.getId();
		classCourseService.deleteByPrimaryKey(id);
		return "redirect:index.do";
		
	}
	
	@RequestMapping("toedit.do")
	public String toedit(Model model,ClassCourseVo classCourseVo) {
		if(classCourseVo.getId()!=null){
			ClassCourse classCourse = classCourseService.selectByPrimaryKey(classCourseVo.getId()); 
			model.addAttribute("classCourse", classCourse);
		}
		return "admin/classcourse/edit";
	}
	@RequestMapping("edit")
	public String edit(ClassCourse classCourse) {
		if(classCourse.getId()>0){
			classCourseService.updateByPrimaryKeySelective(classCourse);
		} else {
			classCourseService.insert(classCourse);
		}
		return "redirect:index.do";
	}

	@RequestMapping(value="changestatus.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String changestatus(ClassCourseVo classCourseVo) throws JsonProcessingException {
		classCourseService.updateByPrimaryKeySelective(classCourseVo);
		return JacksonUtil.bean2Json(classCourseVo);
		
	}
}
