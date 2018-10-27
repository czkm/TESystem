package cn.wuzongbo.tes.mapper;

import cn.wuzongbo.tes.po.CriteriaClasses;
import cn.wuzongbo.tes.po.CriteriaClassesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CriteriaClassesMapper {
    long countByExample(CriteriaClassesExample example);

    int deleteByExample(CriteriaClassesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CriteriaClasses record);

    int insertSelective(CriteriaClasses record);

    List<CriteriaClasses> selectByExample(CriteriaClassesExample example);

    CriteriaClasses selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CriteriaClasses record, @Param("example") CriteriaClassesExample example);

    int updateByExample(@Param("record") CriteriaClasses record, @Param("example") CriteriaClassesExample example);

    int updateByPrimaryKeySelective(CriteriaClasses record);

    int updateByPrimaryKey(CriteriaClasses record);
}