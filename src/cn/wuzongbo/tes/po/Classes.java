package cn.wuzongbo.tes.po;

import java.io.Serializable;

public class Classes implements Serializable{
   

	/**
	 * 
	 */
	private static final long serialVersionUID = -7291862224923643286L;

	private Integer id;

    private String classesName;

    private Integer departId;

    private Byte status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName == null ? null : classesName.trim();
    }

    public Integer getDepartId() {
        return departId;
    }

    public void setDepartId(Integer departId) {
        this.departId = departId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
  @Override
   	public boolean equals(Object obj) {
   		// TODO Auto-generated method stub
    	
    	if(obj instanceof Classes){
    		Classes classes =(Classes)obj;
    		return classesName==classes.classesName;
    		
    	}
   		return false;
   	} 
}