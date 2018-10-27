package cn.wuzongbo.tes.po;

import java.util.Date;
import java.util.List;

/**
 * 

* <p>Title: QueryTeacherGetScoreVO</p>  

* <p>Description:学生查询所有教师测评分数 </p>  

* @author 吴宗波  

* @date 2018年5月26日
 */
public class QueryAllTeacherGetScoreVO extends User {	
	private double score;//测评分数	
	private String departName;
	private long studentSubmitCount;
	private long studentCount;
	private double rate;//学生评学的比例
	
	private List<QueryClassesRateofStudentSubmit> queryClassesRateofStudentSubmits;
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
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
	public List<QueryClassesRateofStudentSubmit> getQueryClassesRateofStudentSubmits() {
		return queryClassesRateofStudentSubmits;
	}
	public void setQueryClassesRateofStudentSubmits(
			List<QueryClassesRateofStudentSubmit> queryClassesRateofStudentSubmits) {
		this.queryClassesRateofStudentSubmits = queryClassesRateofStudentSubmits;
	}

	

}
