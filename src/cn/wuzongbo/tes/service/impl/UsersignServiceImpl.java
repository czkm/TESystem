package cn.wuzongbo.tes.service.impl;

import java.util.List;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wuzongbo.tes.mapper.UsersignMapper;
import cn.wuzongbo.tes.po.Usersign;
import cn.wuzongbo.tes.po.UsersignExample;
import cn.wuzongbo.tes.service.UsersignService;
@Service
public class UsersignServiceImpl implements UsersignService {
	@Autowired
    private UsersignMapper usersignMapper;
    /**
     * 添加签到信息
     */
	@Override
	public int insertSign(Usersign usersign) throws Exception {
		// TODO Auto-generated method stub
		return usersignMapper.insert(usersign);
	}
    /**
     * 根据用户ID查找签到信息
     */
	@Override
	public List<Usersign> selectUserSignByUserid(UsersignExample usersignExample)
			throws Exception {
		// TODO Auto-generated method stub
		return usersignMapper.selectByExample(usersignExample);
	}

}
