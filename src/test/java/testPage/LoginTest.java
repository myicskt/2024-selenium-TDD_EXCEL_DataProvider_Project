package testPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.Dashboard;
import pages.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;
import util.PropertiesFileReader;

public class LoginTest {

	WebDriver driver;
	// get data from properties files
	String propertiesFile = ".\\src\\main\\java\\config\\config.properties";
	PropertiesFileReader pro = new PropertiesFileReader(propertiesFile);
	String userId1 = pro.getProperty("userid");
	String password1 = pro.getProperty("password");

	// get data from excel file
	String excelFile = ".\\src\\main\\java\\testData\\testdata.xlsx";
	ExcelReader excelData = new ExcelReader(excelFile);
	String userId = excelData.readeExcelcell("login", "User Name", 2);
	String password = excelData.readeExcelcell("login", "Password", 2);
	String dashboardValidText = excelData.readeExcelcell("login", "Validate Text", 2);

	@Test
	public void validUserShouldLogin() {
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userId);
		loginPage.insertUserPassword(password);
		loginPage.clickOnSinginButton();

		Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
		dashboard.validateDashboardPage(dashboardValidText);
		BrowserFactory.tearDown();

	}

}
