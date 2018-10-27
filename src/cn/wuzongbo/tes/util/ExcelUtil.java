package cn.wuzongbo.tes.util;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelUtil {
	  /**
     * ����excel�ĵ���
     * [@param](http://my.oschina.net/u/2303379) list ����
     * @param keys list��map��key���鼯��
     * @param columnNames excel������
     * */
    public static Workbook createWorkBook(List<Map<String, Object>> list,String []keys,String columnNames[]) {
        // ����excel������
        Workbook wb = new HSSFWorkbook();
        // ������һ��sheet��ҳ����������
        Sheet sheet = wb.createSheet(list.get(0).get("sheetName").toString());
        // �ֶ������п���һ��������ʾҪΪ�ڼ����裻���ڶ���������ʾ�еĿ�ȣ�nΪ�иߵ���������
        for(int i=0;i<keys.length;i++){
            sheet.setColumnWidth((short) i, (short) (35.7 * 150));
        }

        // ������һ��
        Row row = sheet.createRow((short) 0);

        // �������ֵ�Ԫ���ʽ
        CellStyle cs = wb.createCellStyle();
        CellStyle cs2 = wb.createCellStyle();

        // ������������
        Font f = wb.createFont();
        Font f2 = wb.createFont();

        // ������һ��������ʽ������������
        f.setFontHeightInPoints((short) 10);
        f.setColor(IndexedColors.BLACK.getIndex());
       // f.setBoldweight((short)200); 

        // �����ڶ���������ʽ������ֵ��
        f2.setFontHeightInPoints((short) 10);
        f2.setColor(IndexedColors.BLACK.getIndex());

//        Font f3=wb.createFont();
//        f3.setFontHeightInPoints((short) 10);
//        f3.setColor(IndexedColors.RED.getIndex());

        // ���õ�һ�ֵ�Ԫ�����ʽ������������
        cs.setFont(f);
        cs.setBorderLeft(BorderStyle.THIN);  
        cs.setBorderBottom(BorderStyle.THIN);  
        cs.setBorderRight(BorderStyle.THIN);  
		 cs.setBorderTop(BorderStyle.THIN);  

        // ���õڶ��ֵ�Ԫ�����ʽ������ֵ��
        cs2.setFont(f2);
        cs2.setBorderLeft(BorderStyle.THIN);  
        cs2.setBorderBottom(BorderStyle.THIN);  
        cs2.setBorderRight(BorderStyle.THIN);  
        cs2.setBorderTop(BorderStyle.THIN);  
        //��������
        for(int i=0;i<columnNames.length;i++){
            Cell cell = row.createCell(i);
            cell.setCellValue(columnNames[i]);
            cell.setCellStyle(cs);
        }
        //����ÿ��ÿ�е�ֵ
        for (short i = 1; i < list.size(); i++) {
            // Row ��,Cell ���� , Row �� Cell ���Ǵ�0��ʼ������
            // ����һ�У���ҳsheet��
            Row row1 = sheet.createRow((short) i);
            // ��row���ϴ���һ������
            for(short j=0;j<keys.length;j++){
                Cell cell = row1.createCell(j);
                cell.setCellValue(list.get(i).get(keys[j]) == null?" ": list.get(i).get(keys[j]).toString());
                cell.setCellStyle(cs2);
            }
        }
        return wb;
    }


}
