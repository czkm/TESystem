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
    
    //自定义Mapper
    /**
     * 
    
     * <p>Title: selectQueryClassesGetScoreByTeacherId</p>  
    
     * <p>Description:通过教师编号获取评学成绩 </p>  
    
     * @param teacherId 教师编号
     * @return
     */
    List<QueryClassesGetScoreVO> selectQueryClassesGetScoreByTeacherId(Integer teacherId);
    
    
    /**
     * 
    
     * <p>Title: selectAllScoreofClasses</p>  
    
     * <p>Description: 获取所有班级的分数</p>  
    
     * @return 
     */
    List<QueryAllClassesGetScoreVO>  selectAllScoreofClasses();
    
    
    
}