package cn.wuzongbo.tes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wuzongbo.tes.mapper.ClassesMapper;
import cn.wuzongbo.tes.mapper.UserClassesMapper;
import cn.wuzongbo.tes.mapper.UserMapper;
import cn.wuzongbo.tes.po.Classes;
import cn.wuzongbo.tes.po.ClassesExample;
import cn.wuzongbo.tes.po.QueryAllTeacherGetScoreVO;
import cn.wuzongbo.tes.po.QueryClassesRateofStudentSubmit;
import cn.wuzongbo.tes.po.User;
import cn.wuzongbo.tes.po.UserClasses;
import cn.wuzongbo.tes.po.UserClassesExample;
import cn.wuzongbo.tes.po.UserExample;
import cn.wuzongbo.tes.service.UserService;
import cn.wuzongbo.tes.util.MD5Util;
@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserClassesMapper userClassesMapper;
	
	@Autowired
	private ClassesMapper classesMapper;

	@Override
	public User login(String userNo, String password) throws Exception {
		// TODO Auto-generated method stub
		
		UserExample userExample=new UserExample();
		UserExample.Criteria criteria=userExample.createCriteria();
		criteria.andUsernoEqualTo(userNo);
		criteria.andPasswordEqualTo(password);
		List<User> users=userMapper.selectByExample(userExample);
		if(users.size()>0){
			return users.get(0);
		}
		return null;
	}
/**
 * 更新密码
 * 返回 1代表密码修改成功 -1不成功,0原始密码错误
 */
	@Override
	public int changePassword(String newpassword, String nowpassword, Integer id) throws Exception {
		
		User user=userMapper.selectByPrimaryKey(id);
		String oldpassword=MD5Util.MD5(user.getUserno()+nowpassword);
		
		if(oldpassword.equals(user.getPassword())){
			
			String password=MD5Util.MD5(user.getUserno()+newpassword);
			user.setPassword(password);
			user.setId(id);
		    int i=	userMapper.updateByPrimaryKeySelective(user);
			if(i>0){
				
				return 1;
			}
			else{
				
				return -1;	
			}
		}
		else{
			
			return 0;
			
		}
		
		// TODO Auto-generated method stub
		
	}
    /**
     * 重置密码
     * 默认密码是88888888
     */
	@Override
	public int resetPassword(String password, Integer id) throws Exception {
		// TODO Auto-generated method stub
		User user=new User();
		user.setId(id);
		user.setPassword(password);
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public List<User> queryUserList(UserExample userExample) throws Exception {
		// TODO Auto-generated method stub
		
		List<User> users=userMapper.selectByExample(userExample);
		return users;
	}

	@Override
	public User findUserById(Integer id) throws Exception {
		// TODO Auto-generated method stub
	
		
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deteteUserById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.deleteByPrimaryKey(id);
	
	}

	@Override
	public int updateUserById(Integer id, User user) throws Exception {
		// TODO Auto-generated method stub
		user.setId(id);
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public int insertUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.insertSelective(user);
	}
	@Override
	public int deteteUser(UserExample userExample) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.deleteByExample(userExample);
	}
	@Override
	public long checkUserno(String userno) throws Exception {
		// TODO Auto-generated method stub
		UserExample userExample=new UserExample();
		UserExample.Criteria criteria=userExample.createCriteria();
		criteria.andUsernoEqualTo(userno);
		long row=userMapper.countByExample(userExample);
		
		return row;
	}
	@Override
	public int resetPassword(int id, String userno) throws Exception {
		// TODO Auto-generated method stub
		User user=new User();
		user.setId(id);
		String password=MD5Util.MD5(userno+"88888888");
		user.setPassword(password);
		return userMapper.updateByPrimaryKeySelective(user);
		
	}
	@Override
	public List<User> selectByClassesIdAndTeacherId(@Param("classesId") Integer classesId, @Param("teacherId") Integer teacherId) {
		// TODO Auto-generated method stub
		return userMapper.selectByClassesIdAndTeacherId(classesId, teacherId);
	}
	
	@Override
	public List<User> selectStudentOfClassesByClassesIdAndTeacherId(@Param("classesId") Integer classesId, @Param("teacherId") Integer teacherId) {
		// TODO Auto-generated method stub
		return userMapper.selectStudentOfClassesByClassesIdAndTeacherId(classesId, teacherId);
	}
	
	@Override
	public int changeDepart(Integer userId, Integer departId) throws Exception {
		// TODO Auto-generated method stub
		
		User user =new User();
		user.setId(userId);
		user.setDepartid(departId);
		
		return userMapper.updateByPrimaryKeySelective(user);
	}
	@Override
	public int changeStatus(Integer userId, Integer status) throws Exception {
		// TODO Auto-generated method stub
		
		User user=new User();
		user.setId(userId);
		user.setStatus(Byte.valueOf(status.toString()));
		return userMapper.updateByPrimaryKeySelective(user);
	}
	@Override
	public List<QueryAllTeacherGetScoreVO> selectTeacherGetAllAssessScorce() {
		// TODO Auto-generated method stub
		
		List<QueryAllTeacherGetScoreVO> allTeacherGetScoreVOs=userMapper.selectTeacherGetAllAssessScorce();
		
		if(allTeacherGetScoreVOs!=null&&allTeacherGetScoreVOs.size()>0){

			for(QueryAllTeacherGetScoreVO vo: allTeacherGetScoreVOs){
				List<QueryClassesRateofStudentSubmit> queryClassesRateofStudentSubmits=new ArrayList<>();
				QueryClassesRateofStudentSubmit classesRateofStudentSubmit=null;
				long studentCount=0;
				long studentSubmitCount=0;
				//获取某个老师授课班级人数
				UserClassesExample userClassesExample=new UserClassesExample();
				UserClassesExample.Criteria userClassesCriteria=userClassesExample.createCriteria();
				userClassesCriteria.andUserIdEqualTo(vo.getId());
				List<UserClasses> userClassesList=userClassesMapper.selectByExample(userClassesExample);
				
				if(userClassesList!=null&&userClassesList.size()>0){
					for(UserClasses userClasses:userClassesList){
						
						UserExample userExample=new UserExample();
						UserExample.Criteria userCriteria=userExample.createCriteria();
						userCriteria.andClassesidEqualTo(userClasses.getClassesId());
						classesRateofStudentSubmit=new QueryClassesRateofStudentSubmit();
					      long count=	userMapper.countByExample(userExample);
					      classesRateofStudentSubmit.setStudentCount(count);
					      studentCount+=count;
					    //获取测评某个老师学生数量
					      List<User> users=selectStudentOfClassesByClassesIdAndTeacherId(userClasses.getClassesId(),vo.getId());
						  studentSubmitCount+=users.size();
						  
						  Classes classes=classesMapper.selectByPrimaryKey(userClasses.getClassesId());
						 
						  
						  BeanUtils.copyProperties(classes, classesRateofStudentSubmit);
						  classesRateofStudentSubmit.setUserName(vo.getUsername());
						  classesRateofStudentSubmit.setStudentSubmitCount(users.size());
						  
						  classesRateofStudentSubmit.setRate((double)users.size()/count);
						  
						  queryClassesRateofStudentSubmits.add(classesRateofStudentSubmit);
						  
					}
					
					vo.setStudentCount(studentCount);
					
					
					vo.setStudentSubmitCount(studentSubmitCount);
					
					
					vo.setRate((double)studentSubmitCount/studentCount);
					
					vo.setQueryClassesRateofStudentSubmits(queryClassesRateofStudentSubmits);
					
					
					
				}
				
				
				
			}
			
		}
		
		
		
	return	allTeacherGetScoreVOs;
		
		
	}
	@Override
	public List<QueryClassesRateofStudentSubmit> selectTeacherClassesRateofStudentSubmit() {
		// TODO Auto-generated method stub
		 List<QueryClassesRateofStudentSubmit> queryClassesRateofStudentSubmits=null;
          List<QueryAllTeacherGetScoreVO> allTeacherGetScoreVOs=userMapper.selectTeacherGetAllAssessScorce();
         queryClassesRateofStudentSubmits=new ArrayList<>();
		if(allTeacherGetScoreVOs!=null&&allTeacherGetScoreVOs.size()>0){

			for(QueryAllTeacherGetScoreVO vo: allTeacherGetScoreVOs){
				
				QueryClassesRateofStudentSubmit classesRateofStudentSubmit=null;
		
				//获取某个老师授课班级人数
				UserClassesExample userClassesExample=new UserClassesExample();
				UserClassesExample.Criteria userClassesCriteria=userClassesExample.createCriteria();
				userClassesCriteria.andUserIdEqualTo(vo.getId());
				List<UserClasses> userClassesList=userClassesMapper.selectByExample(userClassesExample);
				
				if(userClassesList!=null&&userClassesList.size()>0){
					for(UserClasses userClasses:userClassesList){
						
						UserExample userExample=new UserExample();
						UserExample.Criteria userCriteria=userExample.createCriteria();
						userCriteria.andClassesidEqualTo(userClasses.getClassesId());
						classesRateofStudentSubmit=new QueryClassesRateofStudentSubmit();
					      long count=	userMapper.countByExample(userExample);
					      classesRateofStudentSubmit.setStudentCount(count);
					    //获取测评某个老师学生数量
					      List<User> users=selectStudentOfClassesByClassesIdAndTeacherId(userClasses.getClassesId(),vo.getId());
						  
						  Classes classes=classesMapper.selectByPrimaryKey(userClasses.getClassesId());
						 
						  BeanUtils.copyProperties(classes, classesRateofStudentSubmit);
						  classesRateofStudentSubmit.setUserName(vo.getUsername());
						  classesRateofStudentSubmit.setStudentSubmitCount(users.size());
						  
						  classesRateofStudentSubmit.setRate((double)users.size()/count);
						  classesRateofStudentSubmit.setDepartName(vo.getDepartName());
						  
						  queryClassesRateofStudentSubmits.add(classesRateofStudentSubmit);
						  
					}			
					
				}				
				
			}		
		}
		
		
		
	return	queryClassesRateofStudentSubmits;
		
	}
	@Override
	public List<QueryAllTeacherGetScoreVO> selectBetweenTeacherScore() {
		// TODO Auto-generated method stub
		return userMapper.selectBetweenTeacherScore();
	}

}
