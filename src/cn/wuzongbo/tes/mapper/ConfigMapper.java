package cn.wuzongbo.tes.mapper;

import cn.wuzongbo.tes.po.Config;
import cn.wuzongbo.tes.po.ConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConfigMapper {
    long countByExample(ConfigExample example);

    int deleteByExample(ConfigExample example);

    int deleteByPrimaryKey(Short id);

    int insert(Config record);

    int insertSelective(Config record);

    List<Config> selectByExample(ConfigExample example);

    Config selectByPrimaryKey(Short id);

    int updateByExampleSelective(@Param("record") Config record, @Param("example") ConfigExample example);

    int updateByExample(@Param("record") Config record, @Param("example") ConfigExample example);

    int updateByPrimaryKeySelective(Config record);

    int updateByPrimaryKey(Config record);
}