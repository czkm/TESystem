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
	 * <p>Description:�û���¼ </p>  
	 * @param userNo ѧ��/����
	 * @param password ����
	 * @return  �û�ʵ��
	 * @throws Exception
	 */
	public User login(String userNo ,String password) throws Exception;
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
	 * @param password ����
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int resetPassword(String password,Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: queryUserList</p>  
	 * <p>Description:��ѯ�û���Ϣ </p>  
	 * @param UserExample ��ѯ��
	 * @return ����
	 * @throws Exception
	 */
	public List<User> queryUserList(UserExample userExample) throws Exception;
	
	/**
	 * 
	 * <p>Title: findUserById</p>  
	 * <p>Description:�����û�ʵ�� </p>  
	
	 * @param id ����Ա���
	 * @return Userʵ��
	 * @throws Exception
	 */
	public User findUserById(Integer id) throws Exception;
	
	/**
	 * 
	 * <p>Title: deteteStudentById</p>  
	
	 * <p>Description: ɾ���û�</p>  
	
	 * @param id ���
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int deteteUserById(Integer id) throws Exception;
	
	
	/**
	 * 
	 * <p>Title: deteteStudentById</p>  
	
	 * <p>Description: ɾ���û�</p>  
	
	 * @param id ���
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int deteteUser(UserExample userExample) throws Exception;
	/**
	 * 
	 * <p>Title: updateUserById</p>  
	
	 * <p>Description: �����û�</p>  	
	 * @param id  ���
	 * @param user ʵ��
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int updateUserById(Integer id,User user) throws Exception;
	/**
	 * 
	 * <p>Title: insertStudent</p>  
	
	 * <p>Description:����û�</p>  
	
	 * @return��Ӱ�������
	 * @throws Exception
	 */
	public int insertUser(User user) throws Exception;
	
	/**
	 * 
	 * <p>Title: checkUserno</p>  
	
	 * <p>Description: ��鹤�Ż���ѧ���Ƿ����</p>  
	
	 * @param userno
	 * @return long
	 * @throws Exception
	 */
	public long checkUserno(String userno) throws Exception;
	
	
	/**
	 * 
	
	 * <p>Title: resetPassword</p>  
	
	 * <p>Description: �����û�����޸�����</p>  
	
	 * @param id
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public int resetPassword(int id,String userno) throws Exception;
	
	/**
	 * 
	
	 * <p>Title: selectByClassesIdAndTeacherId</p>  
	
	 * <p>Description: δ�ύѧ����Ϣ</p>  
	
	 * @param classesId�༶���
	 * @param teacherId��ʦ���
	 * @return
	 */
	
	public List<User> selectByClassesIdAndTeacherId(@Param("classesId") Integer classesId, @Param("teacherId") Integer teacherId);
	
	/**
	 * 
	
	 * <p>Title: selectStudentOfClassesByClassesIdAndTeacherId</p>  
	
	 * <p>Description:�Ѿ��ύ��ѧ������Ϣ </p>  
	
	 * @param classesId �༶
	 * @param teacherId ��ʦ���
	 * @return
	 */
	
	public List<User> selectStudentOfClassesByClassesIdAndTeacherId(@Param("classesId") Integer classesId, @Param("teacherId") Integer teacherId);
	
	
	/**
	 * 
	
	 * <p>Title: changeDepart</p>  
	
	 * <p>Description: ���²���</p>  
	
	 * @param userId �û����
	 * @param departId ���ű��
	 * @return long
	 * @throws Exception
	 */
	public int changeDepart(Integer userId,Integer departId) throws Exception;
	
	
	
	/**
	 * 
	
	 * <p>Title: changeStatus</p>  
	
	 * <p>Description:�����û�״̬ </p>  
	
	 * @param userId//�û����
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public int changeStatus(Integer userId,Integer status) throws Exception;
	
	
	/**
	 * 
	
	 * <p>Title: selectTeacherGetAllAssessScorce</p>  
	
	 * <p>Description:��ȡ���н�ʦ�Ĳ������� </p>  
	
	 * @return 
	 */
     public	List<QueryAllTeacherGetScoreVO> selectTeacherGetAllAssessScorce();
     
     
     
     
     /**
      * 
     
      * <p>Title: selectTeacherClassesRateofStudentSubmit</p>  
     
      * <p>Description:��ѯ ��ʦ�ڿΰ༶ѧ���ύ��</p>  
     
      * @return
      */
     public List<QueryClassesRateofStudentSubmit> selectTeacherClassesRateofStudentSubmit();
     
     /**
      * 
     
      * <p>Title: selectBetweenTeacherScore</p>  
     
      * <p>Description: ���</p>  
     
      * @return
      */
     public  List<QueryAllTeacherGetScoreVO> selectBetweenTeacherScore();
	
	
	
	
}
