package cn.wuzongbo.tes.service;

import javax.servlet.ServletOutputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * 

* <p>Title: ExcelService</p>  

* <p>Description:Excel��������ӿ� </p>  

* @author ���ڲ�  

* @date 2018��4��2��
 */
public interface ExcelService {
	
	/**
	 * 
	 * <p>Title: exportExcel</p>  
	
	 * <p>Description: ����excel����</p>  
	
	 * @param titles ����
	 * @param out �����
	 * @throws Exception 
	 */
	
	public XSSFWorkbook exportStudentExcel(String[] titles) throws Exception;

}
