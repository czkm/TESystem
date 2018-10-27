package cn.wuzongbo.tes.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.wuzongbo.tes.mapper.UserClassesMapper;
import cn.wuzongbo.tes.mapper.UserMapper;
import cn.wuzongbo.tes.po.ClassesAndUserVo;
import cn.wuzongbo.tes.po.User;
import cn.wuzongbo.tes.po.UserClasses;
import cn.wuzongbo.tes.po.UserClassesExample;
import cn.wuzongbo.tes.service.UserClassesService;
@Service
public class UserClassesServiceImpl  implements UserClassesService{
	@Autowired
	private UserMapper userMapper;
	@Autowired
   private UserClassesMapper userClassesMapper;
	@Override
	public List<UserClasses> queryUserClassesList(UserClassesExample userClassesExample) throws Exception {
		// TODO Auto-generated method stub
		return userClassesMapper.selectByExample(userClassesExample);
	}
	@Override
	public UserClasses findUserClassesById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return userClassesMapper.selectByPrimaryKey(id);
	}
	@Override
	public int deteteUserClassesById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return userClassesMapper.deleteByPrimaryKey(id);
	}
	@Override
	public int updateUserClassesById(Integer id, UserClasses userClasses) throws Exception {
		// TODO Auto-generated method stub
		userClasses.setId(id);
		return userClassesMapper.updateByPrimaryKeySelective(userClasses);
	}
	@Override
	public int insertUserClasses(UserClasses userClasses) throws Exception {
		// TODO Auto-generated method stub
		return userClassesMapper.insertSelective(userClasses);
	}
	/**
	 * 通过班级获取用户信息，也就是教师信息
	 */
	@Override
	public List<User> queryUserListByClassesId(Integer classesId) throws Exception {
		// TODO Auto-generated method stub
		
		List<User> users=new ArrayList<User>();
		UserClassesExample userClassesExample=new UserClassesExample();
		UserClassesExample.Criteria criteria=userClassesExample.createCriteria();
		criteria.andClassesIdEqualTo(classesId);
	
		List<UserClasses> userClassesList=userClassesMapper.selectByExample(userClassesExample);
		
		if(userClassesList!=null&&userClassesList.size()>0){
			
			for(UserClasses userClasses:userClassesList){
				
			User user=	userMapper.selectByPrimaryKey(userClasses.getUserId());
			users.add(user);
			
			}
			return users;
		}
		else{
			return null;
			
		}					
	}
	
	@Override
	public int deteteUserClasses(UserClassesExample userClassesExample) throws Exception {
		// TODO Auto-generated method stub
		return userClassesMapper.deleteByExample(userClassesExample);
	}

	

}
