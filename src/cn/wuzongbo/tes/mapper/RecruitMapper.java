package cn.wuzongbo.tes.mapper;

import cn.wuzongbo.tes.po.Recruit;
import cn.wuzongbo.tes.po.RecruitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface RecruitMapper {
    long countByExample(RecruitExample example);

    int deleteByExample(RecruitExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Recruit record);

    int insertSelective(Recruit record);

    List<Recruit> selectByExample(RecruitExample example);

    Recruit selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Recruit record, @Param("example") RecruitExample example);

    int updateByExample(@Param("record") Recruit record, @Param("example") RecruitExample example);

    int updateByPrimaryKeySelective(Recruit record);

    int updateByPrimaryKey(Recruit record);
    
    @Update("TRUNCATE TABLE recruit")
    void clear();//Çå¿ÕÊý¾Ý
    
}