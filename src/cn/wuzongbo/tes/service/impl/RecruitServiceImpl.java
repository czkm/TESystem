package cn.wuzongbo.tes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wuzongbo.tes.mapper.RecruitMapper;
import cn.wuzongbo.tes.po.Recruit;
import cn.wuzongbo.tes.po.RecruitExample;
import cn.wuzongbo.tes.service.RecruitService;
@Service
public class RecruitServiceImpl implements RecruitService {
@Autowired
private RecruitMapper recruitMapper;
	@Override
	public List<Recruit> query(RecruitExample recruitExample) {
		// TODO Auto-generated method stub
		return recruitMapper.selectByExample(recruitExample);
	}
	@Override
	public boolean checkStudetnno(String studentNo) {
		// TODO Auto-generated method stub
		RecruitExample recruitExample=new RecruitExample();
		
		RecruitExample.Criteria criteria=recruitExample.createCriteria();
		criteria.andStudentnoEqualTo(studentNo);
		long l=recruitMapper.countByExample(recruitExample);
		if(l>0){
			return true;	
		}
		else{
			return false;
			
		}
	
	}
	@Override
	public int insert(Recruit recruit) {
		// TODO Auto-generated method stub
		return recruitMapper.insertSelective(recruit);
	}
	@Override
	public int update(Recruit recruit,RecruitExample recruitExample) {
		// TODO Auto-generated method stub
		return recruitMapper.updateByExampleSelective(recruit, recruitExample);
	}
	@Override
	public int update(Recruit recruit) {
		// TODO Auto-generated method stub
		return recruitMapper.updateByPrimaryKeySelective(recruit);
	}
	@Override
	public Recruit getSingle(Integer id) {
		// TODO Auto-generated method stub
		return recruitMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<Recruit> getSingle(RecruitExample recruitExample) {
		// TODO Auto-generated method stub
		return recruitMapper.selectByExample(recruitExample);
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		recruitMapper.clear();
	}
	
	

}
