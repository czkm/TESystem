package cn.wuzongbo.tes.mapper;

import cn.wuzongbo.tes.po.Criteria;
import cn.wuzongbo.tes.po.CriteriaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CriteriaMapper {
    long countByExample(CriteriaExample example);

    int deleteByExample(CriteriaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Criteria record);

    int insertSelective(Criteria record);

    List<Criteria> selectByExample(CriteriaExample example);

    Criteria selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Criteria record, @Param("example") CriteriaExample example);

    int updateByExample(@Param("record") Criteria record, @Param("example") CriteriaExample example);

    int updateByPrimaryKeySelective(Criteria record);

    int updateByPrimaryKey(Criteria record);
}