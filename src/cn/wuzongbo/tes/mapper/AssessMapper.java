package cn.wuzongbo.tes.mapper;

import cn.wuzongbo.tes.po.Assess;
import cn.wuzongbo.tes.po.AssessExample;
import cn.wuzongbo.tes.po.QueryTeacherGetScoreVO;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AssessMapper {
    long countByExample(AssessExample example);

    int deleteByExample(AssessExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Assess record);

    int insertSelective(Assess record);

    List<Assess> selectByExample(AssessExample example);

    Assess selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Assess record, @Param("example") AssessExample example);

    int updateByExample(@Param("record") Assess record, @Param("example") AssessExample example);

    int updateByPrimaryKeySelective(Assess record);

    int updateByPrimaryKey(Assess record);
    //获取部门学生提交的教师测评数据
    List<QueryTeacherGetScoreVO> getTeatcherScoreByDepart(int departId);
    
    
    
}