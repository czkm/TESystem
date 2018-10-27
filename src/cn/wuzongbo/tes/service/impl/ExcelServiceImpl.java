package cn.wuzongbo.tes.service.impl;

import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wuzongbo.tes.mapper.StudentMapper;
import cn.wuzongbo.tes.po.Student;
import cn.wuzongbo.tes.service.ExcelService;
import cn.wuzongbo.tes.util.ExportExcelUtil;

@Service
public class ExcelServiceImpl implements ExcelService {
	@Autowired
	private StudentMapper studentMapper;
	@Override
	public XSSFWorkbook exportStudentExcel(String[] titles) throws Exception {
		// TODO Auto-generated method stub

		List<Student> studentList = studentMapper.selectByExample(null);
		// 创建一个workbook 对应一个excel应用文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 在workbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet("导出学生数据");

		ExportExcelUtil util = new ExportExcelUtil(wb, sheet);
		XSSFCellStyle headerStyle = util.getHeadStyle();
		XSSFCellStyle bodyStyle = util.getHeadStyle();

		XSSFRow headRow = sheet.getRow(0);
		XSSFCell cell = null;

		for (int i = 0; i < titles.length; i++) {

			cell = headRow.createCell(i);
			cell.setCellStyle(headerStyle);
			cell.setCellValue(titles[i]);
		}

		if (studentList != null && studentList.size() > 0) {

			for (int i = 0; i < studentList.size(); i++) {

				Student student = studentList.get(i);

				XSSFRow bodyRow = sheet.createRow(i + 1);

//				cell = bodyRow.createCell(0);
//				cell.setCellStyle(bodyStyle);
//				cell.setCellValue(student.getId());
//
//				cell = bodyRow.createCell(1);
//				cell.setCellStyle(bodyStyle);
//				cell.setCellValue(student.getUserName());
//
//				cell = bodyRow.createCell(2);
//				cell.setCellStyle(bodyStyle);
//				cell.setCellValue("***********");
//				cell = bodyRow.createCell(3);
//				cell.setCellStyle(bodyStyle);
//				cell.setCellValue(student.getUserNo());
//
//				cell = bodyRow.createCell(4);
//				cell.setCellStyle(bodyStyle);
//				cell.setCellValue(student.getStatus());
//
//				cell = bodyRow.createCell(5);
//				cell.setCellStyle(bodyStyle);
//				cell.setCellValue(student.getClassesId());

			}

		}

	return wb;
	}

}
