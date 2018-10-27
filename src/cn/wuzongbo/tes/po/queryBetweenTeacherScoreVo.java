package cn.wuzongbo.tes.po;
/**
 * 

* <p>Title: queryBetweenTeacherScoreVo</p>  

* <p>Description: 获取教师之间互评分数</p>  

* @author 吴宗波  

* @date 2018年7月8日
 */
public class queryBetweenTeacherScoreVo extends User {
	
	private String userName;
	private double avgscore;
	
	private String departName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getAvgscore() {
		return avgscore;
	}

	public void setAvgscore(double avgscore) {
		this.avgscore = avgscore;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}
	
	
	
	
	

}
