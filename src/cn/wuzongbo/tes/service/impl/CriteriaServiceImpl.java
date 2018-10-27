package cn.wuzongbo.tes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wuzongbo.tes.mapper.CriteriaMapper;
import cn.wuzongbo.tes.po.Criteria;
import cn.wuzongbo.tes.po.CriteriaExample;
import cn.wuzongbo.tes.po.CriteriaVo;
import cn.wuzongbo.tes.service.CriteriaService;
@Service
public class CriteriaServiceImpl implements CriteriaService {
	@Autowired
    private CriteriaMapper criteriaMapper;
	@Override
	public List<Criteria> queryCriteriaList(CriteriaExample criteriaExample) throws Exception {
		// TODO Auto-generated method stub
		return criteriaMapper.selectByExample(criteriaExample);
	}

	@Override
	public Criteria findCriteriaById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return criteriaMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deteteCriteriaById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return criteriaMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateCriteriaById(Integer id, Criteria criteria) throws Exception {
		// TODO Auto-generated method stub
		criteria.setId(id);
		return criteriaMapper.updateByPrimaryKeySelective(criteria);
	}

	@Override
	public int insertCriteria(Criteria Criteria) throws Exception {
		// TODO Auto-generated method stub
		return criteriaMapper.insertSelective(Criteria);
	}

	@Override
	public int insertSubCriteria(Integer pid, Criteria criteria) throws Exception {
		// TODO Auto-generated method stub
		criteria.setParentId(pid);
		return criteriaMapper.insertSelective(criteria);
	}

	@Override
	public List<CriteriaVo> findCriteriaVo(Integer pid,CriteriaExample criteriaExample) throws Exception {
		// TODO Auto-generated method stub
		
		List<CriteriaVo> criteriaVoList=new ArrayList<CriteriaVo>();
		List<Criteria> criteriaList=queryCriteriaList(pid,criteriaExample);
		CriteriaVo vo=null;
		for(Criteria criteria:criteriaList){
			//¶þ¼¶²Ëµ¥
			vo=new CriteriaVo();
			BeanUtils.copyProperties(criteria, vo);
			List<Criteria> criterias=queryCriteriaListByParentd(criteria.getId());
			
			vo.setChildren(criterias);
			
			criteriaVoList.add(vo);
		}
		return criteriaVoList;
	}
	public List<Criteria> queryCriteriaList(Integer pid,CriteriaExample criteriaExample) throws Exception{
		List<Criteria> criterias=null;
		if(criteriaExample==null){
			
			criterias=queryCriteriaListByParentd(pid);
		}
		else{
			criteriaExample=new CriteriaExample();
			CriteriaExample.Criteria criteria=criteriaExample.createCriteria();
			criteria.andParentIdEqualTo(pid);
			criteria.andStatusEqualTo((byte)1);
			
			criterias= criteriaMapper.selectByExample(criteriaExample);
		}
		
		
		return criterias;
		
		
	}
public List<Criteria> queryCriteriaListByParentd(Integer pid) throws Exception{
	    CriteriaExample criteriaExample =new CriteriaExample();
		CriteriaExample.Criteria criteria=criteriaExample.createCriteria();
		criteria.andParentIdEqualTo(pid);		
		criteria.andStatusEqualTo((byte)1);
		
		return criteriaMapper.selectByExample(criteriaExample);
		
		
	}

@Override
public long checkCriteriaName(String criteriaName) throws Exception {
	// TODO Auto-generated method stub
	
	CriteriaExample criteriaExample=new CriteriaExample();
	CriteriaExample.Criteria criteria=criteriaExample.createCriteria();
	criteria.andCriteriaNameEqualTo(criteriaName);
	long row=criteriaMapper.countByExample(criteriaExample);
	
	return row;
}

}
