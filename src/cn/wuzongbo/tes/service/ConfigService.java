package cn.wuzongbo.tes.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.wuzongbo.tes.po.Config;
import cn.wuzongbo.tes.po.ConfigExample;

/**
 * 

* <p>Title: ConfigService</p>  

* <p>Description:系统配置服务接口 </p>  

* @author 吴宗波  

* @date 2018年3月12日
 */
public interface ConfigService {
	/**
	 * 
	 * <p>Title: queryConfigList</p>  
	 * <p>Description:查询系统配置 </p>  
	 * @param configExample 查询类
	 * @return 集合
	 * @throws Exception
	 */
	public List<Config> queryConfigList(ConfigExample configExample) throws Exception;
	
	/**
	 * 
	 * <p>Title: findConfigById</p>  
	 * <p>Description:查找系统配置实例 </p>  
	
	 * @param id 管理员编号
	 * @return 系统配置实例
	 * @throws Exception
	 */
	public Config findConfigById(Short id) throws Exception;
	
	/**
	 * 
	 * <p>Title: deteteConfigById</p>  
	
	 * <p>Description: 删除系统配置</p>  
	
	 * @param id 系统配置编号
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int deteteConfigById(Short id) throws Exception;
	/**
	 * 
	 * <p>Title: updateConfigById</p>  
	
	 * <p>Description: 更新系统配置</p>  	
	 * @param id  系统配置编号
	 * @param onfig 配置实例
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int updateConfigById(Short id,Config onfig) throws Exception;
	/**
	 * 
	 * <p>Title: insertConfig</p>  
	
	 * <p>Description:添加系统配置 </p>  
	
	 * @return受影响的行数
	 * @throws Exception
	 */
	public int insertConfig(Config config) throws Exception;
	
	
	/**
	
	 * <p>Title: getRank</p>  
	
	 * <p>Description: 获得标准A，B，C,D,E</p>  
	
	 * @return
	 */
	public Map<String,Integer> getRank(String inc_type) throws Exception;
	
	/**
	 * 
	 * <p>Title: checkConfigName</p>  
	
	 * <p>Description: 检查配置名称是否重复</p>  
	
	 * @param name
	 * @return long
	 * @throws Exception
	 */
	public long checkConfigName(String name)  throws Exception;
	
	

}
