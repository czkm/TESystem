package cn.wuzongbo.tes.exception;
/**
 * 

* <p>Title: CustomException</p>  

* <p>Description:自定义异常类 </p>  

* @author 吴宗波  

* @date 2018年3月12日
 */
public class CustomException  extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3874014933796271416L;
	private String message;//错误信息
	
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
