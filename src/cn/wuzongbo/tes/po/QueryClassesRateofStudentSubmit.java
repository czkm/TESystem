package cn.wuzongbo.tes.po;

public class QueryClassesRateofStudentSubmit extends Classes {
	private String departName;
	private String userName;
	private long studentSubmitCount;
	private long studentCount;
	private double rate;//学生评学的比例
	public long getStudentSubmitCount() {
		return studentSubmitCount;
	}
	public void setStudentSubmitCount(long studentSubmitCount) {
		this.studentSubmitCount = studentSubmitCount;
	}
	public long getStudentCount() {
		return studentCount;
	}
	public void setStudentCount(long studentCount) {
		this.studentCount = studentCount;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	

}
