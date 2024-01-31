package testPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.CustomerList;
import pages.Dashboard;
import pages.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class CostumerListTest {
	WebDriver driver;
	String excelFile = ".\\src\\main\\java\\testData\\testdata.xlsx";
	ExcelReader excelData = new ExcelReader(excelFile);
	String userId = excelData.readeExcelcell("login", "User Name", 2);
	String password = excelData.readeExcelcell("login", "Password", 2);
	String dashboardValidText = excelData.readeExcelcell("login", "Validate Text", 2);
	String listPageHeader = excelData.readeExcelcell("add customer", "ValidateText2", 2);

	@Test
	public void costumerListTest() {

		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userId);
		loginPage.insertUserPassword(password);
		loginPage.clickOnSinginButton();

		Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
		dashboard.validateDashboardPage(dashboardValidText);
		dashboard.clickOnCustomerButton();
		dashboard.clickOnLIstCustomersButton();
		CustomerList customerList = PageFactory.initElements(driver, CustomerList.class);
		// customerList.validateCustomerList(customerListHeader);
		customerList.validateCustomerList(listPageHeader);
		System.out.println("print here 1 ");
		customerList.findTotalPages();
		System.out.println("print here 2 ");

		BrowserFactory.tearDown();
	}

}
