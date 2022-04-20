package ExcelHandling;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Vijay_excel_handling {

	private static final String FILE_NAME = "C:\\Users\\skuma\\eclipse-workspace\\Web_scrapping\\test-output\\ex1_test.xlsx";
	//private static final String FILE_NAME2 = "Location2";
	public static XSSFWorkbook workbook;

	static {
		workbook = new XSSFWorkbook();
	}

	public void ex_write_sinlgle(String SheetName) throws IOException {
		FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
		XSSFSheet sheet = workbook.createSheet(SheetName);
		Row row = sheet.createRow(1);
		row.createCell(5).setCellValue("Vijay");
		workbook.write(outputStream);
		// workbook.close();

	}

	public  void WriteExcelSheet() {

		// HSSFWorkbook workbookold = new HSSFWorkbook();
		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("Data");

		int rowNum = 0;

		for (int i = 1; i <= 10; i++) {
			Row row = sheet.createRow(rowNum++);
			int colNum = 0;

			for (int j = 1; j <= 20; j++) {
				Cell cell = row.createCell(colNum++);
				cell.setCellValue("row " + i + " column " + j);
			}
		}

		try {
			FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
			workbook.write(outputStream);
			workbook.close();

			System.out.println("vales are written in sheet");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void ReadExcelSheet() throws IOException {

		FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
		Workbook workbook = new XSSFWorkbook(excelFile);
		try {

			Sheet datatypeSheet = workbook.getSheet("Data");
			Iterator<Row> iterator = datatypeSheet.iterator();

			// int noOfRows = datatypeSheet.getLastRowNum();

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();

				while (cellIterator.hasNext()) {

					Cell currentCell = cellIterator.next();
					System.out.print(currentCell.getStringCellValue() + " ~ ");

				}
				System.out.println();

			}

			Row newrow = datatypeSheet.createRow(11);
			Cell newcell = newrow.createCell(11);
			newcell.setCellValue("vijayabharathi");
			;
			FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
			workbook.write(outputStream);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			workbook.close();
		}

	}

	
	public static void main(String[] args) throws IOException {
		Vijay_excel_handling run = new Vijay_excel_handling();
		//run.ex_write_sinlgle("Excel test");
		//run.ex_write_sinlgle("Excel test1");
		//run.ex_write_sinlgle("Excel test2");
		run.WriteExcelSheet();
	}
}
