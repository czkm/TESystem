package cn.wuzongbo.tes.service;

import java.util.List;


import cn.wuzongbo.tes.po.Student;
import cn.wuzongbo.tes.po.StudentExample;
/**
 * 

* <p>Title: StudentService</p>  

* <p>Description:学生服务接口 </p>  

* @author 吴宗波  

* @date 2018年3月12日
 */
public interface StudentService {
	/**
	 * 
	 * <p>Title: login</p>  
	 * <p>Description:学生登录 </p>  
	 * @param studentNO 学号
	 * @param password 密码
	 * @return  true|false
	 * @throws Exception
	 */
	public Student login(String studentNO ,String password) throws Exception;
	/**
	 * 
	 * <p>Title: changePassword</p>  
	
	 * <p>Description:修改密码 </p>  
	 * @param newpassword 新密码
	 * @param oldpassword 旧密码
	 * @param id 编号
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int changePassword(String newpassword,String oldpassword,Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: resetPassword</p>  
	 * <p>Description:重置密码 </p>  
	 * @param id 编号
	 * @param password 学生密码
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int resetPassword(String password,Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: queryStudentList</p>  
	 * <p>Description:查询学生 </p>  
	 * @param studentExample 查询类
	 * @return 集合
	 * @throws Exception
	 */
	public List<Student> queryStudentList(StudentExample studentExample) throws Exception;
	
	/**
	 * 
	 * <p>Title: findStudentById</p>  
	 * <p>Description:查找学生实例 </p>  
	
	 * @param id 管理员编号
	 * @return Student实例
	 * @throws Exception
	 */
	public Student findStudentById(Integer id) throws Exception;
	
	/**
	 * 
	 * <p>Title: deteteStudentById</p>  
	
	 * <p>Description: 删除学生</p>  
	
	 * @param id 编号
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int deteteStudentById(Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: updateStudentById</p>  
	
	 * <p>Description: 更新学生</p>  	
	 * @param id  编号
	 * @param student 实例
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int updateStudentById(Integer id,Student student) throws Exception;
	/**
	 * 
	 * <p>Title: insertStudent</p>  
	
	 * <p>Description:添加学生 </p>  
	
	 * @return受影响的行数
	 * @throws Exception
	 */
	public int insertStudent(Student student) throws Exception;
	

}
