package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class CustomerList extends BasePage {

	WebDriver driver;

	public CustomerList(WebDriver driverPass) {
		this.driver = driverPass;
	}

	@FindBy(how = How.XPATH, using = "//div/header/div/strong[text()='Customer List']")
	WebElement customerListHeader;
	@FindBy(how = How.XPATH, using = "//div/a[@id=\"yesBtn\"]")
	WebElement yesButtonToDelet;

	@FindBy(how = How.XPATH, using = "//*[@id=\"DataTables_previous\"]")
	WebElement previousButton;

	@FindBy(how = How.XPATH, using = "//*[@id='DataTables_next']/a")
	WebElement nextButton;

	@FindBy(how = How.XPATH, using = "//div[@id='DataTables_paginate']/ul/li/a[text()='2']")
	WebElement pageOne;

	@FindBy(how = How.XPATH, using = "//div[@id='DataTables_paginate']/ul/li/a")
	List<WebElement> pages;

	public void validateCustomerList(String headerString) {
		validateElement(customerListHeader.getText(), headerString, "Custome list page is not find");
	}

	public void validateInsertedNameAndDelet(String name) {
		String beforeXpath = "//tbody/tr[";
		String afterXpath = "]/td[2]/a";
		String afterXpathDelete = "]/td[9]/button";
		for (int i = 1; i <= 5; i++) {
			String actualName = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
			if (actualName.equals(name)) {
				Assert.assertEquals(actualName, name, "name is now found in this list");
				driver.findElement(By.xpath(beforeXpath + i + afterXpathDelete)).click();
				yesButtonToDelet.click();
			}
			break;
		}
	}

//click all previous and next button

	public void getAllCustomerList() {
		pageOne.click();
		nextButton.click();

		nextButton.click();

		if (nextButton.isEnabled()) {
			nextButton.click();
		}

	}

	public void findTotalPages() {
		for (WebElement link : pages) {
			System.out.println(link.getText());
		}

	}

}
