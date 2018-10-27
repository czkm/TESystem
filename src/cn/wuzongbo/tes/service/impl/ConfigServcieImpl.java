package cn.wuzongbo.tes.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wuzongbo.tes.mapper.ConfigMapper;
import cn.wuzongbo.tes.po.Config;
import cn.wuzongbo.tes.po.ConfigExample;
import cn.wuzongbo.tes.service.ConfigService;
@Service
public class ConfigServcieImpl implements ConfigService {
	@Autowired
   private ConfigMapper configMapper;
	@Override
	public List<Config> queryConfigList(ConfigExample configExample) throws Exception {
		// TODO Auto-generated method stub
		return configMapper.selectByExample(configExample);
	}

	@Override
	public Config findConfigById(Short id) throws Exception {
		// TODO Auto-generated method stub
		return configMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deteteConfigById(Short id) throws Exception {
		// TODO Auto-generated method stub
		return configMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateConfigById(Short id, Config onfig) throws Exception {
		// TODO Auto-generated method stub
		onfig.setId(id);
		return configMapper.updateByPrimaryKeySelective(onfig);
	}

	@Override
	public int insertConfig(Config config) throws Exception {
		// TODO Auto-generated method stub
		return configMapper.insert(config);
	}

	@Override
	public Map<String, Integer> getRank(String inc_type) throws Exception {
		// TODO Auto-generated method stub
		ConfigExample configExample=new ConfigExample();
		configExample.setOrderByClause("value");
		ConfigExample.Criteria criteria=configExample.createCriteria();
		criteria.andIncTypeEqualTo(inc_type);
		List<Config> configs=queryConfigList(configExample);
		Map<String, Integer> ranks=new LinkedHashMap<String,Integer>();
		
		for(Config config:configs){
			
			ranks.put(config.getName(),Integer.valueOf(config.getValue()));
			
		}
		return ranks;
		
	}

	@Override
	public long checkConfigName(String name) throws Exception {
		// TODO Auto-generated method stub
		
		ConfigExample configExample=new ConfigExample();
		ConfigExample.Criteria criteria=configExample.createCriteria();
		criteria.andNameEqualTo(name);
		long row =configMapper.countByExample(configExample);
		return row;
	}

}
