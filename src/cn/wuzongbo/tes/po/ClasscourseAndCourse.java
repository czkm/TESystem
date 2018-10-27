package cn.wuzongbo.tes.po;

import java.util.Date;

public class ClasscourseAndCourse extends ClassCourse{


    private Byte coursecode;

    private String coursename;
    
    private String classname;
    
    private String teachername;
    
    private Date starttime;
    
    

	public Date getStarttime() {
		return starttime;
	}



	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}



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



	public Byte getCoursecode() {
		return coursecode;
	}

	

	public void setCoursecode(Byte coursecode) {
		this.coursecode = coursecode;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
}
