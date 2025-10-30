package org.datadrivenframe;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAllData {
	public static void main(String[] args) throws IOException {
		FileInputStream fileInputStream = new FileInputStream("C:\\\\Users\\\\jerom\\\\Downloads\\\\TestData.xlsx");

		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet("New Data");

		for (Row row : sheet) {
			for (Cell cell : row) {
				CellType cellType = cell.getCellType();
				switch (cell.getCellType()) {
				case STRING:
					String stringCellValue = cell.getStringCellValue();
					System.out.println(stringCellValue);
					break;
				case NUMERIC:
					double numericCellValue = cell.getNumericCellValue();
					long l = (long) numericCellValue;
					String valueOf = String.valueOf(l);
					System.out.println(valueOf);
					break;
				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue() + "\t");
					break;
				case FORMULA:
					System.out.print(cell.getCellFormula() + "\t");
					break;
				default:
					System.out.print(" \t");
				}
			}
		}
	}
}
