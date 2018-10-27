package cn.wuzongbo.tes.service;

import java.util.List;


import cn.wuzongbo.tes.po.Student;
import cn.wuzongbo.tes.po.StudentExample;
import cn.wuzongbo.tes.po.Teacher;
import cn.wuzongbo.tes.po.TeacherExample;
/**
 * 

* <p>Title: TeacherService</p>  

* <p>Description: ��ʦ����ӿڣ�ͬ�У�</p>  

* @author ���ڲ�  

* @date 2018��3��12��
 */
public interface TeacherService {
	/**
	 * 
	 * <p>Title: login</p>  
	 * <p>Description:��ʦ��¼ </p>  
	 * @param teacherNo ����
	 * @param password ����
	 * @return  true|false
	 * @throws Exception
	 */
	public Teacher login(String teacherNo ,String password) throws Exception;
	/**
	 * 
	 * <p>Title: changePassword</p>  
	
	 * <p>Description:�޸����� </p>  
	 * @param newpassword ������
	 * @param oldpassword ������
	 * @param id ���
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int changePassword(String newpassword,String oldpassword,Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: resetPassword</p>  
	 * <p>Description:�������� </p>  
	 * @param id ���
	 * @param newpassword ������
	 * @param oldpassword ������
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int resetPassword(String password,Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: queryTeacherList</p>  
	 * <p>Description:��ѯѧ�� </p>  
	 * @param studentExample ��ѯ��
	 * @return ����
	 * @throws Exception
	 */
	public List<Teacher> queryTeacherList(TeacherExample teacherExample) throws Exception;
	
	/**
	 * 
	 * <p>Title: findTeacherById</p>  
	 * <p>Description:���ҽ�ʦʵ�� </p>  
	
	 * @param id ���
	 * @return Teacherʵ��
	 * @throws Exception
	 */
	public Teacher findTeacherById(Integer id) throws Exception;
	
	/**
	 * 
	 * <p>Title: deteteTeacherById</p>  
	
	 * <p>Description: ɾ����ʦ</p>  
	
	 * @param id ���
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int deteteTeacherById(Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: updateTeacherById</p>  
	
	 * <p>Description: ���½�ʦ</p>  	
	 * @param id  ���
	 * @param Teacher ʵ��
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int updateTeacherById(Integer id,Teacher teacher) throws Exception;
	/**
	 * 
	 * <p>Title: insertTeacher</p>  
	
	 * <p>Description:��ӽ�ʦ </p>  
	
	 * @return��Ӱ�������
	 * @throws Exception
	 */
	public int insertTeacher(Teacher teacher) throws Exception;
	

}
