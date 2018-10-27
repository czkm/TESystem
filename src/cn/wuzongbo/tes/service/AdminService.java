package cn.wuzongbo.tes.service;

import java.util.List;

import cn.wuzongbo.tes.po.Admin;
import cn.wuzongbo.tes.po.AdminExample;

/**
 * 

* <p>Title: AdminService</p>  

* <p>Description: 管理员服务接口</p>  

* @author 吴宗波  

* @date 2018年3月7日
 */
public interface AdminService {
	/**
	 * 
	 * <p>Title: login</p>  
	 * <p>Description:管理员登录 </p>  
	 * @param name 
	 * @param password
	 * @return  true|false
	 * @throws Exception
	 */
	public Admin login(String name ,String password) throws Exception;
	/**
	 * 
	 * <p>Title: changePassword</p>  
	
	 * <p>Description:修改密码 </p>  
	 * @param newpassword 新密码
	 * @param oldpassword 旧密码
	 * @param id 管理员编号
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int changePassword(String newpassword,String oldpassword,Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: resetPassword</p>  
	 * <p>Description:重置密码 </p>  
	 * @param id 管理员编号
	 * @param password 管理员密码
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int resetPassword(String password,Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: queryAdminsList</p>  
	 * <p>Description:查询管理员 </p>  
	 * @param admin pojo类
	 * @return 集合
	 * @throws Exception
	 */
	public List<Admin> queryAdminsList(AdminExample adminExample) throws Exception;
	
	/**
	 * 
	 * <p>Title: findAdminById</p>  
	 * <p>Description:查找管理员实例 </p>  
	
	 * @param id 管理员编号
	 * @return 管理员实例
	 * @throws Exception
	 */
	public Admin findAdminById(Integer id) throws Exception;
	
	/**
	 * 
	 * <p>Title: deteteAdminById</p>  
	
	 * <p>Description: 删除管理员</p>  
	
	 * @param id 管理员编号
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int deteteAdminById(Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: updateAdminById</p>  
	
	 * <p>Description: 更新一个管理员</p>  	
	 * @param id  管理员编号
	 * @param admin 管理员实例
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int updateAdminById(Integer id,Admin admin) throws Exception;
	/**
	 * 
	 * <p>Title: insertAdmin</p>  
	
	 * <p>Description:添加管理员 </p>  
	
	 * @return受影响的行数
	 * @throws Exception
	 */
	public int insertAdmin(Admin admin) throws Exception;
	/**
	 * 
	
	 * <p>Title: checkLoginname</p>  
	
	 * <p>Description:判断管理员名称是否存在 </p>  
	
	 * @param loginname
	 * @return true/false
	 * @throws Exception
	 */
	
	public  long checkLoginname(String loginname) throws Exception ;
	
	
	/**
	 * 
	 * <p>Title: changeStatus</p>  
	
	 * <p>Description: 更改状态</p>  
	
	 * @param id
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public int changeStatus(Integer id,byte status) throws Exception;
	

}
