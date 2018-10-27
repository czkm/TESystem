package cn.wuzongbo.tes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wuzongbo.tes.mapper.CriteriaClassesMapper;
import cn.wuzongbo.tes.po.CriteriaClasses;
import cn.wuzongbo.tes.po.CriteriaClassesExample;
import cn.wuzongbo.tes.service.CriteriaClassesService;
@Service
public class CriteriaClassesServiceImpl implements CriteriaClassesService {

	@Autowired
	private CriteriaClassesMapper criteriaClassesMapper;
	@Override
	public int insert(CriteriaClasses criteriaClasses) throws Exception {
		// TODO Auto-generated method stub
		return criteriaClassesMapper.insertSelective(criteriaClasses);
	}

	@Override
	public List<CriteriaClasses> query(CriteriaClassesExample criteriaClassesExample) throws Exception {
		// TODO Auto-generated method stub
		return criteriaClassesMapper.selectByExample(criteriaClassesExample);
	}

	@Override
	public CriteriaClasses getSinggle(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return criteriaClassesMapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(CriteriaClasses criteriaClasses) throws Exception {
		// TODO Auto-generated method stub
		return criteriaClassesMapper.updateByPrimaryKeySelective(criteriaClasses);
	}

	@Override
	public int delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return criteriaClassesMapper.deleteByPrimaryKey(id);
	}

	@Override
	public boolean checkCriteriaName(String criteriaName) throws Exception {
		// TODO Auto-generated method stub
		CriteriaClassesExample criteriaClassesExample=new CriteriaClassesExample();
		CriteriaClassesExample.Criteria criteria=criteriaClassesExample.createCriteria();
		criteria.andCriteriaNameEqualTo(criteriaName);
		List<CriteriaClasses> criteriaClassesList=query(criteriaClassesExample);
		if(criteriaClassesList!=null&&criteriaClassesList.size()>0){
			return true;
			
		}
		
		return false;
	}

}
