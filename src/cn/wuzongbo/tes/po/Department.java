package cn.wuzongbo.tes.po;

import java.io.Serializable;

public class Department implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1053471461548419045L;

	private Integer id;

    private String type;

    private String departName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName == null ? null : departName.trim();
    }
}