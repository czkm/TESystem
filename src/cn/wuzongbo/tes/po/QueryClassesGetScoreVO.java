package cn.wuzongbo.tes.po;

import java.util.Date;

/**
 * 

* <p>Title: QueryTeacherGetScoreVO</p>  

* <p>Description:��ѯ��ʦ��ѧ�����װ�� </p>  

* @author ���ڲ�  

* @date 2018��5��26��
 */
public class QueryClassesGetScoreVO extends Classes {
	
	private double scorce;//��������
	private Integer userId;//������
	
	private Date createtime;

	public double getScorce() {
		return scorce;
	}

	public void setScorce(double scorce) {
		this.scorce = scorce;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	
	

}
