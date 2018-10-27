package cn.wuzongbo.tes.po;

import java.util.HashMap;
import java.util.List;

public class CriteriaVo extends Criteria {
	private List<Criteria> children;

	public List<Criteria> getChildren() {
		return children;
	}

	public void setChildren(List<Criteria> children) {
		this.children = children;
	}
	
	private HashMap<String,Integer> ranks;

	public HashMap<String, Integer> getRanks() {
		return ranks;
	}

	public void setRanks(HashMap<String, Integer> ranks) {
		this.ranks = ranks;
	}
	
	
	
	

}
