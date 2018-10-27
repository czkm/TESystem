package cn.wuzongbo.tes.service;

import java.util.List;

import cn.wuzongbo.tes.po.AssessClasses;
import cn.wuzongbo.tes.po.AssessClassesExample;

public interface AssessClassesService {
	/**
	 * 
	 * <p>Title: insert</p>  
	
	 * <p>Description:�����ѧ��Ϣ
	 * ��ѧ���ǽ�ʦ�����ϵİ༶������
	 *  </p>  
	
	 * @param assessClasses
	 * @return  
	 * @throws Exception
	 */
	public int insert(AssessClasses assessClasses) throws Exception;
	
	public int update(AssessClasses assessClasses) throws Exception;
	
	
	public int delete(Integer id) throws Exception;
	
	
	public AssessClasses getSingle(int id) throws Exception;
	
	public List<AssessClasses> query(AssessClassesExample assessClassesExample) throws Exception;
	
	

}
