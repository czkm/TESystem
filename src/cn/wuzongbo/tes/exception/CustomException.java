package cn.wuzongbo.tes.exception;
/**
 * 

* <p>Title: CustomException</p>  

* <p>Description:�Զ����쳣�� </p>  

* @author ���ڲ�  

* @date 2018��3��12��
 */
public class CustomException  extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3874014933796271416L;
	private String message;//������Ϣ
	
	public CustomException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
