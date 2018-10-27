package cn.wuzongbo.tes.service;

import java.util.List;


import cn.wuzongbo.tes.po.Student;
import cn.wuzongbo.tes.po.StudentExample;
/**
 * 

* <p>Title: StudentService</p>  

* <p>Description:ѧ������ӿ� </p>  

* @author ���ڲ�  

* @date 2018��3��12��
 */
public interface StudentService {
	/**
	 * 
	 * <p>Title: login</p>  
	 * <p>Description:ѧ����¼ </p>  
	 * @param studentNO ѧ��
	 * @param password ����
	 * @return  true|false
	 * @throws Exception
	 */
	public Student login(String studentNO ,String password) throws Exception;
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
	 * @param password ѧ������
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int resetPassword(String password,Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: queryStudentList</p>  
	 * <p>Description:��ѯѧ�� </p>  
	 * @param studentExample ��ѯ��
	 * @return ����
	 * @throws Exception
	 */
	public List<Student> queryStudentList(StudentExample studentExample) throws Exception;
	
	/**
	 * 
	 * <p>Title: findStudentById</p>  
	 * <p>Description:����ѧ��ʵ�� </p>  
	
	 * @param id ����Ա���
	 * @return Studentʵ��
	 * @throws Exception
	 */
	public Student findStudentById(Integer id) throws Exception;
	
	/**
	 * 
	 * <p>Title: deteteStudentById</p>  
	
	 * <p>Description: ɾ��ѧ��</p>  
	
	 * @param id ���
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int deteteStudentById(Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: updateStudentById</p>  
	
	 * <p>Description: ����ѧ��</p>  	
	 * @param id  ���
	 * @param student ʵ��
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int updateStudentById(Integer id,Student student) throws Exception;
	/**
	 * 
	 * <p>Title: insertStudent</p>  
	
	 * <p>Description:���ѧ�� </p>  
	
	 * @return��Ӱ�������
	 * @throws Exception
	 */
	public int insertStudent(Student student) throws Exception;
	

}
