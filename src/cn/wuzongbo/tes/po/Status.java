package cn.wuzongbo.tes.po;

import java.io.Serializable;
/**
 * 

* <p>Title: Status</p>  

* <p>Description: ����״̬</p>  

* @author ���ڲ�  

* @date 2018��4��6��
 */
public class Status implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -903932493645375749L;
	private int statusCode;//״̬��
	private String message;//��Ϣ
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
