package org.datadrivenframe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateNewExcelSheet {

	public static void main(String[] args) {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("New Data");
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("Firest Name");
		row.createCell(1).setCellValue("Last Name");
		row.createCell(2).setCellValue("Result");

		try {
			FileOutputStream fileOutputStream = new FileOutputStream("TestData.xlsx");
			workbook.write(fileOutputStream);
			workbook.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println("done");
	}
}
