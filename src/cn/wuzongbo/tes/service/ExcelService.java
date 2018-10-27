package cn.wuzongbo.tes.service;

import javax.servlet.ServletOutputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * 

* <p>Title: ExcelService</p>  

* <p>Description:Excel操作服务接口 </p>  

* @author 吴宗波  

* @date 2018年4月2日
 */
public interface ExcelService {
	
	/**
	 * 
	 * <p>Title: exportExcel</p>  
	
	 * <p>Description: 导出excel数据</p>  
	
	 * @param titles 标题
	 * @param out 输出流
	 * @throws Exception 
	 */
	
	public XSSFWorkbook exportStudentExcel(String[] titles) throws Exception;

}
