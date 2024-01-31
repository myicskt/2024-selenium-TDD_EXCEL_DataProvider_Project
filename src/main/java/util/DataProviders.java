package util;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "Data")
	public String[][] getAllData() {
		ExcelReader excelReader = new ExcelReader("./src/main/java/testData/testdata.xlsx");
		int columCount = excelReader.getColumNum("dataprovider");
		int rowCount = excelReader.getRowNum("dataprovider");
		String userData[][] = new String[rowCount][columCount];

		//
		for (int i = 1; i <= rowCount; i++) {

			for (int j = 0; j < columCount; j++) {
				// System.out.print(" " + excelReader.getExcelcellValue("login", i, j + 1));
				userData[i - 1][j] = excelReader.getExcelcellValue("dataprovider", i + 1, j + 1);

			}

		}

//		for (String[] a : userData) {
//			for (String b : a) {
//				System.out.print(" | " + b);
//			}
//			System.out.println();
//
//		}
		return userData;

	}

	@DataProvider(name = "userName")
	public String[] getAllEmail() {
		ExcelReader excelReader = new ExcelReader("./src/main/java/testData/testdata.xlsx");
		int columCount = excelReader.getColumNum("dataprovider");
		int rowCount = excelReader.getRowNum("dataprovider");
		String userData[] = new String[rowCount];
		for (int i = 1; i <= rowCount; i++) {
			userData[i - 1] = excelReader.getExcelcellValue("dataprovider", i, 2);
		}
		for (String b : userData) {
			System.out.println(b);
		}
		return userData;
	}
}