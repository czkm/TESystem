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

* <p>Description:使用poi导出excel数据 </p>  

* @author 吴宗波  

* @date 2018年4月2日
 */
public class ExportExcelUtil {
	
	
	private XSSFWorkbook wb=null;
	
	private XSSFSheet sheet=null;

	public ExportExcelUtil(XSSFWorkbook wb, XSSFSheet sheet) {
		this.wb = wb;
		this.sheet = sheet;
	}
	 /** 
	  ** 合并单元格后给合并后的单元格加边框 
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
	
	 * <p>Description:设置表头的样式 </p>  
	
	 * @return
	 */
	public XSSFCellStyle  getHeadStyle(){
			
		  // 创建单元格样式  
		   XSSFCellStyle cellStyle = wb.createCellStyle();  
		 // 设置单元格的背景颜色为淡蓝色  
		 cellStyle.setFillForegroundColor(HSSFColor.PALE_BLUE.index);  
		 cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
		 // 设置单元格居中对齐  
		 cellStyle.setAlignment(HorizontalAlignment.CENTER);  
		 // 设置单元格垂直居中对齐  
		 cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);  
		  // 创建单元格内容显示不下时自动换行  
		 cellStyle.setWrapText(true);  
		 // 设置单元格字体样式  
		  XSSFFont font = wb.createFont();  
		 // 设置字体加粗  
		  font.setBoldweight((short)200);  
		 font.setFontName("宋体");  
		 font.setFontHeight((short) 200);  
		 cellStyle.setFont(font);  
		 // 设置单元格边框为细线条  
		 cellStyle.setBorderLeft(BorderStyle.THIN);  
		 cellStyle.setBorderBottom(BorderStyle.THIN);  
		 cellStyle.setBorderRight(BorderStyle.THIN);  
		 cellStyle.setBorderTop(BorderStyle.THIN);  
		 return cellStyle;  
		
		
	}
	/** 
	 * 设置表体的单元格样式 
	 *  
	 * @return 
	 */  
	  public XSSFCellStyle getBodyStyle()  
	 {  
	  // 创建单元格样式  
	 XSSFCellStyle cellStyle = wb.createCellStyle();  
	  // 设置单元格居中对齐  
	 cellStyle.setAlignment(HorizontalAlignment.CENTER);  
	  // 设置单元格垂直居中对齐  
	 cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);  
	 // 创建单元格内容显示不下时自动换行  
	  cellStyle.setWrapText(true);  
	  // 设置单元格字体样式  
	 XSSFFont font = wb.createFont();  
	 // 设置字体加粗  
	 font.setBoldweight((short)200);  
	 font.setFontName("宋体");  
	 font.setFontHeight((short) 200);  
	 cellStyle.setFont(font);  
	 // 设置单元格边框为细线条  
	 cellStyle.setBorderLeft(BorderStyle.THIN);  
	 cellStyle.setBorderBottom(BorderStyle.THIN);  
	 cellStyle.setBorderRight(BorderStyle.THIN);  
	 cellStyle.setBorderTop(BorderStyle.THIN);  
	return cellStyle;  
	}  
	

}
