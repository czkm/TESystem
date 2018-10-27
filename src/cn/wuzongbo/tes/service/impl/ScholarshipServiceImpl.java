package cn.wuzongbo.tes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wuzongbo.tes.mapper.ScholarshipMapper;
import cn.wuzongbo.tes.po.Scholarship;
import cn.wuzongbo.tes.po.ScholarshipExample;
import cn.wuzongbo.tes.service.ScholarshipService;
@Service
public class ScholarshipServiceImpl implements ScholarshipService {
   @Autowired
   private ScholarshipMapper scholarshipMapper;
	@Override
	public int insert(Scholarship scholarship) {
		// TODO Auto-generated method stub
		return scholarshipMapper.insert(scholarship);
	}
	@Override
	public boolean checkStudentNo(String studentNo) {
		// TODO Auto-generated method stub
	ScholarshipExample scholarshipExample=new ScholarshipExample();
	
	ScholarshipExample.Criteria criteria=scholarshipExample.createCriteria();
	criteria.andStudentnoEqualTo(studentNo);
	  long row=scholarshipMapper.countByExample(scholarshipExample);
		if(row>0){
			return true;
			
		}
		else{
		return false;
		}
	}
	@Override
	public List<Scholarship> query(ScholarshipExample scholarshipExample) {
		// TODO Auto-generated method stub
		return scholarshipMapper.selectByExample(scholarshipExample);
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
		
		scholarshipMapper.clear();
	}

}
