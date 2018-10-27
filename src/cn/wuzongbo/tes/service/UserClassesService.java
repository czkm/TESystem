package cn.wuzongbo.tes.service;

import java.util.List;

import cn.wuzongbo.tes.po.ClassesAndUserVo;
import cn.wuzongbo.tes.po.Teacherclasses;
import cn.wuzongbo.tes.po.TeacherclassesExample;
import cn.wuzongbo.tes.po.User;
import cn.wuzongbo.tes.po.UserClasses;
import cn.wuzongbo.tes.po.UserClassesExample;

/**
 * 
* <p>Title: TeacherclassesService</p>  

* <p>Description: 教师班级服务接口</p>  

* @author 吴宗波  

* @date 2018年3月12日
 */
public interface UserClassesService {
	
	/**
	 * 
	 * <p>Title: queryUserClassesList</p>  
	 * <p>Description:查询用户班级信息 </p>  
	 * @param userClassesExample 查询类
	 * @return 集合
	 * @throws Exception
	 */
	public List<UserClasses> queryUserClassesList(UserClassesExample userClassesExample) throws Exception;
	
	/**
	 * 
	 * <p>Title: findUserClassesById</p>  
	 * <p>Description:查找用户班级实例 </p>  
	
	 * @param id 编号
	 * @return UserClasses实例
	 * @throws Exception
	 */
	public UserClasses findUserClassesById(Integer id) throws Exception;
	
	/**
	 * 
	 * <p>Title: deteteUserClassesById</p>  
	
	 * <p>Description: 删除用户班级编号</p>  
	
	 * @param id 编号
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int deteteUserClassesById(Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: deteteUserClassesById</p>  
	
	 * <p>Description: 删除用户班级编号</p>  
	
	 * @param id 编号
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int deteteUserClasses(UserClassesExample userClassesExample) throws Exception;
	/**
	 * 
	 * <p>Title: updateUserClassesById</p>  
	
	 * <p>Description: 更新用户班级</p>  	
	 * @param id  编号
	 * @param userClasses 实例
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int updateUserClassesById(Integer id,UserClasses userClasses) throws Exception;
	/**
	 * 
	 * <p>Title: insertStudent</p>  
	
	 * <p>Description:添加学生 </p>  
	
	 * @return受影响的行数
	 * @throws Exception
	 */
	public int insertUserClasses(UserClasses userClasses) throws Exception;
	
	/**
	 * 
	
	 * <p>Title: queryUserListByClassesId</p>  
	
	 * <p>Description:通过用户classesId获取User </p>  
	
	 * @param classesId教室编号，用户编号
	 * @return 用户集合
	 * @throws Exception
	 */
	public List<User> queryUserListByClassesId(Integer classesId) throws Exception;
	
}
