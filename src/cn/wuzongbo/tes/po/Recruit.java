package cn.wuzongbo.tes.po;

import java.util.Date;

public class Recruit {
    private Integer id;

    private String name;

    private String studentno;

    private String major;

    private Double score;

    private Date inschool;

    private String address;

    private String mobile;

    private String ems;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStudentno() {
        return studentno;
    }

    public void setStudentno(String studentno) {
        this.studentno = studentno == null ? null : studentno.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Date getInschool() {
        return inschool;
    }

    public void setInschool(Date inschool) {
        this.inschool = inschool;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEms() {
        return ems;
    }

    public void setEms(String ems) {
        this.ems = ems == null ? null : ems.trim();
    }
}