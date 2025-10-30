package org.datadrivenframe;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExcel {

	public static void main(String[] args) {
		
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet();
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("FirstName");
		row.createCell(1).setCellValue("Last_name");
		row.createCell(2).setCellValue("Status");
		
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("Sample.xlsx");
			workbook.write(fileOutputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
