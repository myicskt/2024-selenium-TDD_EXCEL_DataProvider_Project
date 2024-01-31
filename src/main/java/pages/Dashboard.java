package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class Dashboard extends BasePage {
	WebDriver driver;

	public Dashboard(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//div/strong[text()='Dashboard']")
	WebElement dashboardHeader;

	@FindBy(how = How.XPATH, using = "//nav/ul[2]/li/a/span[text()='Customers']")
	WebElement customerButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"customers\"]/li/a/span[text()='Add Customer']")
	WebElement addCustomerButton;

	@FindBy(how = How.XPATH, using = "//ul[@id='customers']/li/a/span[text()='List Customers']")
	WebElement listCustomerButton;

	public void validateDashboardPage(String dashboard) {
		Assert.assertEquals(dashboardHeader.getText(), dashboard, "Dashboard pae is not found");
	}

	public void clickOnCustomerButton() {
		customerButton.click();
	}

	public void clickOnAddcustomerButton() {
		addCustomerButton.click();
	}

	public void clickOnLIstCustomersButton() {
		listCustomerButton.click();
	}

}
