package testPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.Dashboard;
import pages.LoginPage;
import util.BrowserFactory;
import util.DataProviders;

public class LoginTestWithDataProvider {

	WebDriver driver;

	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void teslogin(String userId, String password, String dashboardValidText) {
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
