package cn.wuzongbo.tes.mapper;

import cn.wuzongbo.tes.po.Scholarship;
import cn.wuzongbo.tes.po.ScholarshipExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface ScholarshipMapper {
    long countByExample(ScholarshipExample example);

    int deleteByExample(ScholarshipExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Scholarship record);

    int insertSelective(Scholarship record);

    List<Scholarship> selectByExample(ScholarshipExample example);

    Scholarship selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Scholarship record, @Param("example") ScholarshipExample example);

    int updateByExample(@Param("record") Scholarship record, @Param("example") ScholarshipExample example);

    int updateByPrimaryKeySelective(Scholarship record);

    int updateByPrimaryKey(Scholarship record);
    
    @Update("TRUNCATE TABLE scholarship")
    void clear();//Çå¿ÕÊý¾Ý
}