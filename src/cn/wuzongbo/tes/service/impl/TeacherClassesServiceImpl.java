package cn.wuzongbo.tes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wuzongbo.tes.mapper.TeacherMapper;
import cn.wuzongbo.tes.mapper.TeacherclassesMapper;
import cn.wuzongbo.tes.po.ClassesAndTeacherVo;
import cn.wuzongbo.tes.po.Teacher;
import cn.wuzongbo.tes.po.TeacherExample;
import cn.wuzongbo.tes.po.Teacherclasses;
import cn.wuzongbo.tes.po.TeacherclassesExample;
import cn.wuzongbo.tes.service.TeacherclassesService;
@Service
public class TeacherClassesServiceImpl  implements TeacherclassesService{
	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
   private TeacherclassesMapper teacherclassesMapper;
	@Override
	public List<Teacherclasses> queryTeacherclassesList(TeacherclassesExample teacherExample) throws Exception {
		// TODO Auto-generated method stub
		return teacherclassesMapper.selectByExample(teacherExample);
	}

	@Override
	public Teacherclasses findTeacherclassesById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return teacherclassesMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deteteTeacherclassesById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return teacherclassesMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateTeacherclassesById(Integer id, Teacherclasses teacherclasses) throws Exception {
		// TODO Auto-generated method stub
		teacherclasses.setId(id);
		return teacherclassesMapper.updateByPrimaryKey(teacherclasses);
	}

	@Override
	public int insertTeacherclasses(Teacherclasses teacherclasses) throws Exception {
		// TODO Auto-generated method stub
		return teacherclassesMapper.insert(teacherclasses);
	}

	@Override
	public ClassesAndTeacherVo queryTeacherListByClassesId(Integer classesId) throws Exception {
		// TODO Auto-generated method stub
	
		ClassesAndTeacherVo classesAndTeacherVo=new ClassesAndTeacherVo();
		TeacherclassesExample teacherclassesExample=new TeacherclassesExample();
		TeacherclassesExample.Criteria criteria=teacherclassesExample.createCriteria();
		
		criteria.andClassesIdEqualTo(classesId);
		List<Teacherclasses> teacherclasseList =teacherclassesMapper.selectByExample(teacherclassesExample);
		
		Teacher teacher=null;
		List<Teacher> teacherList=new ArrayList<Teacher>();
		for(Teacherclasses teacherclasses:teacherclasseList){
			
			BeanUtils.copyProperties(teacherclasses, classesAndTeacherVo);
			
			teacher =teacherMapper.selectByPrimaryKey(teacherclasses.getTeacherId());
			teacherList.add(teacher);
						
		}
		
		classesAndTeacherVo.setTeachers(teacherList);
		
		return classesAndTeacherVo;
	}
	
	

}
