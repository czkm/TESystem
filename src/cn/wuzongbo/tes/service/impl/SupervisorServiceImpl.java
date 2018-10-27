package cn.wuzongbo.tes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wuzongbo.tes.mapper.SupervisorMapper;
import cn.wuzongbo.tes.po.StudentExample;
import cn.wuzongbo.tes.po.Supervisor;
import cn.wuzongbo.tes.po.SupervisorExample;
import cn.wuzongbo.tes.service.SupervisorService;
@Service
public class SupervisorServiceImpl implements SupervisorService {
	@Autowired
   private SupervisorMapper supervisorMapper;
	@Override
	public Supervisor login(String supervisorNo, String password) throws Exception {
		// TODO Auto-generated method stub
		SupervisorExample supervisorExample=new SupervisorExample();
		SupervisorExample.Criteria criteria=supervisorExample.createCriteria();
		criteria.andUsernoEqualTo(supervisorNo);
		criteria.andPasswordEqualTo(password);
		if(supervisorMapper.selectByExample(supervisorExample).size()>0){
			
			return supervisorMapper.selectByExample(supervisorExample).get(0);	
		}
	    return null;

	}

	@Override
	public int changePassword(String newpassword, String oldpassword, Integer id) throws Exception {
		int rows=0;
		// TODO Auto-generated method stub
		SupervisorExample supervisorExample=new SupervisorExample();
		SupervisorExample.Criteria criteria=supervisorExample.createCriteria();
		criteria.andIdEqualTo(id);
		criteria.andPasswordEqualTo(oldpassword);
		 long l=supervisorMapper.countByExample(supervisorExample);
				 if(l>0){
					 
					 Supervisor supervisor=new Supervisor();
					 supervisor.setId(id);
					 supervisor.setPassword(newpassword);
					 rows=supervisorMapper.updateByPrimaryKeySelective(supervisor);
				 }
		return rows;
	}

	@Override
	public int resetPassword(String password, Integer id) throws Exception {
		// TODO Auto-generated method stub
		Supervisor supervisor=new Supervisor();
		 supervisor.setId(id);
		 supervisor.setPassword(password);
	return	supervisorMapper.updateByPrimaryKey(supervisor);
	
	}

	@Override
	public List<Supervisor> querySupervisorList(SupervisorExample supervisorExample) throws Exception {
		// TODO Auto-generated method stub
		return supervisorMapper.selectByExample(supervisorExample);
	}

	@Override
	public Supervisor findSupervisorById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return supervisorMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deteteSupervisorById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return supervisorMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateSupervisorById(Integer id, Supervisor supervisor) throws Exception {
		// TODO Auto-generated method stub
		supervisor.setId(id);
		return supervisorMapper.updateByPrimaryKeySelective(supervisor);
	}

	@Override
	public int insertSupervisor(Supervisor supervisor) throws Exception {
		// TODO Auto-generated method stub
		return supervisorMapper.insert(supervisor);
	}

}
