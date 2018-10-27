package cn.wuzongbo.tes.service;

import java.util.List;

import cn.wuzongbo.tes.po.Supervisor;
import cn.wuzongbo.tes.po.SupervisorExample;
/**
 * 
* <p>Title: SupervisorService</p>  

* <p>Description: ��������ӿ�</p>  

* @author ���ڲ�  

* @date 2018��3��12��
 */
public interface SupervisorService {
	/**
	 * 
	 * <p>Title: login</p>  
	 * <p>Description:������¼ </p>  
	 * @param supervisorNo  ����
	 * @param password ����
	 * @return  true|false
	 * @throws Exception
	 */
	public Supervisor login(String supervisorNo ,String password) throws Exception;
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
	 * @param password ����Ա����
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int resetPassword(String password,Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: querySupervisorList</p>  
	 * <p>Description:��ѯ���� </p>  
	 * @param supervisorExample ��ѯ��
	 * @return ����
	 * @throws Exception
	 */
	public List<Supervisor> querySupervisorList(SupervisorExample supervisorExample) throws Exception;
	
	/**
	 * 
	 * <p>Title: findSupervisorById</p>  
	 * <p>Description:���Ҷ���ʵ�� </p>  
	
	 * @param id ���
	 * @return Supervisorʵ��
	 * @throws Exception
	 */
	public Supervisor findSupervisorById(Integer id) throws Exception;
	
	/**
	 * 
	 * <p>Title: deteteSupervisorById</p>  
	
	 * <p>Description: ɾ������</p>  
	
	 * @param id ���
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int deteteSupervisorById(Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: updateSupervisorById</p>  
	
	 * <p>Description: ���¶���</p>  	
	 * @param id  ���
	 * @param supervisor ʵ��
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int updateSupervisorById(Integer id,Supervisor supervisor) throws Exception;
	/**
	 * 
	 * <p>Title: insertSupervisor</p>  
	
	 * <p>Description:��Ӷ��� </p>  
	
	 * @return��Ӱ�������
	 * @throws Exception
	 */
	public int insertSupervisor(Supervisor supervisor) throws Exception;
	

}
