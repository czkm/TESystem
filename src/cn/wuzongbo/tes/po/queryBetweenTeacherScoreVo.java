package cn.wuzongbo.tes.po;
/**
 * 

* <p>Title: queryBetweenTeacherScoreVo</p>  

* <p>Description: ��ȡ��ʦ֮�以������</p>  

* @author ���ڲ�  

* @date 2018��7��8��
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
