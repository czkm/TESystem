package cn.wuzongbo.tes.util;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.wuzongbo.tes.exception.CustomException;  

public class ImportExcelUtil {
	private final static String excel2003L =".xls";    //2003- �汾��excel  
    private final static String excel2007U =".xlsx";   //2007+ �汾��excel  
    /**
     * 
    
     * <p>Title: getWorkbook</p>  
    
     * <p>Description: ���Workbook����</p>  
    
     * @param is InputStream������
     * @param fileName �ļ�����
     * @return Workbook ʵ��
     * @throws Exception
     */
	public Workbook getWorkbook(InputStream is,String fileName) throws Exception{
		
		    Workbook wb = null;  
	        String fileType = fileName.substring(fileName.lastIndexOf("."));  
	        if(excel2003L.equals(fileType)){  
	            wb = new HSSFWorkbook(is);  //2003-  
	        }else if(excel2007U.equals(fileType)){  
	            wb = new XSSFWorkbook(is);  //2007+  
	        }else{  
	            throw new CustomException("�������ļ���ʽ����");  
	        }  
	        return wb;  
		
		
	}
	
	public List<List<Object>> getBankListByExcel(InputStream in,String fileName) throws Exception{
		
		List<List<Object>> list=null;
		
		//����Excel������  
        Workbook work = this.getWorkbook(in,fileName);  
        if(null == work){  
            throw new CustomException("����Excel������Ϊ�գ�");  
        }  
        Sheet sheet = null;  
        Row row = null;  
        Cell cell = null;  
          
        list = new ArrayList<List<Object>>();  
        
        
        //����Excel�����е�sheet  
        for (int i = 0; i < work.getNumberOfSheets(); i++) {  
            sheet = work.getSheetAt(i); 
            if(sheet==null){continue;}  
              
            //������ǰsheet�е�������  
   
            
            for (int j = sheet.getFirstRowNum(); j < sheet.getLastRowNum()+1; j++) {  
                row = sheet.getRow(j);  
                if(row==null||row.getFirstCellNum()==j){continue;}  
                  
                //�������е���  
                List<Object> li = new ArrayList<Object>();  
                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {  
                    cell = row.getCell(y);  
                    li.add(this.getCellValue(cell));  
                }  
                list.add(li);  
            }  
        }  
        work.close();  
        return list;  
		
	
	}
	
    /** 
     * �������Ա������ֵ���и�ʽ�� 
     * @param cell 
     * @return 
     */  
    public  Object getCellValue(Cell cell){  
        Object value = null;  
        DecimalFormat df = new DecimalFormat("0");  //��ʽ��number String�ַ�  
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");  //���ڸ�ʽ��  
        DecimalFormat df2 = new DecimalFormat("0");  //��ʽ������  
          
        switch (cell.getCellType()) {  
        case Cell.CELL_TYPE_STRING:  
            value = cell.getRichStringCellValue().getString();  
            break;  
        case Cell.CELL_TYPE_NUMERIC:  
            if("General".equals(cell.getCellStyle().getDataFormatString())){  
                value = df.format(cell.getNumericCellValue());  
            }else if("m/d/yy".equals(cell.getCellStyle().getDataFormatString())){  
                value = sdf.format(cell.getDateCellValue());  
            }else{  
                value = df2.format(cell.getNumericCellValue());  
            }  
            break;  
        case Cell.CELL_TYPE_BOOLEAN:  
            value = cell.getBooleanCellValue();  
            break;  
        case Cell.CELL_TYPE_BLANK:  
            value = "";  
            break;  
        default:  
            break;  
        }  
        return value;  
    }  

}
