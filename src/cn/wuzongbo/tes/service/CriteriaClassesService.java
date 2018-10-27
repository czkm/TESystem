package cn.wuzongbo.tes.service;

import java.util.List;

import cn.wuzongbo.tes.po.CriteriaClasses;
import cn.wuzongbo.tes.po.CriteriaClassesExample;
/**
 * 

* <p>Title: CriteriaClassesService</p>  

* <p>Description:评学标准 </p>  

* @author 吴宗波  

* @date 2018年6月16日
 */
public interface CriteriaClassesService {
	/**
	 * 
	
	 * <p>Title: insert</p>  
	
	 * <p>Description:添加评学标准 </p>  
	
	 * @param criteriaClasses
	 * @return
	 * @throws Exception
	 */
	public int insert(CriteriaClasses criteriaClasses) throws Exception;
	/**
	 * 
	
	 * <p>Title: query</p>  
	
	 * <p>Description:查询评学标准 </p>  
	
	 * @param criteriaClassesExample
	 * @return 集合
	 * @throws Exception
	 */
	public List<CriteriaClasses> query(CriteriaClassesExample criteriaClassesExample) throws Exception;
	
	/**
	 * 
	
	 * <p>Title: getSinggle</p>  
	
	 * <p>Description:获取单个评学标准实例 </p>  
	
	 * @param id 评学标准编号
	 * @return 评学标准实例
	 * @throws Exception
	 */
	public CriteriaClasses getSinggle(Integer id) throws Exception;
	
	
	/**
	 * 
	
	 * <p>Title: update</p>  
	
	 * <p>Description:评学标准更新 </p>  
	
	 * @param criteriaClasses
	 * @return
	 * @throws Exception
	 */
	public int update(CriteriaClasses criteriaClasses) throws Exception;
	
	
	
	/**
	 * 
	
	 * <p>Title: delete</p>  
	
	 * <p>Description: 删除评学标准</p>  
	
	 * @param id 评学标准编号
	 * @return 
	 * @throws Exception
	 */
	
	public int delete(Integer id) throws Exception;
	
	
	
	public boolean checkCriteriaName(String criteriaName)throws Exception;

}
