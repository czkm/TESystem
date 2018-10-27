package cn.wuzongbo.tes.util;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 

* <p>Title: ExportExcelUtil</p>  

* <p>Description:ʹ��poi����excel���� </p>  

* @author ���ڲ�  

* @date 2018��4��2��
 */
public class ExportExcelUtil {
	
	
	private XSSFWorkbook wb=null;
	
	private XSSFSheet sheet=null;

	public ExportExcelUtil(XSSFWorkbook wb, XSSFSheet sheet) {
		this.wb = wb;
		this.sheet = sheet;
	}
	 /** 
	  ** �ϲ���Ԫ�����ϲ���ĵ�Ԫ��ӱ߿� 
	  *  
	  * @param region 
	  * @param style 
	  */  
	public void setRegionStyle(CellRangeAddress region,XSSFCellStyle style){
		
		int topRowNum=region.getFirstRow();
		
		for(int i=topRowNum;i<region.getLastRow();i++){
			XSSFRow row=sheet.getRow(i);
			for(int j=region.getFirstColumn();j<region.getLastColumn();j++){
				XSSFCell cell=row.getCell(j);
				
				cell.setCellStyle(style);
				
			}
			
		}
		
	}
	/**
	 * 
	
	 * <p>Title: getHeadStyle</p>  
	
	 * <p>Description:���ñ�ͷ����ʽ </p>  
	
	 * @return
	 */
	public XSSFCellStyle  getHeadStyle(){
			
		  // ������Ԫ����ʽ  
		   XSSFCellStyle cellStyle = wb.createCellStyle();  
		 // ���õ�Ԫ��ı�����ɫΪ����ɫ  
		 cellStyle.setFillForegroundColor(HSSFColor.PALE_BLUE.index);  
		 cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
		 // ���õ�Ԫ����ж���  
		 cellStyle.setAlignment(HorizontalAlignment.CENTER);  
		 // ���õ�Ԫ��ֱ���ж���  
		 cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);  
		  // ������Ԫ��������ʾ����ʱ�Զ�����  
		 cellStyle.setWrapText(true);  
		 // ���õ�Ԫ��������ʽ  
		  XSSFFont font = wb.createFont();  
		 // ��������Ӵ�  
		  font.setBoldweight((short)200);  
		 font.setFontName("����");  
		 font.setFontHeight((short) 200);  
		 cellStyle.setFont(font);  
		 // ���õ�Ԫ��߿�Ϊϸ����  
		 cellStyle.setBorderLeft(BorderStyle.THIN);  
		 cellStyle.setBorderBottom(BorderStyle.THIN);  
		 cellStyle.setBorderRight(BorderStyle.THIN);  
		 cellStyle.setBorderTop(BorderStyle.THIN);  
		 return cellStyle;  
		
		
	}
	/** 
	 * ���ñ���ĵ�Ԫ����ʽ 
	 *  
	 * @return 
	 */  
	  public XSSFCellStyle getBodyStyle()  
	 {  
	  // ������Ԫ����ʽ  
	 XSSFCellStyle cellStyle = wb.createCellStyle();  
	  // ���õ�Ԫ����ж���  
	 cellStyle.setAlignment(HorizontalAlignment.CENTER);  
	  // ���õ�Ԫ��ֱ���ж���  
	 cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);  
	 // ������Ԫ��������ʾ����ʱ�Զ�����  
	  cellStyle.setWrapText(true);  
	  // ���õ�Ԫ��������ʽ  
	 XSSFFont font = wb.createFont();  
	 // ��������Ӵ�  
	 font.setBoldweight((short)200);  
	 font.setFontName("����");  
	 font.setFontHeight((short) 200);  
	 cellStyle.setFont(font);  
	 // ���õ�Ԫ��߿�Ϊϸ����  
	 cellStyle.setBorderLeft(BorderStyle.THIN);  
	 cellStyle.setBorderBottom(BorderStyle.THIN);  
	 cellStyle.setBorderRight(BorderStyle.THIN);  
	 cellStyle.setBorderTop(BorderStyle.THIN);  
	return cellStyle;  
	}  
	

}
