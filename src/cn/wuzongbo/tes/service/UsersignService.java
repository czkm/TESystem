package cn.wuzongbo.tes.service;

import java.util.List;

import cn.wuzongbo.tes.po.Usersign;
import cn.wuzongbo.tes.po.UsersignExample;

/**
 * 
 * @author wy
 * desciption:签到信息
 * other:
 */
public interface UsersignService {
    /**
     * 学生进行签到信息存入数据区中
     * @param usersign
     * @return
     * @throws Exception
     */
    public int insertSign(Usersign usersign) throws Exception;
    /**
     * 根据学生id查询学生签到信息
     * @param userid
     * @return
     * @throws Exception
     */
    
    public List<Usersign> selectUserSignByUserid(UsersignExample usersignExample) throws Exception;
}
