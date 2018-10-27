package cn.wuzongbo.tes.service;

import java.util.List;

import cn.wuzongbo.tes.po.CriteriaClasses;
import cn.wuzongbo.tes.po.CriteriaClassesExample;
/**
 * 

* <p>Title: CriteriaClassesService</p>  

* <p>Description:��ѧ��׼ </p>  

* @author ���ڲ�  

* @date 2018��6��16��
 */
public interface CriteriaClassesService {
	/**
	 * 
	
	 * <p>Title: insert</p>  
	
	 * <p>Description:�����ѧ��׼ </p>  
	
	 * @param criteriaClasses
	 * @return
	 * @throws Exception
	 */
	public int insert(CriteriaClasses criteriaClasses) throws Exception;
	/**
	 * 
	
	 * <p>Title: query</p>  
	
	 * <p>Description:��ѯ��ѧ��׼ </p>  
	
	 * @param criteriaClassesExample
	 * @return ����
	 * @throws Exception
	 */
	public List<CriteriaClasses> query(CriteriaClassesExample criteriaClassesExample) throws Exception;
	
	/**
	 * 
	
	 * <p>Title: getSinggle</p>  
	
	 * <p>Description:��ȡ������ѧ��׼ʵ�� </p>  
	
	 * @param id ��ѧ��׼���
	 * @return ��ѧ��׼ʵ��
	 * @throws Exception
	 */
	public CriteriaClasses getSinggle(Integer id) throws Exception;
	
	
	/**
	 * 
	
	 * <p>Title: update</p>  
	
	 * <p>Description:��ѧ��׼���� </p>  
	
	 * @param criteriaClasses
	 * @return
	 * @throws Exception
	 */
	public int update(CriteriaClasses criteriaClasses) throws Exception;
	
	
	
	/**
	 * 
	
	 * <p>Title: delete</p>  
	
	 * <p>Description: ɾ����ѧ��׼</p>  
	
	 * @param id ��ѧ��׼���
	 * @return 
	 * @throws Exception
	 */
	
	public int delete(Integer id) throws Exception;
	
	
	
	public boolean checkCriteriaName(String criteriaName)throws Exception;

}
