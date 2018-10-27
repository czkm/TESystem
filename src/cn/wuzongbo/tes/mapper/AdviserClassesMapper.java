package cn.wuzongbo.tes.mapper;

import cn.wuzongbo.tes.po.AdviserClasses;
import cn.wuzongbo.tes.po.AdviserClassesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdviserClassesMapper {
    long countByExample(AdviserClassesExample example);

    int deleteByExample(AdviserClassesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdviserClasses record);

    int insertSelective(AdviserClasses record);

    List<AdviserClasses> selectByExample(AdviserClassesExample example);

    AdviserClasses selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdviserClasses record, @Param("example") AdviserClassesExample example);

    int updateByExample(@Param("record") AdviserClasses record, @Param("example") AdviserClassesExample example);

    int updateByPrimaryKeySelective(AdviserClasses record);

    int updateByPrimaryKey(AdviserClasses record);
}