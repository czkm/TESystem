package cn.wuzongbo.tes.service;

import java.util.List;

import cn.wuzongbo.tes.po.ClassesAndTeacherVo;
import cn.wuzongbo.tes.po.Teacherclasses;
import cn.wuzongbo.tes.po.TeacherclassesExample;

/**
 * 
* <p>Title: TeacherclassesService</p>  

* <p>Description: ��ʦ�༶����ӿ�</p>  

* @author ���ڲ�  

* @date 2018��3��12��
 */
public interface TeacherclassesService {
	
	/**
	 * 
	 * <p>Title: queryStudentList</p>  
	 * <p>Description:��ѯѧ�� </p>  
	 * @param studentExample ��ѯ��
	 * @return ����
	 * @throws Exception
	 */
	public List<Teacherclasses> queryTeacherclassesList(TeacherclassesExample teacherExample) throws Exception;
	
	/**
	 * 
	 * <p>Title: findStudentById</p>  
	 * <p>Description:����ѧ��ʵ�� </p>  
	
	 * @param id ���
	 * @return Teacherʵ��
	 * @throws Exception
	 */
	public Teacherclasses findTeacherclassesById(Integer id) throws Exception;
	
	/**
	 * 
	 * <p>Title: deteteStudentById</p>  
	
	 * <p>Description: ɾ��ѧ��</p>  
	
	 * @param id ���
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int deteteTeacherclassesById(Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: updateStudentById</p>  
	
	 * <p>Description: ����ѧ��</p>  	
	 * @param id  ���
	 * @param Teacher ʵ��
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int updateTeacherclassesById(Integer id,Teacherclasses teacherclasses) throws Exception;
	/**
	 * 
	 * <p>Title: insertStudent</p>  
	
	 * <p>Description:���ѧ�� </p>  
	
	 * @return��Ӱ�������
	 * @throws Exception
	 */
	public int insertTeacherclasses(Teacherclasses teacherclasses) throws Exception;
	
	/**
	 * 
	
	 * <p>Title: queryTeacherListByClassesId</p>  
	
	 * <p>Description:ͨ���û�classesId��ȡClassesAndTeacherVo��װ�� </p>  
	
	 * @param classesId���ұ��
	 * @return ClassesAndTeacherVo
	 * @throws Exception
	 */
	public ClassesAndTeacherVo queryTeacherListByClassesId(Integer classesId) throws Exception;
	

}
