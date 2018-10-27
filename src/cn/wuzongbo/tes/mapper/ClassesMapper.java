package cn.wuzongbo.tes.mapper;

import cn.wuzongbo.tes.po.Classes;
import cn.wuzongbo.tes.po.ClassesExample;
import cn.wuzongbo.tes.po.QueryAllClassesGetScoreVO;
import cn.wuzongbo.tes.po.QueryClassesGetScoreVO;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassesMapper {
    long countByExample(ClassesExample example);

    int deleteByExample(ClassesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Classes record);

    int insertSelective(Classes record);

    List<Classes> selectByExample(ClassesExample example);

    Classes selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Classes record, @Param("example") ClassesExample example);

    int updateByExample(@Param("record") Classes record, @Param("example") ClassesExample example);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);
    
    List<Classes> selectClassesByAdviserId(Integer adviserId);
    
    List<Classes> selectClassesByTeacherId(Integer teacherId);
    
    List<Classes> selectClassesJoinAssessClassesByTeacherId(Integer teacherId);
    
    //�Զ���Mapper
    /**
     * 
    
     * <p>Title: selectQueryClassesGetScoreByTeacherId</p>  
    
     * <p>Description:ͨ����ʦ��Ż�ȡ��ѧ�ɼ� </p>  
    
     * @param teacherId ��ʦ���
     * @return
     */
    List<QueryClassesGetScoreVO> selectQueryClassesGetScoreByTeacherId(Integer teacherId);
    
    
    /**
     * 
    
     * <p>Title: selectAllScoreofClasses</p>  
    
     * <p>Description: ��ȡ���а༶�ķ���</p>  
    
     * @return 
     */
    List<QueryAllClassesGetScoreVO>  selectAllScoreofClasses();
    
    
    
}