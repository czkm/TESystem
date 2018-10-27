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

* <p>Description: ��ʦ�༶����ӿ�</p>  

* @author ���ڲ�  

* @date 2018��3��12��
 */
public interface UserClassesService {
	
	/**
	 * 
	 * <p>Title: queryUserClassesList</p>  
	 * <p>Description:��ѯ�û��༶��Ϣ </p>  
	 * @param userClassesExample ��ѯ��
	 * @return ����
	 * @throws Exception
	 */
	public List<UserClasses> queryUserClassesList(UserClassesExample userClassesExample) throws Exception;
	
	/**
	 * 
	 * <p>Title: findUserClassesById</p>  
	 * <p>Description:�����û��༶ʵ�� </p>  
	
	 * @param id ���
	 * @return UserClassesʵ��
	 * @throws Exception
	 */
	public UserClasses findUserClassesById(Integer id) throws Exception;
	
	/**
	 * 
	 * <p>Title: deteteUserClassesById</p>  
	
	 * <p>Description: ɾ���û��༶���</p>  
	
	 * @param id ���
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int deteteUserClassesById(Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: deteteUserClassesById</p>  
	
	 * <p>Description: ɾ���û��༶���</p>  
	
	 * @param id ���
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int deteteUserClasses(UserClassesExample userClassesExample) throws Exception;
	/**
	 * 
	 * <p>Title: updateUserClassesById</p>  
	
	 * <p>Description: �����û��༶</p>  	
	 * @param id  ���
	 * @param userClasses ʵ��
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int updateUserClassesById(Integer id,UserClasses userClasses) throws Exception;
	/**
	 * 
	 * <p>Title: insertStudent</p>  
	
	 * <p>Description:���ѧ�� </p>  
	
	 * @return��Ӱ�������
	 * @throws Exception
	 */
	public int insertUserClasses(UserClasses userClasses) throws Exception;
	
	/**
	 * 
	
	 * <p>Title: queryUserListByClassesId</p>  
	
	 * <p>Description:ͨ���û�classesId��ȡUser </p>  
	
	 * @param classesId���ұ�ţ��û����
	 * @return �û�����
	 * @throws Exception
	 */
	public List<User> queryUserListByClassesId(Integer classesId) throws Exception;
	
}
