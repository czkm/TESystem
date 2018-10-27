package cn.wuzongbo.tes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wuzongbo.tes.mapper.AdviserClassesMapper;
import cn.wuzongbo.tes.po.AdviserClasses;
import cn.wuzongbo.tes.po.AdviserClassesExample;
import cn.wuzongbo.tes.service.AdviserClassesService;
@Service
public class AdviserClassesServiceImpl implements AdviserClassesService {

	
	@Autowired
	private AdviserClassesMapper adviserClassesMapper;
	@Override
	public int insert(AdviserClasses adviserClasses) throws Exception {
		// TODO Auto-generated method stub
		return adviserClassesMapper.insertSelective(adviserClasses);
	}
	@Override
	public List<AdviserClasses> queryAdviserClassesList(AdviserClassesExample adviserClassesExample) throws Exception {
		// TODO Auto-generated method stub
		return adviserClassesMapper.selectByExample(adviserClassesExample);
	}
	@Override
	public int delete(AdviserClassesExample adviserClassesExample) throws Exception {
		// TODO Auto-generated method stub
		return adviserClassesMapper.deleteByExample(adviserClassesExample);
	}

}
