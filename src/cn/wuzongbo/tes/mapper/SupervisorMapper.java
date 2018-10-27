package cn.wuzongbo.tes.mapper;

import cn.wuzongbo.tes.po.Supervisor;
import cn.wuzongbo.tes.po.SupervisorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupervisorMapper {
    long countByExample(SupervisorExample example);

    int deleteByExample(SupervisorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Supervisor record);

    int insertSelective(Supervisor record);

    List<Supervisor> selectByExample(SupervisorExample example);

    Supervisor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Supervisor record, @Param("example") SupervisorExample example);

    int updateByExample(@Param("record") Supervisor record, @Param("example") SupervisorExample example);

    int updateByPrimaryKeySelective(Supervisor record);

    int updateByPrimaryKey(Supervisor record);
}