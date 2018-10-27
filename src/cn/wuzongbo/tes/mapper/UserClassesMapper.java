package cn.wuzongbo.tes.mapper;

import cn.wuzongbo.tes.po.UserClasses;
import cn.wuzongbo.tes.po.UserClassesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserClassesMapper {
    long countByExample(UserClassesExample example);

    int deleteByExample(UserClassesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserClasses record);

    int insertSelective(UserClasses record);

    List<UserClasses> selectByExample(UserClassesExample example);

    UserClasses selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserClasses record, @Param("example") UserClassesExample example);

    int updateByExample(@Param("record") UserClasses record, @Param("example") UserClassesExample example);

    int updateByPrimaryKeySelective(UserClasses record);

    int updateByPrimaryKey(UserClasses record);
}