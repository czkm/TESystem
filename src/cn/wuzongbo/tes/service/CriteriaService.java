package cn.wuzongbo.tes.service;

import java.util.List;

import cn.wuzongbo.tes.po.Config;
import cn.wuzongbo.tes.po.ConfigExample;
import cn.wuzongbo.tes.po.Criteria;
import cn.wuzongbo.tes.po.CriteriaExample;
import cn.wuzongbo.tes.po.CriteriaVo;


public interface CriteriaService {
	/**
	 * 
	
	 * <p>Title: querySystemModuleList</p>  
	
	 * <p>Description: ��ѯϵͳģ��</p>  
	
	 * @param systemModuleExample
	 * @returnϵͳģ�鼯��
	 * @throws Exception
	 */
	
	public List<Criteria> queryCriteriaList(CriteriaExample criteriaExample) throws Exception;
	
	/**
	 * 
	 * <p>Title: findSystemModuleById</p>  
	 * <p>Description:���ҹ���Աʵ�� </p>  
	
	 * @param id ����Ա���
	 * @return ����Աʵ��
	 * @throws Exception
	 */
	public Criteria findCriteriaById(Integer id) throws Exception;
	
	/**
	 * 
	 * <p>Title: deteteSystemModuleById</p>  
	
	 * <p>Description: ɾ��ϵͳģ��</p>  
	
	 * @param id ���
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int deteteCriteriaById(Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: updateAdminById</p>  
	
	 * <p>Description: ����ϵͳģ��</p>  	
	 * @param id  ���
	 * @param systemModule ʵ��
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int updateCriteriaById(Integer id,Criteria criteria) throws Exception;
	/**
	 * 
	 * <p>Title: insertAdmin</p>  
	
	 * <p>Description:���ϵͳģ�� </p>  
	
	 * @return��Ӱ�������
	 * @throws Exception
	 */
	public int insertCriteria(Criteria Criteria) throws Exception;
	/**
	 * 
	
	 * <p>Title: insertSubSystemModule</p>  
	
	 * <p>Description: �����ģ��</p>  
	
	 * @param pid �����
	 * @param systemModule ʵ��
	 * @return Ӱ������
	 * @throws Exception
	 */
	
	public int insertSubCriteria(Integer pid,Criteria criteria) throws Exception;
	
	/**

	 * <p>Title: querySystemModuleVoList</p>  
	
	 * <p>Description:ϵͳ��̨�����˵�</p>  
	
	 * @param systemModuleExample
	 * @return SystemModuleVo  SystemModule��װ��
	 * @throws Exception
	 */
	public List<CriteriaVo> findCriteriaVo(Integer pid,CriteriaExample criteriaExample) throws Exception;
	
	/**
	 * 
	
	 * <p>Title: queryCriteriaListByParentd</p>  
	
	 * <p>Description:ͨ������Ż�ȡ��׼���� </p>  
	
	 * @param pid
	 * @return ��׼����
	 * @throws Exception
	 */
	public List<Criteria> queryCriteriaListByParentd(Integer pid) throws Exception;
	
	
	/**
	 * 	
	 * <p>Title: checkCriteriaName</p>  
	
	 * <p>Description:����׼�����Ƿ���� </p>  
	
	 * @param criteriaName
	 * @return long
	 * @throws Exception
	 */
	public long checkCriteriaName(String criteriaName) throws Exception;
	
	

}
