package cn.wuzongbo.tes.po;
/**
 * 

* <p>Title: UserAndClasssesAndDepart</p>  

* <p>Description:通过用户查询班级和部门 </p>  

* @author 吴宗波  

* @date 2018年4月28日
 */
public class StudentAndClasssesAndDepart extends User {
	private Classes classes;//班级
	private Department department;//部门
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	

}
