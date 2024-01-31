package util;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	private String filePath;
	private FileInputStream file;
	private XSSFWorkbook worbook;
	private XSSFSheet sheet;
	private XSSFRow row;
	private XSSFCell cell;
	private String CellValue;
	private int cellNum;
	private int columnum;
	private int rownum;

	public ExcelReader(String filePath) {
		this.filePath = filePath;
	}

	public String readeExcelcell(String sheetName, String columnName, int rowNum) {

		try {
			file = new FileInputStream(filePath);
			worbook = new XSSFWorkbook(file);
			sheet = worbook.getSheet(sheetName);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(columnName)) {
					cellNum = i;
				}
			}
			row = sheet.getRow(rowNum - 1);
			cell = row.getCell(cellNum);

		} catch (Exception e) {
			e.printStackTrace();
		}

		DataFormatter df = new DataFormatter();
		CellValue = df.formatCellValue(cell);
		return CellValue;

	}

	public int getColumNum(String sheetName) {
		try {
			file = new FileInputStream(filePath);
			worbook = new XSSFWorkbook(file);
			sheet = worbook.getSheet(sheetName);

			row = sheet.getRow(0);
			columnum = row.getLastCellNum();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return columnum;

	}

	public int getRowNum(String sheetName) {
		try {
			file = new FileInputStream(filePath);
			worbook = new XSSFWorkbook(file);
			sheet = worbook.getSheet(sheetName);
			rownum = sheet.getLastRowNum();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rownum;

	}

	public String getExcelcellValue(String sheetName, int rowNum, int columnNum) {

		try {
			file = new FileInputStream(filePath);
			worbook = new XSSFWorkbook(file);
			sheet = worbook.getSheet(sheetName);
			row = sheet.getRow(0);
			cellNum = columnNum - 1;
			row = sheet.getRow(rowNum - 1);
			cell = row.getCell(cellNum);

		} catch (Exception e) {
			e.printStackTrace();
		}

		DataFormatter df = new DataFormatter();
		CellValue = df.formatCellValue(cell);
		return CellValue;

	}

}
