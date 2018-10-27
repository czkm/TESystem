package cn.wuzongbo.tes.po;

import java.util.List;

public class SystemModuleVo extends SystemModule{
   private List<SystemModule> children;

public List<SystemModule> getChildren() {
	return children;
}

public void setChildren(List<SystemModule> children) {
	this.children = children;
}
   
}