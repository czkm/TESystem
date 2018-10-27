package cn.wuzongbo.tes.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.wuzongbo.tes.po.Config;
import cn.wuzongbo.tes.po.ConfigExample;

/**
 * 

* <p>Title: ConfigService</p>  

* <p>Description:ϵͳ���÷���ӿ� </p>  

* @author ���ڲ�  

* @date 2018��3��12��
 */
public interface ConfigService {
	/**
	 * 
	 * <p>Title: queryConfigList</p>  
	 * <p>Description:��ѯϵͳ���� </p>  
	 * @param configExample ��ѯ��
	 * @return ����
	 * @throws Exception
	 */
	public List<Config> queryConfigList(ConfigExample configExample) throws Exception;
	
	/**
	 * 
	 * <p>Title: findConfigById</p>  
	 * <p>Description:����ϵͳ����ʵ�� </p>  
	
	 * @param id ����Ա���
	 * @return ϵͳ����ʵ��
	 * @throws Exception
	 */
	public Config findConfigById(Short id) throws Exception;
	
	/**
	 * 
	 * <p>Title: deteteConfigById</p>  
	
	 * <p>Description: ɾ��ϵͳ����</p>  
	
	 * @param id ϵͳ���ñ��
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int deteteConfigById(Short id) throws Exception;
	/**
	 * 
	 * <p>Title: updateConfigById</p>  
	
	 * <p>Description: ����ϵͳ����</p>  	
	 * @param id  ϵͳ���ñ��
	 * @param onfig ����ʵ��
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int updateConfigById(Short id,Config onfig) throws Exception;
	/**
	 * 
	 * <p>Title: insertConfig</p>  
	
	 * <p>Description:���ϵͳ���� </p>  
	
	 * @return��Ӱ�������
	 * @throws Exception
	 */
	public int insertConfig(Config config) throws Exception;
	
	
	/**
	
	 * <p>Title: getRank</p>  
	
	 * <p>Description: ��ñ�׼A��B��C,D,E</p>  
	
	 * @return
	 */
	public Map<String,Integer> getRank(String inc_type) throws Exception;
	
	/**
	 * 
	 * <p>Title: checkConfigName</p>  
	
	 * <p>Description: ������������Ƿ��ظ�</p>  
	
	 * @param name
	 * @return long
	 * @throws Exception
	 */
	public long checkConfigName(String name)  throws Exception;
	
	

}
