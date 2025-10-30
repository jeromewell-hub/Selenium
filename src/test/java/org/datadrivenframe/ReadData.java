package org.datadrivenframe;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {
	public static void main(String[] args) throws IOException {
		FileInputStream fileInputStream = new FileInputStream("C:\\Users\\jerom\\Downloads\\TestData.xlsx");
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet("New Data");
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			if (row == null)
				continue;

			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				if (row == null)
					continue;
				CellType cellType = cell.getCellType();

				if (cellType == cellType.STRING) {

					String stringCellValue = cell.getStringCellValue();
					System.out.println(stringCellValue);

				} else if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
					System.out.println(dateFormat.format(dateCellValue));
				} else if (cellType == cellType.NUMERIC) {
					double numericCellValue = cell.getNumericCellValue();
					long long1 = (long) numericCellValue;
					String valueOf = String.valueOf(long1);
					System.out.println(valueOf);
				}
			}
		}
		workbook.close();
		fileInputStream.close();

	}
}
