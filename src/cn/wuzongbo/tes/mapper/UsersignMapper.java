package cn.wuzongbo.tes.mapper;

import cn.wuzongbo.tes.po.Usersign;
import cn.wuzongbo.tes.po.UsersignExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsersignMapper {
    int countByExample(UsersignExample example);

    int deleteByExample(UsersignExample example);

    int deleteByPrimaryKey(Integer id);
    //向签到表中添加签到信息
    int insert(Usersign record);

    int insertSelective(Usersign record);

    List<Usersign> selectByExample(UsersignExample example);

    Usersign selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Usersign record, @Param("example") UsersignExample example);

    int updateByExample(@Param("record") Usersign record, @Param("example") UsersignExample example);

    int updateByPrimaryKeySelective(Usersign record);

    int updateByPrimaryKey(Usersign record);
}