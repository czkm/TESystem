package cn.wuzongbo.tes.po;

import java.util.Date;

/**
 * 

* <p>Title: QueryTeacherGetScoreVO</p>  

* <p>Description:��ѯ��ʦ�������� </p>  

* @author ���ڲ�  

* @date 2018��5��26��
 */
public class QueryTeacherGetScoreVO {
	
	private double score;//��������
	private int userId;//�û����
	
	private int teacherId;//��ʦ���
	
	private String teacherName;
	private String departId;
	public String getDepartId() {
		return departId;
	}

	public void setDepartId(String departId) {
		this.departId = departId;
	}

	private Date createTime;

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	

}
