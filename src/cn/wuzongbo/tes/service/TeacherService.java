package cn.wuzongbo.tes.service;

import java.util.List;


import cn.wuzongbo.tes.po.Student;
import cn.wuzongbo.tes.po.StudentExample;
import cn.wuzongbo.tes.po.Teacher;
import cn.wuzongbo.tes.po.TeacherExample;
/**
 * 

* <p>Title: TeacherService</p>  

* <p>Description: 教师服务接口（同行）</p>  

* @author 吴宗波  

* @date 2018年3月12日
 */
public interface TeacherService {
	/**
	 * 
	 * <p>Title: login</p>  
	 * <p>Description:教师登录 </p>  
	 * @param teacherNo 工号
	 * @param password 密码
	 * @return  true|false
	 * @throws Exception
	 */
	public Teacher login(String teacherNo ,String password) throws Exception;
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
	 * @param newpassword 新密码
	 * @param oldpassword 旧密码
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int resetPassword(String password,Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: queryTeacherList</p>  
	 * <p>Description:查询学生 </p>  
	 * @param studentExample 查询类
	 * @return 集合
	 * @throws Exception
	 */
	public List<Teacher> queryTeacherList(TeacherExample teacherExample) throws Exception;
	
	/**
	 * 
	 * <p>Title: findTeacherById</p>  
	 * <p>Description:查找教师实例 </p>  
	
	 * @param id 编号
	 * @return Teacher实例
	 * @throws Exception
	 */
	public Teacher findTeacherById(Integer id) throws Exception;
	
	/**
	 * 
	 * <p>Title: deteteTeacherById</p>  
	
	 * <p>Description: 删除教师</p>  
	
	 * @param id 编号
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int deteteTeacherById(Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: updateTeacherById</p>  
	
	 * <p>Description: 更新教师</p>  	
	 * @param id  编号
	 * @param Teacher 实例
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int updateTeacherById(Integer id,Teacher teacher) throws Exception;
	/**
	 * 
	 * <p>Title: insertTeacher</p>  
	
	 * <p>Description:添加教师 </p>  
	
	 * @return受影响的行数
	 * @throws Exception
	 */
	public int insertTeacher(Teacher teacher) throws Exception;
	

}
