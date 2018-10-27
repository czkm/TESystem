package cn.wuzongbo.tes.service;

import java.util.List;

import cn.wuzongbo.tes.po.AdviserClasses;
import cn.wuzongbo.tes.po.AdviserClassesExample;

public interface AdviserClassesService {
	
	public int insert(AdviserClasses adviserClasses) throws Exception;
	
	
	public List<AdviserClasses> queryAdviserClassesList(AdviserClassesExample adviserClassesExample)throws Exception;
	
	
	public int delete(AdviserClassesExample adviserClassesExample) throws Exception;
	

}
