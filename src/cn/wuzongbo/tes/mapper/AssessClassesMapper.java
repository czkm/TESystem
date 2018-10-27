package cn.wuzongbo.tes.mapper;

import cn.wuzongbo.tes.po.AssessClasses;
import cn.wuzongbo.tes.po.AssessClassesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AssessClassesMapper {
    long countByExample(AssessClassesExample example);

    int deleteByExample(AssessClassesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AssessClasses record);

    int insertSelective(AssessClasses record);

    List<AssessClasses> selectByExample(AssessClassesExample example);

    AssessClasses selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AssessClasses record, @Param("example") AssessClassesExample example);

    int updateByExample(@Param("record") AssessClasses record, @Param("example") AssessClassesExample example);

    int updateByPrimaryKeySelective(AssessClasses record);

    int updateByPrimaryKey(AssessClasses record);
}