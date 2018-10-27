package cn.wuzongbo.tes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wuzongbo.tes.mapper.ClassesMapper;
import cn.wuzongbo.tes.mapper.DepartmentMapper;
import cn.wuzongbo.tes.po.Classes;
import cn.wuzongbo.tes.po.ClassesExample;
import cn.wuzongbo.tes.po.Department;
import cn.wuzongbo.tes.po.DepartmentAndClassesVo;
import cn.wuzongbo.tes.po.DepartmentExample;
import cn.wuzongbo.tes.service.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
    private DepartmentMapper departmentMapper;
	@Autowired
	private ClassesMapper classesMapper;
	@Override
	public List<Department> queryDepartmentList(DepartmentExample departmentExample) throws Exception {
		// TODO Auto-generated method stub
		return departmentMapper.selectByExample(departmentExample);
	}

	@Override
	public Department findDepartmentById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return departmentMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deteteDepartmentById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return departmentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateDepartmentById(Integer id, Department department) throws Exception {
		// TODO Auto-generated method stub
		department.setId(id);
		return departmentMapper.updateByPrimaryKey(department);
	}

	@Override
	public int insertDepartment(Department department) throws Exception {
		// TODO Auto-generated method stub
		return departmentMapper.insert(department);
	}

	@Override
	public List<DepartmentAndClassesVo> queryDepartAndClasses() throws Exception {
		// TODO Auto-generated method stub
		List<DepartmentAndClassesVo>  DepartmentAndClassesList=new ArrayList<DepartmentAndClassesVo>();
		DepartmentAndClassesVo vo=null;
		DepartmentExample departmentExample=new DepartmentExample();
		DepartmentExample.Criteria departmentCriteria=departmentExample.createCriteria();
		departmentCriteria.andTypeEqualTo("ѧԺ");
		
		List<Department> departList=departmentMapper.selectByExample(departmentExample);
		for(Department d:departList){
			vo=new DepartmentAndClassesVo();
			BeanUtils.copyProperties(d, vo);
			ClassesExample classesExample=new ClassesExample();
			
			ClassesExample.Criteria criteria=classesExample.createCriteria();
			
			criteria.andDepartIdEqualTo(d.getId());
			List<Classes> classesList=classesMapper.selectByExample(classesExample);
			
			vo.setClasseses(classesList);
			DepartmentAndClassesList.add(vo);
			
		}
		
		return DepartmentAndClassesList;
	}

	@Override
	public long checkDepartName(String departName) throws Exception {
		// TODO Auto-generated method stub
		
		DepartmentExample departmentExample=new DepartmentExample();
		DepartmentExample.Criteria criteria=departmentExample.createCriteria();
		criteria.andDepartNameEqualTo(departName);
		long row=departmentMapper.countByExample(departmentExample);
		return row;
	}

	

}
