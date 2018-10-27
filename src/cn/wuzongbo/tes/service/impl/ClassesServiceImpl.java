package cn.wuzongbo.tes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wuzongbo.tes.mapper.ClassesMapper;
import cn.wuzongbo.tes.po.Classes;
import cn.wuzongbo.tes.po.ClassesAndUserVo;
import cn.wuzongbo.tes.po.ClassesExample;
import cn.wuzongbo.tes.po.QueryAllClassesGetScoreVO;
import cn.wuzongbo.tes.po.QueryClassesGetScoreVO;
import cn.wuzongbo.tes.po.User;
import cn.wuzongbo.tes.service.ClassesService;
import cn.wuzongbo.tes.service.UserClassesService;
@Service
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    private ClassesMapper  classesMapper;
    
    @Autowired
   private  UserClassesService  userClassesService; 
    /**
     * 查询所有的班级名称
     */
	@Override
	public List<Classes> queryClassesList(ClassesExample classesExample) throws Exception {
		// TODO Auto-generated method stub
		return classesMapper.selectByExample(classesExample);
	}

	@Override
	public Classes findClassesById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return classesMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deteteClassesById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return classesMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateClassesById(Integer id, Classes classes) throws Exception {
		// TODO Auto-generated method stub
		classes.setId(id);
		return classesMapper.updateByPrimaryKey(classes);
	}

	@Override
	public int insertClasses(Classes classes) throws Exception {
		// TODO Auto-generated method stub
		return classesMapper.insert(classes);
	}

	@Override
	public long checkClassesName(String classesName) throws Exception {
		// TODO Auto-generated method stub
		
		ClassesExample classesExample=new ClassesExample();
		ClassesExample.Criteria criteria=classesExample.createCriteria();
		criteria.andClassesNameEqualTo(classesName);
		
		long row=classesMapper.countByExample(classesExample);
		return row;
	}

	@Override
	public List<Classes> selectClassesByAdviserId(Integer adviserId) throws Exception {
		// TODO Auto-generated method stub
		return classesMapper.selectClassesByAdviserId(adviserId);
	}

	@Override
	public List<Classes> selectClassesByTeacherId(Integer teacherId) throws Exception {
		// TODO Auto-generated method stub
		return classesMapper.selectClassesByTeacherId(teacherId);
	}

	@Override
	public List<ClassesAndUserVo> selectClassesAndUserByAdviser(Integer adviserId) throws Exception {
		// TODO Auto-generated method stub
		List<Classes> classesList=selectClassesByAdviserId(adviserId);
		List<ClassesAndUserVo> classesAndUserVos=new ArrayList<>();
		
		ClassesAndUserVo classesAndUserVo=null;
		for (Classes classes:classesList) {
			
			classesAndUserVo=new ClassesAndUserVo();
			
			BeanUtils.copyProperties(classes, classesAndUserVo);
		   List<User> teachers=	userClassesService.queryUserListByClassesId(classes.getId());
			
			
		   classesAndUserVo.setUsers(teachers);
		   
		   classesAndUserVos.add(classesAndUserVo);
			
		}
		
		
		return classesAndUserVos;
	}
    /**
     * ͨ���û���Ż�ȡ�༶��ż���
     */
	@Override
	public List<Integer> getClassesIdsByUserId(Integer userId) throws Exception {
		// TODO Auto-generated method stub
		
		List<Integer> integers=new ArrayList<>();
		List<Classes> classeslist=classesMapper.selectClassesJoinAssessClassesByTeacherId(userId);
		for(Classes classes:classeslist){
			
			integers.add(classes.getId());
		}
		
		
		return integers;
	}

	@Override
	public List<QueryClassesGetScoreVO> selectQueryClassesGetScoreByTeacherId(Integer teacherId) throws Exception {
		// TODO Auto-generated method stub
		return classesMapper.selectQueryClassesGetScoreByTeacherId(teacherId);
	}

	@Override
	public List<QueryAllClassesGetScoreVO> selectAllScoreofClasses() throws Exception {
		// TODO Auto-generated method stub
		return classesMapper.selectAllScoreofClasses();
	}

}
