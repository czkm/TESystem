package cn.wuzongbo.tes.po;

import java.util.Date;

public class Assess {
    private Integer id;

    private Integer userid;

    private Integer targetTeacher;

    private String criteriaList;

    private double scorce;

    private Byte usertype;

    private Date createtime;

    private String remarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getTargetTeacher() {
        return targetTeacher;
    }

    public void setTargetTeacher(Integer targetTeacher) {
        this.targetTeacher = targetTeacher;
    }

    public String getCriteriaList() {
        return criteriaList;
    }

    public void setCriteriaList(String criteriaList) {
        this.criteriaList = criteriaList == null ? null : criteriaList.trim();
    }

    public double getScorce() {
        return scorce;
    }

    public void setScorce(double scorce) {
        this.scorce = scorce;
    }

    public Byte getUsertype() {
        return usertype;
    }

    public void setUsertype(Byte usertype) {
        this.usertype = usertype;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}