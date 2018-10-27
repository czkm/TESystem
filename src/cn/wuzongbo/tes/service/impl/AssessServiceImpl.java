package cn.wuzongbo.tes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wuzongbo.tes.mapper.AssessMapper;
import cn.wuzongbo.tes.po.Assess;
import cn.wuzongbo.tes.po.AssessExample;
import cn.wuzongbo.tes.po.QueryTeacherGetScoreVO;
import cn.wuzongbo.tes.service.AssessService;
@Service
public class AssessServiceImpl  implements AssessService{
    @Autowired
    private AssessMapper assessMapper;
	@Override
	public Assess findAssess(AssessExample assessExample) throws Exception {
		// TODO Auto-generated method stub
		
		
		List<Assess> assesses= assessMapper.selectByExample(assessExample);
		if(assesses!=null&&assesses.size()>0){
			
			return assesses.get(0);
		}
		else{
			
			return null;
		}
	}
	@Override
	public int Insert(Assess assess) throws Exception {
		// TODO Auto-generated method stub
		return assessMapper.insertSelective(assess);
	}
	@Override
	public List<QueryTeacherGetScoreVO> getTeatcherScoreByDepart(int departId) throws Exception {
		// TODO Auto-generated method stub
		return assessMapper.getTeatcherScoreByDepart(departId);
	}
	@Override
	public List<Integer> getTeacherIdByUserId(Integer userId) throws Exception {
		// TODO Auto-generated method stub
		AssessExample assessExample=new AssessExample();
		AssessExample.Criteria criteria=assessExample.createCriteria();
		criteria.andUseridEqualTo(userId);
		List<Assess> assessses=assessMapper.selectByExample(assessExample);
		List<Integer> teacherIds=new ArrayList<>();
		
		if(assessses!=null&&assessses.size()>0){
			
			for(Assess assess:assessses){
				
				teacherIds.add(assess.getTargetTeacher());
			}
			
			
		}
		
		return teacherIds;
	}
	@Override
	public List<Assess> selectAssessesByUserId(AssessExample assessExample) throws Exception {
		// TODO Auto-generated method stub
		return assessMapper.selectByExample(assessExample);
	}

}
