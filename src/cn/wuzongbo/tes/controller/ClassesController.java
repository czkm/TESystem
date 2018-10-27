package cn.wuzongbo.tes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wuzongbo.tes.po.Classes;
import cn.wuzongbo.tes.po.ClassesExample;
import cn.wuzongbo.tes.po.Department;
import cn.wuzongbo.tes.po.DepartmentExample;
import cn.wuzongbo.tes.po.Status;
import cn.wuzongbo.tes.service.ClassesService;
import cn.wuzongbo.tes.service.DepartmentService;
import cn.wuzongbo.tes.util.JacksonUtil;

@Controller
@RequestMapping("/classes")
public class ClassesController {
	@Autowired
	private ClassesService classesService;
	@Autowired
	private DepartmentService departmentService;

	@RequestMapping("/index.do")
	public String index(Model model, @RequestParam(required = true, defaultValue = "1") Integer page, Classes classes)
			throws Exception {
        DepartmentExample departmentExample=new DepartmentExample();
        DepartmentExample.Criteria departCriteria=departmentExample.createCriteria();
        departCriteria.andTypeEqualTo("学院");
		List<Department> departList = departmentService.queryDepartmentList(departmentExample);
		PageHelper.startPage(page, 20);// 这个要在开始位置，就是说在list之前定义
		ClassesExample classesExample = null;
		List<Classes> classesList=null;
		if (classes.getDepartId() != null&&classes.getDepartId()>0) {
			classesExample = new ClassesExample();
			ClassesExample.Criteria criteria = classesExample.createCriteria();
			criteria.andDepartIdEqualTo(classes.getDepartId());

		}
		if (classes.getClassesName() != null && classes.getClassesName() != "") {
			classesExample = new ClassesExample();
			ClassesExample.Criteria criteria = classesExample.createCriteria();
			criteria.andClassesNameLike("%" + classes.getClassesName() + "%");
		}

		 classesList = classesService.queryClassesList(classesExample);
		PageInfo<Classes> p = new PageInfo<Classes>(classesList);

		model.addAttribute("page", p);
		model.addAttribute("classesList", classesList);
		model.addAttribute("departList", departList);
		return "admin/classes/list";
	}

	@RequestMapping("/toedit.do")
	public String toedit(Model model, Integer id) throws Exception {

		List<Department> departList = departmentService.queryDepartmentList(null);
		if (id != null) {
			Classes classes = classesService.findClassesById(id);

			model.addAttribute("classes", classes);
		}
		model.addAttribute("departList", departList);
		return "admin/classes/edit";

	}

	@RequestMapping("/edit.do")
	public String edit(Integer id, Classes classes) throws Exception {
		if (id != null) {

			classesService.updateClassesById(id, classes);

		} else {

			classesService.insertClasses(classes);
		}

		return "redirect:index.do";

	}

	@RequestMapping("/delete.do")
	public String detete(Integer id) throws Exception {

		if (id != null) {

			classesService.deteteClassesById(id);
		}

		return "redirect:index.do";

	}
	@RequestMapping(value = "/checkclassesname", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String checkClassesName(String classesName) throws Exception{
		
		Status status = null;
		long row=classesService.checkClassesName(classesName);
		if (row > 0) {

			status = new Status();
			status.setStatusCode(0);
			status.setMessage("班级名称重复，请重新填写");
		} else {

			status = new Status();
			status.setStatusCode(1);
			status.setMessage("班级名称不重复，请继续操作");
		}

		return JacksonUtil.bean2Json(status);
		
	}

}
