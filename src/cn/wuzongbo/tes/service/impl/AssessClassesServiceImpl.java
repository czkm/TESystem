package cn.wuzongbo.tes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wuzongbo.tes.mapper.AssessClassesMapper;
import cn.wuzongbo.tes.po.AssessClasses;
import cn.wuzongbo.tes.po.AssessClassesExample;
import cn.wuzongbo.tes.service.AssessClassesService;
@Service
public class AssessClassesServiceImpl implements AssessClassesService {

	@Autowired
	private AssessClassesMapper assessClassesMapper;
	@Override
	public int insert(AssessClasses assessClasses) throws Exception {
		// TODO Auto-generated method stub
		return assessClassesMapper.insert(assessClasses);
	}
	@Override
	public int update(AssessClasses assessClasses) throws Exception {
		// TODO Auto-generated method stub
		return assessClassesMapper.updateByPrimaryKeySelective(assessClasses);
	}
	@Override
	public int delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return assessClassesMapper.deleteByPrimaryKey(id);
	}
	@Override
	public AssessClasses getSingle(int id) throws Exception {
		// TODO Auto-generated method stub
		return assessClassesMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<AssessClasses> query(AssessClassesExample assessClassesExample) throws Exception {
		// TODO Auto-generated method stub
		return assessClassesMapper.selectByExample(assessClassesExample);
	}

}
