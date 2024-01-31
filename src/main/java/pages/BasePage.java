package pages;

import java.text.DecimalFormat;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BasePage {

	public void validateElement(String actual, String expected, String errorMsg) {
		Assert.assertEquals(actual, expected, errorMsg);
	}

	public int generateRandomNum(int boundNum) {
		Random rnd = new Random();
		int generatedNum = rnd.nextInt(boundNum);
		return generatedNum;
	}

	public void selectFromDropDown(WebElement webElement, String visibleText) {
		Select select = new Select(webElement);
		select.selectByVisibleText(visibleText);
	}

	public String randomPhoneNum() {
		Random rand = new Random();
		int num1 = (rand.nextInt(7) + 1) * 100 + (rand.nextInt(8) * 10) + rand.nextInt(8);
		int num2 = rand.nextInt(743);
		int num3 = rand.nextInt(10000);

		DecimalFormat df3 = new DecimalFormat("000"); // 3 zeros
		DecimalFormat df4 = new DecimalFormat("0000"); // 4 zeros

		String phoneNumber = df3.format(num1) + "-" + df3.format(num2) + "-" + df4.format(num3);

		return phoneNumber;

	}
}
