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
	
	 * <p>Description: 查询系统模块</p>  
	
	 * @param systemModuleExample
	 * @return系统模块集合
	 * @throws Exception
	 */
	
	public List<Criteria> queryCriteriaList(CriteriaExample criteriaExample) throws Exception;
	
	/**
	 * 
	 * <p>Title: findSystemModuleById</p>  
	 * <p>Description:查找管理员实例 </p>  
	
	 * @param id 管理员编号
	 * @return 管理员实例
	 * @throws Exception
	 */
	public Criteria findCriteriaById(Integer id) throws Exception;
	
	/**
	 * 
	 * <p>Title: deteteSystemModuleById</p>  
	
	 * <p>Description: 删除系统模块</p>  
	
	 * @param id 编号
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int deteteCriteriaById(Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: updateAdminById</p>  
	
	 * <p>Description: 更新系统模块</p>  	
	 * @param id  编号
	 * @param systemModule 实例
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int updateCriteriaById(Integer id,Criteria criteria) throws Exception;
	/**
	 * 
	 * <p>Title: insertAdmin</p>  
	
	 * <p>Description:添加系统模块 </p>  
	
	 * @return受影响的行数
	 * @throws Exception
	 */
	public int insertCriteria(Criteria Criteria) throws Exception;
	/**
	 * 
	
	 * <p>Title: insertSubSystemModule</p>  
	
	 * <p>Description: 添加子模块</p>  
	
	 * @param pid 父编号
	 * @param systemModule 实例
	 * @return 影响行数
	 * @throws Exception
	 */
	
	public int insertSubCriteria(Integer pid,Criteria criteria) throws Exception;
	
	/**

	 * <p>Title: querySystemModuleVoList</p>  
	
	 * <p>Description:系统后台二级菜单</p>  
	
	 * @param systemModuleExample
	 * @return SystemModuleVo  SystemModule包装类
	 * @throws Exception
	 */
	public List<CriteriaVo> findCriteriaVo(Integer pid,CriteriaExample criteriaExample) throws Exception;
	
	/**
	 * 
	
	 * <p>Title: queryCriteriaListByParentd</p>  
	
	 * <p>Description:通过父编号获取标准集合 </p>  
	
	 * @param pid
	 * @return 标准集合
	 * @throws Exception
	 */
	public List<Criteria> queryCriteriaListByParentd(Integer pid) throws Exception;
	
	
	/**
	 * 	
	 * <p>Title: checkCriteriaName</p>  
	
	 * <p>Description:检查标准名称是否存在 </p>  
	
	 * @param criteriaName
	 * @return long
	 * @throws Exception
	 */
	public long checkCriteriaName(String criteriaName) throws Exception;
	
	

}
