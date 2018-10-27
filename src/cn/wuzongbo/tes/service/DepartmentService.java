package cn.wuzongbo.tes.service;

import java.util.List;

import cn.wuzongbo.tes.po.Department;
import cn.wuzongbo.tes.po.DepartmentAndClassesVo;
import cn.wuzongbo.tes.po.DepartmentExample;

/**
 * 

* <p>Title: DepartmentService</p>  

* <p>Description:ѧԺ���ҷ���ӿ� </p>  

* @author ���ڲ�  

* @date 2018��3��12��
 */

public interface DepartmentService {
	/**
	 * 
	 * <p>Title: queryDepartmentList</p>  
	 * <p>Description:��ѯ���� </p>  
	 * @param departmentExampleʵ��
	 * @return ����
	 * @throws Exception
	 */
	public List<Department> queryDepartmentList(DepartmentExample departmentExample) throws Exception;
	
	/**
	 * 
	 * <p>Title: findDepartmentById</p>  
	 * <p>Description:���Ҳ���ʵ�� </p>  
	
	 * @param id ���
	 * @return Departmentʵ��
	 * @throws Exception
	 */
	public Department findDepartmentById(Integer id) throws Exception;
	
	/**
	 * 
	 * <p>Title: deteteDepartmentById</p>  
	
	 * <p>Description: ɾ������</p>  
	
	 * @param id ���
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int deteteDepartmentById(Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: updateDepartmentById</p>  
	
	 * <p>Description: ���²���</p>  	
	 * @param id  ���
	 * @param department ʵ��
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int updateDepartmentById(Integer id,Department department) throws Exception;
	/**
	 * 
	 * <p>Title: insertDepartment</p>  
	
	 * <p>Description:��Ӳ��� </p>  
	
	 * @return��Ӱ�������
	 * @throws Exception
	 */
	public int insertDepartment(Department department) throws Exception;
	
	/**
	 * 
	
	 * <p>Title: queryDepartAndClasses</p>  
	
	 * <p>Description:��ȡ�����Լ��༶ </p>  
	
	 * @return  �����Լ��༶��ü���
	 * @throws Exception
	 */
	public List<DepartmentAndClassesVo> queryDepartAndClasses() throws Exception;
	
	
	/**
	 * 
	
	 * <p>Title: checkDepartName</p>  
	
	 * <p>Description: ��鲿�������Ƿ����</p>  
	
	 * @param departName
	 * @return
	 * @throws Exception
	 */
	public long checkDepartName(String departName) throws Exception;
	
	
	
	

}
