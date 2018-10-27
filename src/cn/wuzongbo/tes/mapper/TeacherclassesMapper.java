package cn.wuzongbo.tes.mapper;

import cn.wuzongbo.tes.po.Teacherclasses;
import cn.wuzongbo.tes.po.TeacherclassesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherclassesMapper {
    long countByExample(TeacherclassesExample example);

    int deleteByExample(TeacherclassesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Teacherclasses record);

    int insertSelective(Teacherclasses record);

    List<Teacherclasses> selectByExample(TeacherclassesExample example);

    Teacherclasses selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Teacherclasses record, @Param("example") TeacherclassesExample example);

    int updateByExample(@Param("record") Teacherclasses record, @Param("example") TeacherclassesExample example);

    int updateByPrimaryKeySelective(Teacherclasses record);

    int updateByPrimaryKey(Teacherclasses record);
}