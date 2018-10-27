package cn.wuzongbo.tes.service;

import java.util.List;

import cn.wuzongbo.tes.po.ClassesAndTeacherVo;
import cn.wuzongbo.tes.po.Teacherclasses;
import cn.wuzongbo.tes.po.TeacherclassesExample;

/**
 * 
* <p>Title: TeacherclassesService</p>  

* <p>Description: 教师班级服务接口</p>  

* @author 吴宗波  

* @date 2018年3月12日
 */
public interface TeacherclassesService {
	
	/**
	 * 
	 * <p>Title: queryStudentList</p>  
	 * <p>Description:查询学生 </p>  
	 * @param studentExample 查询类
	 * @return 集合
	 * @throws Exception
	 */
	public List<Teacherclasses> queryTeacherclassesList(TeacherclassesExample teacherExample) throws Exception;
	
	/**
	 * 
	 * <p>Title: findStudentById</p>  
	 * <p>Description:查找学生实例 </p>  
	
	 * @param id 编号
	 * @return Teacher实例
	 * @throws Exception
	 */
	public Teacherclasses findTeacherclassesById(Integer id) throws Exception;
	
	/**
	 * 
	 * <p>Title: deteteStudentById</p>  
	
	 * <p>Description: 删除学生</p>  
	
	 * @param id 编号
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int deteteTeacherclassesById(Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: updateStudentById</p>  
	
	 * <p>Description: 更新学生</p>  	
	 * @param id  编号
	 * @param Teacher 实例
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int updateTeacherclassesById(Integer id,Teacherclasses teacherclasses) throws Exception;
	/**
	 * 
	 * <p>Title: insertStudent</p>  
	
	 * <p>Description:添加学生 </p>  
	
	 * @return受影响的行数
	 * @throws Exception
	 */
	public int insertTeacherclasses(Teacherclasses teacherclasses) throws Exception;
	
	/**
	 * 
	
	 * <p>Title: queryTeacherListByClassesId</p>  
	
	 * <p>Description:通过用户classesId获取ClassesAndTeacherVo包装类 </p>  
	
	 * @param classesId教室编号
	 * @return ClassesAndTeacherVo
	 * @throws Exception
	 */
	public ClassesAndTeacherVo queryTeacherListByClassesId(Integer classesId) throws Exception;
	

}
