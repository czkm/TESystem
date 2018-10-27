package cn.wuzongbo.tes.po;

import java.util.Date;

/**
 * 

* <p>Title: QueryTeacherGetScoreVO</p>  

* <p>Description:获取所有班级评学结果的包装类 </p>  

* @author 吴宗波  

* @date 2018年5月26日
 */
public class QueryAllClassesGetScoreVO extends Classes {
	
	private double scorce;//评学分数
    private String departName;
	public double getScorce() {
		return scorce;
	}

	public void setScorce(double scorce) {
		this.scorce = scorce;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	
	
	

}
