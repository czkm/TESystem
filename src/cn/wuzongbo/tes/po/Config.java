package cn.wuzongbo.tes.po;

import java.io.Serializable;

public class Config implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 5389145762798258462L;

	private Short id;

    private String name;

    private String value;

    private String incType;

    private Byte status;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getIncType() {
        return incType;
    }

    public void setIncType(String incType) {
        this.incType = incType == null ? null : incType.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}