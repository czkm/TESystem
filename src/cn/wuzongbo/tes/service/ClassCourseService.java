package cn.wuzongbo.tes.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wuzongbo.tes.po.ClassCourse;
import cn.wuzongbo.tes.po.ClassCourseExample;
import cn.wuzongbo.tes.po.ClassCourseVo;
import cn.wuzongbo.tes.po.ClasscourseAndCourse;
import cn.wuzongbo.tes.po.Classes;
import cn.wuzongbo.tes.po.ClassesExample;
import cn.wuzongbo.tes.po.QueryAllClassesGetScoreVO;
import cn.wuzongbo.tes.po.QueryClassesGetScoreVO;

/**
 * @author ������
 * NO�� 35
 *2018��8��6��
 */
public interface ClassCourseService {
	long countByExample(ClassCourseExample example);

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
    
/*    List<QueryAllClassesGetScoreVO>  selectAllScoreofClasses() throws Exception;
*/  
    /**
     * 通过class_course表中的id 查找其相应表中的xxxName
     * @return
     * @throws Exception
     */
    List<ClassCourseVo>  selectOtherNamefromOtherTable() throws Exception;
    
    /**
     * <!-- 通过class_course表中得courseid 查找相应得coursename -->
     * @return
     */
   List<ClassCourseVo> selectcourseNamefromcourseByclasscourse() throws Exception;
    /**
     * 星期一的课程
     * @return
     */
/*   List<ClassCourseVo> selectMondayCourse();*/
   
   
   
   
   
   
   //起
   List<ClassCourseVo> selectOtherNamefromOtherTablename(String name);
   int changStatue(ClassCourseVo classCourseVo);
   
   
   
   //根据weekDay来获取当天的课程
   List<ClasscourseAndCourse> selectclasscourseANDcourseByweekday1(Integer userclassesid)throws Exception;
   
   List<ClasscourseAndCourse> selectclasscourseANDcourseByweekday2(Integer userclassesid)throws Exception;
   
   List<ClasscourseAndCourse> selectclasscourseANDcourseByweekday3(Integer userclassesid)throws Exception;
   
   List<ClasscourseAndCourse> selectclasscourseANDcourseByweekday4(Integer userclassesid)throws Exception;
   
   List<ClasscourseAndCourse> selectclasscourseANDcourseByweekday5(Integer userclassesid)throws Exception;

   
   
   
   
   
   /* String selectNameByClassesId(Integer id);*/
}
