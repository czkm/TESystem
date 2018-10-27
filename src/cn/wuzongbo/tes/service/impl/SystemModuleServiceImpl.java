package cn.wuzongbo.tes.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wuzongbo.tes.mapper.SystemModuleMapper;
import cn.wuzongbo.tes.po.SystemModule;
import cn.wuzongbo.tes.po.SystemModuleExample;
import cn.wuzongbo.tes.po.SystemModuleVo;
import cn.wuzongbo.tes.service.SystemModuleService;
@Service
public class SystemModuleServiceImpl implements SystemModuleService {
	@Autowired
    private SystemModuleMapper systemModuleMapper;
	@Override
	public List<SystemModule> querySystemModuleList(SystemModuleExample systemModuleExample) throws Exception {
		// TODO Auto-generated method stub
		return systemModuleMapper.selectByExample(systemModuleExample);
	}

	@Override
	public SystemModule findSystemModuleById(Short id) throws Exception {
		// TODO Auto-generated method stub
		return systemModuleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deteteSystemModuleById(Short id) throws Exception {
		// TODO Auto-generated method stub
		return systemModuleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateSystemModuleById(Short id, SystemModule systemModule) throws Exception {
		// TODO Auto-generated method stub
		systemModule.setModId(id);
		return systemModuleMapper.updateByPrimaryKey(systemModule);
	}

	@Override
	public int insertSystemModule(SystemModule systemModule) throws Exception {
		// TODO Auto-generated method stub
		return systemModuleMapper.insert(systemModule);
	}

	@Override
	public int insertSubSystemModule(Short pid, SystemModule systemModule) throws Exception {
		// TODO Auto-generated method stub
		systemModule.setParentId(pid);
		return systemModuleMapper.insert(systemModule);
	}

	@Override
	public List<SystemModuleVo> findSystemModuleVo(Short pid) throws Exception {
		// TODO Auto-generated method stub
		List<SystemModuleVo> systemModuleVoList=new ArrayList<SystemModuleVo>();
		
		List<SystemModule> firstSystemModule=querySystemModuleListByPid(pid);
		SystemModuleVo systemModuleVo=null;
		for(SystemModule systemModule:firstSystemModule){
			systemModuleVo=new SystemModuleVo();	
			Short id=systemModule.getModId();
			BeanUtils.copyProperties(systemModule, systemModuleVo);
			
			
			List<SystemModule> systemModuleList =querySystemModuleListByPid(id);
			systemModuleVo.setChildren(systemModuleList);
			systemModuleVoList.add(systemModuleVo);
		}
	
	   return systemModuleVoList;
		
		
		
	     
	}
	public List<SystemModule> querySystemModuleListByPid(Short pid){
		SystemModuleExample systemModuleExample=new SystemModuleExample();
		
		SystemModuleExample.Criteria criteria1=systemModuleExample.createCriteria();
		criteria1.andParentIdEqualTo(pid);
		List<SystemModule> firstSystemModule=systemModuleMapper.selectByExample(systemModuleExample);
		return firstSystemModule;
	}
	
	

}
