package cn.wuzongbo.tes.po;

import java.util.Date;

public class Usersign {
    private Integer id;

    private Integer userid;

    private Integer classesid;

    private Integer coursecode;

    private Date signtime;

    private Integer tel;

    private String ipaddress;

    private String longitude;

    private String latitude;

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

    public Integer getClassesid() {
        return classesid;
    }

    public void setClassesid(Integer classesid) {
        this.classesid = classesid;
    }

    public Integer getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(Integer coursecode) {
        this.coursecode = coursecode;
    }

    public Date getSigntime() {
        return signtime;
    }

    public void setSigntime(Date signtime) {
        this.signtime = signtime;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}