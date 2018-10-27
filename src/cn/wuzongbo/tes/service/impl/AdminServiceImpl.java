package cn.wuzongbo.tes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wuzongbo.tes.mapper.AdminMapper;
import cn.wuzongbo.tes.po.Admin;
import cn.wuzongbo.tes.po.AdminExample;
import cn.wuzongbo.tes.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
     private AdminMapper adminMapper;

	@Override
	public Admin login(String name ,String password) throws Exception {
		AdminExample adminExample =new AdminExample();
		AdminExample.Criteria criteria=adminExample.createCriteria();
		criteria.andLoginnameEqualTo(name);
		criteria.andPasswordEqualTo(password);	
		return adminMapper.selectByExample(adminExample).get(0);
	}

	@Override
	public int changePassword(String newpassword, String oldpassword, Integer id) throws Exception {
		// TODO Auto-generated method stub
	    int rows=0;
		AdminExample adminExample =new AdminExample();
		AdminExample.Criteria criteria=adminExample.createCriteria();
		criteria.andPasswordEqualTo(oldpassword);
		criteria.andIdEqualTo(id);
	    long count=adminMapper.countByExample(adminExample);
	    if(count>0){
	    	Admin admin=new Admin();
	    	admin.setId(id);
	    	admin.setPassword(newpassword);
	    	
	      rows= adminMapper.updateByPrimaryKey(admin);
	    }
		
		
		return rows;
	}

	@Override
	public int resetPassword(String password, Integer id) throws Exception {
		// TODO Auto-generated method stub
		Admin admin=new Admin();
    	admin.setId(id);
    	admin.setPassword(password);
		
		return adminMapper.updateByPrimaryKey(admin);
	}

	@Override
	public List<Admin> queryAdminsList(AdminExample adminExample) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.selectByExample(adminExample);
	}

	@Override
	public Admin findAdminById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
		return adminMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deteteAdminById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateAdminById(Integer id, Admin admin) throws Exception {
		// TODO Auto-generated method stub
		admin.setId(id);
		return adminMapper.updateByPrimaryKey(admin);
	}

	@Override
	public int insertAdmin(Admin admin) throws Exception {
		// TODO Auto-generated method stub
		return adminMapper.insert(admin);
	}

	@Override
	public long checkLoginname(String loginname) throws Exception {
		// TODO Auto-generated method stub
		AdminExample adminExample=new AdminExample();
		AdminExample.Criteria criteria=adminExample.createCriteria();
		criteria.andAdminNameEqualTo(loginname);
		
		long row=adminMapper.countByExample(adminExample);
		
		return row;
	}

	@Override
	public int changeStatus(Integer id, byte status) throws Exception {
		// TODO Auto-generated method stub
		Admin admin=new Admin();
		admin.setId(id);
		admin.setStatus(status);
		
		return adminMapper.updateByPrimaryKeySelective(admin);
	}

	
	

}
