package cn.wuzongbo.tes.service;

import java.util.List;

import cn.wuzongbo.tes.po.Admin;
import cn.wuzongbo.tes.po.AdminExample;
import cn.wuzongbo.tes.po.SystemModule;
import cn.wuzongbo.tes.po.SystemModuleExample;
import cn.wuzongbo.tes.po.SystemModuleVo;

/**
 * 

* <p>Title: SystemModuleService</p>  

* <p>Description: ϵͳģ�����ӿ�</p>  

* @author ���ڲ�  

* @date 2018��3��7��
 */
public interface SystemModuleService {
	/**
	 * 
	
	 * <p>Title: querySystemModuleList</p>  
	
	 * <p>Description: ��ѯϵͳģ��</p>  
	
	 * @param systemModuleExample
	 * @returnϵͳģ�鼯��
	 * @throws Exception
	 */
	
	public List<SystemModule> querySystemModuleList(SystemModuleExample systemModuleExample) throws Exception;
	
	/**
	 * 
	 * <p>Title: findSystemModuleById</p>  
	 * <p>Description:���ҹ���Աʵ�� </p>  
	
	 * @param id ����Ա���
	 * @return ����Աʵ��
	 * @throws Exception
	 */
	public SystemModule findSystemModuleById(Short id) throws Exception;
	
	/**
	 * 
	 * <p>Title: deteteSystemModuleById</p>  
	
	 * <p>Description: ɾ��ϵͳģ��</p>  
	
	 * @param id ���
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int deteteSystemModuleById(Short id) throws Exception;
	/**
	 * 
	 * <p>Title: updateAdminById</p>  
	
	 * <p>Description: ����ϵͳģ��</p>  	
	 * @param id  ���
	 * @param systemModule ʵ��
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int updateSystemModuleById(Short id,SystemModule systemModule) throws Exception;
	/**
	 * 
	 * <p>Title: insertAdmin</p>  
	
	 * <p>Description:���ϵͳģ�� </p>  
	
	 * @return��Ӱ�������
	 * @throws Exception
	 */
	public int insertSystemModule(SystemModule systemModule) throws Exception;
	/**
	 * 
	
	 * <p>Title: insertSubSystemModule</p>  
	
	 * <p>Description: �����ģ��</p>  
	
	 * @param pid �����
	 * @param systemModule ʵ��
	 * @return Ӱ������
	 * @throws Exception
	 */
	
	public int insertSubSystemModule(Short pid,SystemModule systemModule) throws Exception;
	
	/**

	 * <p>Title: querySystemModuleVoList</p>  
	
	 * <p>Description:ϵͳ��̨�����˵�</p>  
	
	 * @param systemModuleExample
	 * @return SystemModuleVo  SystemModule��װ��
	 * @throws Exception
	 */
	public List<SystemModuleVo> findSystemModuleVo(Short pid) throws Exception;
	
	

}
