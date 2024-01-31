package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCustomer extends BasePage {

	WebDriver driver;

	public AddCustomer(WebDriver passdriver) {
		this.driver = passdriver;

	}

	@FindBy(how = How.XPATH, using = "//div/header/div/strong[contains(text(),'New Customer')]")
	WebElement addCustomerHedder;

	@FindBy(how = How.XPATH, using = "//*[@id='general_compnay']/div[1]/div/input")
	WebElement fullName;

	@FindBy(how = How.XPATH, using = "//*[@id='general_compnay']/div[2]/div/select")
	WebElement selectCompany;

	@FindBy(how = How.XPATH, using = "//*[@id=\"general_compnay\"]/div[3]/div/input")
	WebElement userEmail;

	@FindBy(how = How.XPATH, using = "//input[@id='phone']")
	WebElement userPhoneNumber;

	@FindBy(how = How.XPATH, using = "//input[@name='address']")
	WebElement streetAddress;

	@FindBy(how = How.XPATH, using = "//input[@name='city']")
	WebElement cityName;

	@FindBy(how = How.XPATH, using = "//input[@id='port']")
	WebElement zipCode;

	@FindBy(how = How.XPATH, using = "//div/div/select[@name='country']")
	WebElement country;

	@FindBy(how = How.XPATH, using = "//div/select[@name='customer_group']")
	WebElement group;

	@FindBy(how = How.XPATH, using = "//button[@id='save_btn']")
	WebElement saveButton;

	public void validateAddNewCustomerPage(String customerHeaderText) {
		String add = addCustomerHedder.getText();
		validateElement(add, customerHeaderText, "Add acustomer page is not aviable");
	}

	public String insertFullName(String name) {
		String generateFullname = name + generateRandomNum(999);
		fullName.sendKeys(generateFullname);
		return generateFullname;

	}

	public void selectComponyName(String componyName) {
		selectFromDropDown(selectCompany, componyName);

	}

	public void insertEmail(String email) {
		userEmail.sendKeys(generateRandomNum(999) + email);
	}

	public void insertPhoneNumber(String phone) {
		userPhoneNumber.sendKeys(phone);
	}

	public void insertPhoneNumber() {

		userPhoneNumber.sendKeys(randomPhoneNum());
	}

	public void insertStreetAddress(String address) {
		streetAddress.sendKeys(address);
	}

	public void insertCity(String city) {
		cityName.sendKeys(city);
	}

	public void insertZipCode(String zip) {
		zipCode.sendKeys(zip);
	}

	public void selectCountry(String countryName) {
		selectFromDropDown(country, countryName);
	}

	public void selectGroup(String groupname) {
		selectFromDropDown(group, groupname);

	}

	public void clickOnSaveButton() {
		saveButton.click();

	}

}
