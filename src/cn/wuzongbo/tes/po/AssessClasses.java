package cn.wuzongbo.tes.po;

import java.util.Date;

public class AssessClasses {
    private Integer id;

    private Integer userid;

    private Integer targetClasses;

    private Float scorce;

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

    public Integer getTargetClasses() {
        return targetClasses;
    }

    public void setTargetClasses(Integer targetClasses) {
        this.targetClasses = targetClasses;
    }

    public Float getScorce() {
        return scorce;
    }

    public void setScorce(Float scorce) {
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