package cn.wuzongbo.tes.mapper;

import cn.wuzongbo.tes.po.ClassCourse;
import cn.wuzongbo.tes.po.ClassCourseExample;
import cn.wuzongbo.tes.po.ClassCourseVo;
import cn.wuzongbo.tes.po.ClasscourseAndCourse;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ClassCourseMapper {
    int countByExample(ClassCourseExample example);

    int deleteByExample(ClassCourseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClassCourse record);

    int insertSelective(ClassCourse record);

    List<ClassCourse> selectByExample(ClassCourseExample example);

    ClassCourse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClassCourse record, @Param("example") ClassCourseExample example);

    int updateByExample(@Param("record") ClassCourse record, @Param("example") ClassCourseExample example);

    int updateByPrimaryKeySelective(ClassCourse record);

    int updateByPrimaryKey(ClassCourse record);
    
    /**
     * 通过class_course表中的id 查找其相应表中的xxxName
     * @return
     */
    List<ClassCourseVo>  selectOtherNamefromOtherTable();
     /**
      * <!-- 通过class_course表中得courseid 查找相应得coursename -->
      * @return
      */
    List<ClassCourseVo> selectcourseNamefromcourseByclasscourse();
    
    //根据班级名称进行模糊查询
    List<ClassCourseVo> selectOtherNamefromOtherTablename(String name);

    //通过weekDay和登录用户的班级id来的到当天的所有的课程
    List<ClasscourseAndCourse> selectclasscourseANDcourseByweekday1(Integer userclassesid);
    
    List<ClasscourseAndCourse> selectclasscourseANDcourseByweekday2(Integer userclassesid);
    
    List<ClasscourseAndCourse> selectclasscourseANDcourseByweekday3(Integer userclassesid);
    
    List<ClasscourseAndCourse> selectclasscourseANDcourseByweekday4(Integer userclassesid);
    
    List<ClasscourseAndCourse> selectclasscourseANDcourseByweekday5(Integer userclassesid);


}