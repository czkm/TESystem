package cn.wuzongbo.tes.po;
/**
 * 

* <p>Title: StudentAndClasses</p>  

* <p>Description:StudentAndClasses
* 通过包装类显示student和班级的信息
* 不使用表连接
*  </p>  

* @author 吴宗波  

* @date 2018年4月7日
 */
public class StudentAndClasses extends Student{
	
	private Classes classes;

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	

}
