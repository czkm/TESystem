package cn.wuzongbo.tes.mapper;

import cn.wuzongbo.tes.po.QueryAllTeacherGetScoreVO;
import cn.wuzongbo.tes.po.User;
import cn.wuzongbo.tes.po.UserExample;
import cn.wuzongbo.tes.po.queryBetweenTeacherScoreVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	//工具生成方法
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    //自定义方法
    List<User> selectByClassesIdAndTeacherId(@Param("classesId") Integer classesId,@Param("teacherId") Integer teacherId);
    
    //获取所有老师的测评分数
    List<QueryAllTeacherGetScoreVO> selectTeacherGetAllAssessScorce();
    
    
    List<User> selectStudentOfClassesByClassesIdAndTeacherId(@Param("classesId") Integer classesId,@Param("teacherId") Integer teacherId);
    
    
    /**
     * 
    
     * <p>Title: selectBetweenTeacherScore</p>  
    
     * <p>Description:获得教师之间自评的分数 </p>  
    
     * @return
     */
    List<QueryAllTeacherGetScoreVO> selectBetweenTeacherScore();
    
    
}