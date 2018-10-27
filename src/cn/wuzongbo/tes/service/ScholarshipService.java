package cn.wuzongbo.tes.service;

import java.util.List;

import cn.wuzongbo.tes.po.Scholarship;
import cn.wuzongbo.tes.po.ScholarshipExample;

public interface ScholarshipService {
	
	public int insert(Scholarship scholarship);
	
	public boolean checkStudentNo(String studentNo);
	
	public List<Scholarship> query(ScholarshipExample scholarshipExample);
	
	public void clear();

}
