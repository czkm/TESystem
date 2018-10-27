package cn.wuzongbo.tes.po;

import java.util.List;
/**
 * 

* <p>Title: ClassesAndTeacherVo</p>  

* <p>Description: 通过班级id获取teacher列表的包装类</p>  

* @author 吴宗波  

* @date 2018年4月14日
 */
public class ClassesAndTeacherVo extends Teacherclasses {
	
	private List<Teacher> teachers;

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	

}
