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

* <p>Description: 系统模块服务接口</p>  

* @author 吴宗波  

* @date 2018年3月7日
 */
public interface SystemModuleService {
	/**
	 * 
	
	 * <p>Title: querySystemModuleList</p>  
	
	 * <p>Description: 查询系统模块</p>  
	
	 * @param systemModuleExample
	 * @return系统模块集合
	 * @throws Exception
	 */
	
	public List<SystemModule> querySystemModuleList(SystemModuleExample systemModuleExample) throws Exception;
	
	/**
	 * 
	 * <p>Title: findSystemModuleById</p>  
	 * <p>Description:查找管理员实例 </p>  
	
	 * @param id 管理员编号
	 * @return 管理员实例
	 * @throws Exception
	 */
	public SystemModule findSystemModuleById(Short id) throws Exception;
	
	/**
	 * 
	 * <p>Title: deteteSystemModuleById</p>  
	
	 * <p>Description: 删除系统模块</p>  
	
	 * @param id 编号
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int deteteSystemModuleById(Short id) throws Exception;
	/**
	 * 
	 * <p>Title: updateAdminById</p>  
	
	 * <p>Description: 更新系统模块</p>  	
	 * @param id  编号
	 * @param systemModule 实例
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int updateSystemModuleById(Short id,SystemModule systemModule) throws Exception;
	/**
	 * 
	 * <p>Title: insertAdmin</p>  
	
	 * <p>Description:添加系统模块 </p>  
	
	 * @return受影响的行数
	 * @throws Exception
	 */
	public int insertSystemModule(SystemModule systemModule) throws Exception;
	/**
	 * 
	
	 * <p>Title: insertSubSystemModule</p>  
	
	 * <p>Description: 添加子模块</p>  
	
	 * @param pid 父编号
	 * @param systemModule 实例
	 * @return 影响行数
	 * @throws Exception
	 */
	
	public int insertSubSystemModule(Short pid,SystemModule systemModule) throws Exception;
	
	/**

	 * <p>Title: querySystemModuleVoList</p>  
	
	 * <p>Description:系统后台二级菜单</p>  
	
	 * @param systemModuleExample
	 * @return SystemModuleVo  SystemModule包装类
	 * @throws Exception
	 */
	public List<SystemModuleVo> findSystemModuleVo(Short pid) throws Exception;
	
	

}
