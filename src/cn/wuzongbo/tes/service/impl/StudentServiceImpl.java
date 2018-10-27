package cn.wuzongbo.tes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wuzongbo.tes.mapper.StudentMapper;
import cn.wuzongbo.tes.po.Student;
import cn.wuzongbo.tes.po.StudentExample;
import cn.wuzongbo.tes.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
   private StudentMapper studentMapper;
	@Override
	public Student login(String name, String password) throws Exception {
		// TODO Auto-generated method stub
		StudentExample studentExample=new StudentExample();
		StudentExample.Criteria criteria=studentExample.createCriteria();
		criteria.andUsernoEqualTo(name);
		criteria.andPasswordEqualTo(password);
		
		
		if(studentMapper.selectByExample(studentExample).size()>0){
			
			return studentMapper.selectByExample(studentExample).get(0);
		}
		return null;
		
	}

	@Override
	public int changePassword(String newpassword, String oldpassword, Integer id) throws Exception {
		// TODO Auto-generated method stub
		int rows=0;
		StudentExample studentExample=new StudentExample();
		StudentExample.Criteria criteria=studentExample.createCriteria();
		criteria.andPasswordEqualTo(oldpassword);
		 criteria.andIdEqualTo(id);
		 long count=studentMapper.countByExample(studentExample);
		 if(count>0){
			 Student student=new Student();
			 student.setId(id);
		     student.setPassword(newpassword);
			 rows=studentMapper.updateByPrimaryKeySelective(student);
		 }
		return rows;
	}

	@Override
	public int resetPassword(String password, Integer id) throws Exception {
		// TODO Auto-generated method stub
		 Student student=new Student();
		 student.setId(id);
	     student.setPassword(password);
		
		return  studentMapper.updateByPrimaryKey(student);
	}

	@Override
	public List<Student> queryStudentList(StudentExample studentExample) throws Exception {
		// TODO Auto-generated method stub
		return studentMapper.selectByExample(studentExample);
	}

	@Override
	public Student findStudentById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return studentMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deteteStudentById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return studentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateStudentById(Integer id, Student student) throws Exception {
		// TODO Auto-generated method stub
		student.setId(id);
		return studentMapper.updateByPrimaryKey(student);
	}

	@Override
	public int insertStudent(Student student) throws Exception {
		// TODO Auto-generated method stub
		return studentMapper.insert(student);
	}

}
