package cn.wuzongbo.tes.service;

import java.util.List;

import cn.wuzongbo.tes.po.Department;
import cn.wuzongbo.tes.po.DepartmentAndClassesVo;
import cn.wuzongbo.tes.po.DepartmentExample;

/**
 * 

* <p>Title: DepartmentService</p>  

* <p>Description:学院处室服务接口 </p>  

* @author 吴宗波  

* @date 2018年3月12日
 */

public interface DepartmentService {
	/**
	 * 
	 * <p>Title: queryDepartmentList</p>  
	 * <p>Description:查询部门 </p>  
	 * @param departmentExample实例
	 * @return 集合
	 * @throws Exception
	 */
	public List<Department> queryDepartmentList(DepartmentExample departmentExample) throws Exception;
	
	/**
	 * 
	 * <p>Title: findDepartmentById</p>  
	 * <p>Description:查找部门实例 </p>  
	
	 * @param id 编号
	 * @return Department实例
	 * @throws Exception
	 */
	public Department findDepartmentById(Integer id) throws Exception;
	
	/**
	 * 
	 * <p>Title: deteteDepartmentById</p>  
	
	 * <p>Description: 删除部门</p>  
	
	 * @param id 编号
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int deteteDepartmentById(Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: updateDepartmentById</p>  
	
	 * <p>Description: 更新部门</p>  	
	 * @param id  编号
	 * @param department 实例
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int updateDepartmentById(Integer id,Department department) throws Exception;
	/**
	 * 
	 * <p>Title: insertDepartment</p>  
	
	 * <p>Description:添加部门 </p>  
	
	 * @return受影响的行数
	 * @throws Exception
	 */
	public int insertDepartment(Department department) throws Exception;
	
	/**
	 * 
	
	 * <p>Title: queryDepartAndClasses</p>  
	
	 * <p>Description:获取部门以及班级 </p>  
	
	 * @return  部门以及班级获得集合
	 * @throws Exception
	 */
	public List<DepartmentAndClassesVo> queryDepartAndClasses() throws Exception;
	
	
	/**
	 * 
	
	 * <p>Title: checkDepartName</p>  
	
	 * <p>Description: 检查部门名称是否存在</p>  
	
	 * @param departName
	 * @return
	 * @throws Exception
	 */
	public long checkDepartName(String departName) throws Exception;
	
	
	
	

}
