package cn.wuzongbo.tes.po;

import java.util.Date;

/**
 * 

* <p>Title: QueryTeacherGetScoreVO</p>  

* <p>Description:查询教师评学结果包装类 </p>  

* @author 吴宗波  

* @date 2018年5月26日
 */
public class QueryClassesGetScoreVO extends Classes {
	
	private double scorce;//测评分数
	private Integer userId;//评测编号
	
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
