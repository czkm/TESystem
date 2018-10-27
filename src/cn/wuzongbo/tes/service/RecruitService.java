package cn.wuzongbo.tes.service;

import java.util.List;

import cn.wuzongbo.tes.po.Recruit;
import cn.wuzongbo.tes.po.RecruitExample;

public interface RecruitService {
	
	public List<Recruit> query(RecruitExample recruitExample);
	
	public boolean checkStudetnno(String studentNo);
	
	public int insert(Recruit recruit);
	
	public int update(Recruit recruit,RecruitExample recruitExample);
	
	public int update(Recruit recruit);
	
	public Recruit getSingle(Integer id);
	
	
	public List<Recruit> getSingle(RecruitExample recruitExample);
	
	
	public void clear();

}
