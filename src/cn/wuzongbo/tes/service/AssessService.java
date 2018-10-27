package cn.wuzongbo.tes.service;


import java.util.List;

import cn.wuzongbo.tes.po.Assess;
import cn.wuzongbo.tes.po.AssessExample;
import cn.wuzongbo.tes.po.QueryTeacherGetScoreVO;

public interface AssessService {
	
	public Assess findAssess(AssessExample assessExample) throws Exception;
	
	public int Insert(Assess assess) throws Exception;
	 //获取部门学生提交的教师测评数据
    public  List<QueryTeacherGetScoreVO> getTeatcherScoreByDepart(int departId) throws Exception;
    //通过用户编号查询所有提交成绩的老师编号
    public List<Integer> getTeacherIdByUserId(Integer userId) throws Exception;
    //通过用户编号获取教师测评信息
    public List<Assess> selectAssessesByUserId(AssessExample assessExample) throws Exception;
    

}
