package cn.wuzongbo.tes.po;

import java.util.Date;

public class Scholarship {
    private Integer id;

    private String name;

    private String studentno;

    private String studenttype;

    private Double grade;

    private String batch;

    private String marjor;

    private String contact;

    private Date createtime;

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

    public String getStudenttype() {
        return studenttype;
    }

    public void setStudenttype(String studenttype) {
        this.studenttype = studenttype == null ? null : studenttype.trim();
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch == null ? null : batch.trim();
    }

    public String getMarjor() {
        return marjor;
    }

    public void setMarjor(String marjor) {
        this.marjor = marjor == null ? null : marjor.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}