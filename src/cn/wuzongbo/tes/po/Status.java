package cn.wuzongbo.tes.po;

import java.io.Serializable;
/**
 * 

* <p>Title: Status</p>  

* <p>Description: 返回状态</p>  

* @author 吴宗波  

* @date 2018年4月6日
 */
public class Status implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -903932493645375749L;
	private int statusCode;//状态码
	private String message;//信息
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
