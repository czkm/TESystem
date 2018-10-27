package cn.wuzongbo.tes.po;

import java.util.List;
/**
 * 

* <p>Title: ClassesAndUserVo</p>  

* <p>Description: 通过班级id获取User列表的包装类</p>  

* @author 吴宗波  

* @date 2018年4月14日
 */
public class ClassesAndUserVo extends Classes {
	
	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	

}
