package cn.wuzongbo.tes.po;

public class Course {
    private Integer id;

    private Integer coursecode;

    private String coursename;

    private Byte score;

    private Byte status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(Integer coursecode) {
        this.coursecode = coursecode;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public Byte getScore() {
        return score;
    }

    public void setScore(Byte score) {
        this.score = score;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}