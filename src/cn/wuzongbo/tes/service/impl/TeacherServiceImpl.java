package cn.wuzongbo.tes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wuzongbo.tes.mapper.TeacherMapper;
import cn.wuzongbo.tes.po.Teacher;
import cn.wuzongbo.tes.po.TeacherExample;
import cn.wuzongbo.tes.service.TeacherService;
@Service
public class TeacherServiceImpl implements TeacherService {
   @Autowired
	private TeacherMapper teacherMapper;
	@Override
	public Teacher login(String teacherNo, String password) throws Exception {
		// TODO Auto-generated method stub
		
		TeacherExample teacherExample=new TeacherExample();
		TeacherExample.Criteria criteria=teacherExample.createCriteria();
		criteria.andUsernoEqualTo(teacherNo);
		criteria.andPasswordEqualTo(password);
		if(teacherMapper.selectByExample(teacherExample).size()>0){
			return teacherMapper.selectByExample(teacherExample).get(0);
			
		}
		
		return null;
	}

	@Override
	public int changePassword(String newpassword, String oldpassword, Integer id) throws Exception {
		// TODO Auto-generated method stub
		int rows=0;
		TeacherExample teacherExample=new TeacherExample();
		TeacherExample.Criteria criteria=teacherExample.createCriteria();
		criteria.andIdEqualTo(id);
		criteria.andPasswordEqualTo(oldpassword);
	long l=	teacherMapper.countByExample(teacherExample);
		if(l>0){
			Teacher teacher=new Teacher();
			teacher.setId(id);
			teacher.setPassword(newpassword);
			
			rows=teacherMapper.updateByPrimaryKeySelective(teacher);
		}
		
		return rows;
	}

	@Override
	public int resetPassword(String password, Integer id) throws Exception {
		// TODO Auto-generated method stub
		Teacher teacher=new Teacher();
		teacher.setId(id);
		teacher.setPassword(password);
	
		return teacherMapper.updateByPrimaryKey(teacher);
	}

	@Override
	public List<Teacher> queryTeacherList(TeacherExample teacherExample) throws Exception {
		// TODO Auto-generated method stub
		return teacherMapper.selectByExample(teacherExample);
	}

	@Override
	public Teacher findTeacherById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return teacherMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deteteTeacherById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return teacherMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateTeacherById(Integer id, Teacher teacher) throws Exception {
		// TODO Auto-generated method stub
		teacher.setId(id);
		return teacherMapper.updateByPrimaryKey(teacher);
	}

	@Override
	public int insertTeacher(Teacher teacher) throws Exception {
		// TODO Auto-generated method stub
		return teacherMapper.insert(teacher);
	}

}
