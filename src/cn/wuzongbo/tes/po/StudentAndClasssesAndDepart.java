package cn.wuzongbo.tes.po;
/**
 * 

* <p>Title: UserAndClasssesAndDepart</p>  

* <p>Description:ͨ���û���ѯ�༶�Ͳ��� </p>  

* @author ���ڲ�  

* @date 2018��4��28��
 */
public class StudentAndClasssesAndDepart extends User {
	private Classes classes;//�༶
	private Department department;//����
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
