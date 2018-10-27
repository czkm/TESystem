package cn.wuzongbo.tes.service;

import java.util.List;

import cn.wuzongbo.tes.po.Supervisor;
import cn.wuzongbo.tes.po.SupervisorExample;
/**
 * 
* <p>Title: SupervisorService</p>  

* <p>Description: 督导服务接口</p>  

* @author 吴宗波  

* @date 2018年3月12日
 */
public interface SupervisorService {
	/**
	 * 
	 * <p>Title: login</p>  
	 * <p>Description:督导登录 </p>  
	 * @param supervisorNo  工号
	 * @param password 密码
	 * @return  true|false
	 * @throws Exception
	 */
	public Supervisor login(String supervisorNo ,String password) throws Exception;
	/**
	 * 
	 * <p>Title: changePassword</p>  
	
	 * <p>Description:修改密码 </p>  
	 * @param newpassword 新密码
	 * @param oldpassword 旧密码
	 * @param id 编号
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int changePassword(String newpassword,String oldpassword,Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: resetPassword</p>  
	 * <p>Description:重置密码 </p>  
	 * @param id 编号
	 * @param password 管理员密码
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int resetPassword(String password,Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: querySupervisorList</p>  
	 * <p>Description:查询督导 </p>  
	 * @param supervisorExample 查询类
	 * @return 集合
	 * @throws Exception
	 */
	public List<Supervisor> querySupervisorList(SupervisorExample supervisorExample) throws Exception;
	
	/**
	 * 
	 * <p>Title: findSupervisorById</p>  
	 * <p>Description:查找督导实例 </p>  
	
	 * @param id 编号
	 * @return Supervisor实例
	 * @throws Exception
	 */
	public Supervisor findSupervisorById(Integer id) throws Exception;
	
	/**
	 * 
	 * <p>Title: deteteSupervisorById</p>  
	
	 * <p>Description: 删除督导</p>  
	
	 * @param id 编号
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int deteteSupervisorById(Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: updateSupervisorById</p>  
	
	 * <p>Description: 更新督导</p>  	
	 * @param id  编号
	 * @param supervisor 实例
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int updateSupervisorById(Integer id,Supervisor supervisor) throws Exception;
	/**
	 * 
	 * <p>Title: insertSupervisor</p>  
	
	 * <p>Description:添加督导 </p>  
	
	 * @return受影响的行数
	 * @throws Exception
	 */
	public int insertSupervisor(Supervisor supervisor) throws Exception;
	

}
