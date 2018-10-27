package cn.wuzongbo.tes.service;

import java.util.List;

import cn.wuzongbo.tes.po.Classes;
import cn.wuzongbo.tes.po.ClassesAndUserVo;
import cn.wuzongbo.tes.po.ClassesExample;
import cn.wuzongbo.tes.po.QueryAllClassesGetScoreVO;
import cn.wuzongbo.tes.po.QueryClassesGetScoreVO;

/**
 * 

* <p>Title: ClassesService</p>  

* <p>Description:�༶����ӿ� </p>  

* @author ���ڲ�  

* @date 2018��3��12��
 */

public interface ClassesService {
	/**
	 * 
	 * <p>Title: queryClassesList</p>  
	 * <p>Description:��ѯ�༶ </p>  
	 * @param classesExample
	 * @return ����
	 * @throws Exception
	 */
	public List<Classes> queryClassesList(ClassesExample classesExample) throws Exception;
	
	/**
	 * 
	 * <p>Title: findClassesById</p>  
	 * <p>Description:���Ұ༶ʵ�� </p>  
	
	 * @param id ���
	 * @return Classesʵ��
	 * @throws Exception
	 */
	public Classes findClassesById(Integer id) throws Exception;
	
	/**
	 * 
	 * <p>Title: deteteClassesById</p>  
	
	 * <p>Description: ɾ���༶</p>  
	
	 * @param id ���
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int deteteClassesById(Integer id) throws Exception;
	/**
	 * 
	 * <p>Title: updateClassesById</p>  
	
	 * <p>Description: ���°༶</p>  	
	 * @param id  ����Ա���
	 * @param classes ʵ��
	 * @return ��Ӱ�������
	 * @throws Exception
	 */
	public int updateClassesById(Integer id,Classes classes) throws Exception;
	/**
	 * 
	 * <p>Title: insertClasses</p>  
	
	 * <p>Description:��Ӱ༶ </p>  
	
	 * @return��Ӱ�������
	 * @throws Exception
	 */
	public int insertClasses(Classes classes) throws Exception;
	
	/**
	 * 
	
	 * <p>Title: checkClassesName</p>  
	
	 * <p>Description:���༶�����Ƿ��ظ� </p>  
	
	 * @param classesName
	 * @return long
	 * @throws Exception
	 */
	public long checkClassesName(String classesName) throws Exception;
	
	/**
	 * 
	
	 * <p>Title: selectClassesByAdviserId</p>  
	
	 * <p>Description: ͨ�������α�Ų�ѯ�༶</p>  
	
	 * @param adviserId
	 * @return �༶����
	 * @throws Exception
	 */
	public List<Classes> selectClassesByAdviserId(Integer adviserId) throws Exception;
	
	
	/**
	 * 
	
	 * <p>Title: selectClassesByAdviserId</p>  
	
	 * <p>Description: ͨ����ʦ��Ų�ѯ�༶</p>  
	
	 * @param adviserId
	 * @return �༶����
	 * @throws Exception
	 */
	
	public List<Classes> selectClassesByTeacherId(Integer teacherId) throws Exception;
	
	/**
	 * 
	
	 * <p>Title: selectClassesAndUserByClasses</p>  
	
	 * <p>Description:���ݰ����α��
	 * ��ȡ�༶�ͽ�ʦ����
	 *  </p>  
	
	 * @return �༶�ͽ�ʦ����
	 * @throws Exception
	 */
	
	public List<ClassesAndUserVo> selectClassesAndUserByAdviser(Integer adviserId) throws Exception;
	
	/**
	 * 
	
	 * <p>Title: getClassesIdsByUserId</p>  
	
	 * <p>Description:ͨ���û���Ż�ð༶��ż��� </p>  
	
	 * @param userId
	 * @return �༶��ż���
	 * @throws Exception
	 */
	
	public List<Integer>  getClassesIdsByUserId(Integer userId) throws Exception;
	
	/**
	 * 
	
	 * <p>Title: selectQueryClassesGetScoreByTeacherId</p>  
	
	 * <p>Description:ͨ����ʦ��Ż�ð༶����ѧ���� </p>  
	
	 * @param teacherId
	 * @return  
	 * @throws Exception
	 */
	
	
     public	List<QueryClassesGetScoreVO> selectQueryClassesGetScoreByTeacherId(Integer teacherId) throws Exception;
     
     
     /**
      * 
     
      * <p>Title: selectAllScoreofClasses</p>  
     
      * <p>Description:��ȡ���а༶����ѧ���� </p>  
     
      * @return
      * @throws Exception
      */
     List<QueryAllClassesGetScoreVO>  selectAllScoreofClasses() throws Exception;
	 /**
	  * 获取所有班级名
	  * @param classesExample
	  * @return
	  * @throws Exception
	  */
//     public List<Classes> selectClassName(ClassesExample classesExample) throws Exception;
}
