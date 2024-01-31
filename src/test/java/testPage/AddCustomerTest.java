package testPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.AddCustomer;
import pages.CustomerList;
import pages.Dashboard;
import pages.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {
	WebDriver driver;
	String excelFile = ".\\src\\main\\java\\testData\\testdata.xlsx";
	ExcelReader excelData = new ExcelReader(excelFile);
	String userId = excelData.readeExcelcell("login", "User Name", 2);
	String password = excelData.readeExcelcell("login", "Password", 2);
	String dashboardValidText = excelData.readeExcelcell("login", "Validate Text", 2);

	String addCustomerValidText = excelData.readeExcelcell("add customer", "ValidateText", 2);
	String fullName = excelData.readeExcelcell("add customer", "Full Name", 2);
	String email = excelData.readeExcelcell("add customer", "Email", 2);
	String componyName = excelData.readeExcelcell("add customer", "Compony", 2);
	String phone = excelData.readeExcelcell("add customer", "Phone", 2);

	String streetAddress = excelData.readeExcelcell("add customer", "Address", 2);
	String city = excelData.readeExcelcell("add customer", "City", 2);
	String zipCode = excelData.readeExcelcell("add customer", "ZipCode", 2);
	String country = excelData.readeExcelcell("add customer", "Country", 2);
	String group = excelData.readeExcelcell("add customer", "Group", 2);

	String listPageHeader = excelData.readeExcelcell("add customer", "ValidateText2", 2);

	String generateFullName = null;

	@Test
	public void addCustomerTest() {
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userId);
		loginPage.insertUserPassword(password);
		loginPage.clickOnSinginButton();

		Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
		dashboard.validateDashboardPage(dashboardValidText);
		dashboard.clickOnCustomerButton();
		dashboard.clickOnAddcustomerButton();

		AddCustomer addCustomer = PageFactory.initElements(driver, AddCustomer.class);
		addCustomer.validateAddNewCustomerPage(addCustomerValidText);
		generateFullName = addCustomer.insertFullName(fullName);
		System.out.println(generateFullName);

		addCustomer.selectComponyName(componyName);
		addCustomer.insertEmail(email);

		addCustomer.insertPhoneNumber();
		// addCustomer.insertPhoneNumber(phone);
		addCustomer.insertStreetAddress(streetAddress);
		addCustomer.insertCity(city);
		addCustomer.insertZipCode(zipCode);
		addCustomer.selectCountry(country);
		addCustomer.selectGroup(group);
		addCustomer.clickOnSaveButton();

		CustomerList customerList = PageFactory.initElements(driver, CustomerList.class);
		// customerList.validateCustomerList(customerListHeader);
		customerList.validateCustomerList(listPageHeader);
		customerList.validateInsertedNameAndDelet(generateFullName);

		customerList.getAllCustomerList();
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		BrowserFactory.tearDown();

	}

}
