package cn.wuzongbo.tes.po;

import java.util.Date;
import java.util.List;

/**
 * 

* <p>Title: QueryTeacherGetScoreVO</p>  

* <p>Description:ѧ����ѯ���н�ʦ�������� </p>  

* @author ���ڲ�  

* @date 2018��5��26��
 */
public class QueryAllTeacherGetScoreVO extends User {	
	private double score;//��������	
	private String departName;
	private long studentSubmitCount;
	private long studentCount;
	private double rate;//ѧ����ѧ�ı���
	
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
