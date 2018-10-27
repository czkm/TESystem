package cn.wuzongbo.tes.mapper;

import cn.wuzongbo.tes.po.QueryAllTeacherGetScoreVO;
import cn.wuzongbo.tes.po.User;
import cn.wuzongbo.tes.po.UserExample;
import cn.wuzongbo.tes.po.queryBetweenTeacherScoreVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	//�������ɷ���
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
    
    //�Զ��巽��
    List<User> selectByClassesIdAndTeacherId(@Param("classesId") Integer classesId,@Param("teacherId") Integer teacherId);
    
    //��ȡ������ʦ�Ĳ�������
    List<QueryAllTeacherGetScoreVO> selectTeacherGetAllAssessScorce();
    
    
    List<User> selectStudentOfClassesByClassesIdAndTeacherId(@Param("classesId") Integer classesId,@Param("teacherId") Integer teacherId);
    
    
    /**
     * 
    
     * <p>Title: selectBetweenTeacherScore</p>  
    
     * <p>Description:��ý�ʦ֮�������ķ��� </p>  
    
     * @return
     */
    List<QueryAllTeacherGetScoreVO> selectBetweenTeacherScore();
    
    
}