package cn.wuzongbo.tes.service;

import java.util.List;

import cn.wuzongbo.tes.po.Admin;
import cn.wuzongbo.tes.po.AdminExample;

/**
 * 

* <p>Title: AdminService</p>  

* <p>Description: ����Ա����ӿ�</p>  

* @author ���ڲ�  

* @date 2018��3��7��
 */
public interface AdminService {
	/**
	 * 
	 * <p>Title: login</p>  
	 * <p>Description:����Ա��¼ </p>  
	 * @param name 
	 * @param password
	 * @return  true|false
	 * @throws Exception
	 */
	public Admin login(String name ,String password) throws Exception;
	/**
	 * 
	 * <p>Title: changePassword</p>  
	
	 * <p>Description:�޸����� </p>  
	 * @param newpassword ������
	 * @param oldpassword ������
	 * @param id ����Ա���
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int changePassword(String newpassword,String oldpassword,Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: resetPassword</p>  
	 * <p>Description:�������� </p>  
	 * @param id ����Ա���
	 * @param password ����Ա����
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int resetPassword(String password,Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: queryAdminsList</p>  
	 * <p>Description:��ѯ����Ա </p>  
	 * @param admin pojo��
	 * @return ����
	 * @throws Exception
	 */
	public List<Admin> queryAdminsList(AdminExample adminExample) throws Exception;
	
	/**
	 * 
	 * <p>Title: findAdminById</p>  
	 * <p>Description:���ҹ���Աʵ�� </p>  
	
	 * @param id ����Ա���
	 * @return ����Աʵ��
	 * @throws Exception
	 */
	public Admin findAdminById(Integer id) throws Exception;
	
	/**
	 * 
	 * <p>Title: deteteAdminById</p>  
	
	 * <p>Description: ɾ������Ա</p>  
	
	 * @param id ����Ա���
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int deteteAdminById(Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: updateAdminById</p>  
	
	 * <p>Description: ����һ������Ա</p>  	
	 * @param id  ����Ա���
	 * @param admin ����Աʵ��
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int updateAdminById(Integer id,Admin admin) throws Exception;
	/**
	 * 
	 * <p>Title: insertAdmin</p>  
	
	 * <p>Description:��ӹ���Ա </p>  
	
	 * @return��Ӱ�������
	 * @throws Exception
	 */
	public int insertAdmin(Admin admin) throws Exception;
	/**
	 * 
	
	 * <p>Title: checkLoginname</p>  
	
	 * <p>Description:�жϹ���Ա�����Ƿ���� </p>  
	
	 * @param loginname
	 * @return true/false
	 * @throws Exception
	 */
	
	public  long checkLoginname(String loginname) throws Exception ;
	
	
	/**
	 * 
	 * <p>Title: changeStatus</p>  
	
	 * <p>Description: ����״̬</p>  
	
	 * @param id
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public int changeStatus(Integer id,byte status) throws Exception;
	

}
