package cn.wuzongbo.tes.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wuzongbo.tes.po.QueryAllTeacherGetScoreVO;
import cn.wuzongbo.tes.po.QueryClassesRateofStudentSubmit;
import cn.wuzongbo.tes.po.User;
import cn.wuzongbo.tes.po.UserExample;
import cn.wuzongbo.tes.po.queryBetweenTeacherScoreVo;

public interface UserService {
	/**
	 * 
	 * <p>Title: login</p>  
	 * <p>Description:用户登录 </p>  
	 * @param userNo 学号/工号
	 * @param password 密码
	 * @return  用户实例
	 * @throws Exception
	 */
	public User login(String userNo ,String password) throws Exception;
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
	 * @param password 密码
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int resetPassword(String password,Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: queryUserList</p>  
	 * <p>Description:查询用户信息 </p>  
	 * @param UserExample 查询类
	 * @return 集合
	 * @throws Exception
	 */
	public List<User> queryUserList(UserExample userExample) throws Exception;
	
	/**
	 * 
	 * <p>Title: findUserById</p>  
	 * <p>Description:查找用户实例 </p>  
	
	 * @param id 管理员编号
	 * @return User实例
	 * @throws Exception
	 */
	public User findUserById(Integer id) throws Exception;
	
	/**
	 * 
	 * <p>Title: deteteStudentById</p>  
	
	 * <p>Description: 删除用户</p>  
	
	 * @param id 编号
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int deteteUserById(Integer id) throws Exception;
	
	
	/**
	 * 
	 * <p>Title: deteteStudentById</p>  
	
	 * <p>Description: 删除用户</p>  
	
	 * @param id 编号
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int deteteUser(UserExample userExample) throws Exception;
	/**
	 * 
	 * <p>Title: updateUserById</p>  
	
	 * <p>Description: 更新用户</p>  	
	 * @param id  编号
	 * @param user 实例
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int updateUserById(Integer id,User user) throws Exception;
	/**
	 * 
	 * <p>Title: insertStudent</p>  
	
	 * <p>Description:添加用户</p>  
	
	 * @return受影响的行数
	 * @throws Exception
	 */
	public int insertUser(User user) throws Exception;
	
	/**
	 * 
	 * <p>Title: checkUserno</p>  
	
	 * <p>Description: 检查工号或则学号是否存在</p>  
	
	 * @param userno
	 * @return long
	 * @throws Exception
	 */
	public long checkUserno(String userno) throws Exception;
	
	
	/**
	 * 
	
	 * <p>Title: resetPassword</p>  
	
	 * <p>Description: 根据用户编号修改密码</p>  
	
	 * @param id
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public int resetPassword(int id,String userno) throws Exception;
	
	/**
	 * 
	
	 * <p>Title: selectByClassesIdAndTeacherId</p>  
	
	 * <p>Description: 未提交学生信息</p>  
	
	 * @param classesId班级编号
	 * @param teacherId教师编号
	 * @return
	 */
	
	public List<User> selectByClassesIdAndTeacherId(@Param("classesId") Integer classesId, @Param("teacherId") Integer teacherId);
	
	/**
	 * 
	
	 * <p>Title: selectStudentOfClassesByClassesIdAndTeacherId</p>  
	
	 * <p>Description:已经提交的学生的信息 </p>  
	
	 * @param classesId 班级
	 * @param teacherId 教师编号
	 * @return
	 */
	
	public List<User> selectStudentOfClassesByClassesIdAndTeacherId(@Param("classesId") Integer classesId, @Param("teacherId") Integer teacherId);
	
	
	/**
	 * 
	
	 * <p>Title: changeDepart</p>  
	
	 * <p>Description: 更新部门</p>  
	
	 * @param userId 用户编号
	 * @param departId 部门编号
	 * @return long
	 * @throws Exception
	 */
	public int changeDepart(Integer userId,Integer departId) throws Exception;
	
	
	
	/**
	 * 
	
	 * <p>Title: changeStatus</p>  
	
	 * <p>Description:更新用户状态 </p>  
	
	 * @param userId//用户编号
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public int changeStatus(Integer userId,Integer status) throws Exception;
	
	
	/**
	 * 
	
	 * <p>Title: selectTeacherGetAllAssessScorce</p>  
	
	 * <p>Description:获取所有教师的测评分数 </p>  
	
	 * @return 
	 */
     public	List<QueryAllTeacherGetScoreVO> selectTeacherGetAllAssessScorce();
     
     
     
     
     /**
      * 
     
      * <p>Title: selectTeacherClassesRateofStudentSubmit</p>  
     
      * <p>Description:查询 教师授课班级学生提交率</p>  
     
      * @return
      */
     public List<QueryClassesRateofStudentSubmit> selectTeacherClassesRateofStudentSubmit();
     
     /**
      * 
     
      * <p>Title: selectBetweenTeacherScore</p>  
     
      * <p>Description: 获得</p>  
     
      * @return
      */
     public  List<QueryAllTeacherGetScoreVO> selectBetweenTeacherScore();
	
	
	
	
}
