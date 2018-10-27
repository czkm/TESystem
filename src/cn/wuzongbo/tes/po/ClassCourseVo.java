package cn.wuzongbo.tes.po;

public class ClassCourseVo extends ClassCourse{
    
	
	//class表中的  班级名
	private String classname;
	//user表中的   教师名
	private String teachername;
	//course表中的 课程名
	private String coursename;
	//course表中的 课程代码
	private Integer coursecode;
	
	//department表中的 部门名
	private String departName;
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getDepartname() {
		return departName;
	}
	public void setDepartname(String departname) {
		this.departName = departname;
	}
	public Integer getCoursecode() {
		return coursecode;
	}
	public void setCoursecode(Integer coursecode) {
		this.coursecode = coursecode;
	}
	
	
}
