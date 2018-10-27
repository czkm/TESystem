package cn.wuzongbo.tes.po;

import java.io.Serializable;
import java.util.Date;

public class Teacherclasses implements Serializable {
   
	private static final long serialVersionUID = -7497270834604058387L;

	private Integer id;

    private Integer teacherId;

    private Integer classesId;

    private Date ceatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getClassesId() {
        return classesId;
    }

    public void setClassesId(Integer classesId) {
        this.classesId = classesId;
    }

    public Date getCeatetime() {
        return ceatetime;
    }

    public void setCeatetime(Date ceatetime) {
        this.ceatetime = ceatetime;
    }
}