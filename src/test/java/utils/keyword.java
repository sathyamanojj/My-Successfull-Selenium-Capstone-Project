package utils;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import pom.Login;

public class keyword {
	WebDriver driver;

	public keyword(WebDriver driver) {
		this.driver = driver;
	}

	public String getCurrentPageTitle() {
		return driver.getTitle();
	}

	public String getCurrentPageUrl() {
		return driver.getCurrentUrl();
	}

	public void compareText(String expected, String actual, String failureMessage) {

		assertTrue(actual.equals(expected), failureMessage + ",");
	}

	public void login(String username, String password) {
		Login obj = new Login(driver);
		obj.hoverAccounts();
		obj.loginWithCredentials(username, password);
	}

	public void invalidLogin(String username, String password) {
		Login obj = new Login(driver);
		obj.hoverAccounts();
		obj.invalidloginWithCredentials(username, password);
	}

	public void pageWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	}

	public void amazonSearchbox() {
		Login obj = new Login(driver);
		obj.searchTextbox();
	}

	public void searchResult() {

		Login obj = new Login(driver);
		obj.resultText();

	}

	public void average4StarRating() {
		Login obj = new Login(driver);
		obj.customerReview();
	}

	public void selectMobile() {
		Login obj = new Login(driver);
		obj.selectProduct();
	}

	public void switchTabs() throws InterruptedException {
		ArrayList<String> tab1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab1.get(1));
		// Thread.sleep(5000);

	}

	public void mobilePrice() {
		Login obj = new Login(driver);
		obj.productPrice();

	}

	public void deliveryLocation() {
		Login obj = new Login(driver);
		obj.selectDelivery();
	}

	public void enterPincode() {
		Login obj = new Login(driver);
		obj.pincode();
	}

	public void clickSponsored() {
		Login obj = new Login(driver);
		obj.sponsoredItem();
	}

	public void addCartItem() {
		Login obj = new Login(driver);
		obj.addItem();

	}

	public void addedCartItem() {
		Login obj = new Login(driver);
		obj.addedItem();
	}

	public void productConfirm() {
		Login obj = new Login(driver);
		obj.confirmCart();
		Reporter.log(" product has been confirmed in the cart page");
	}

	public void closeSheet() {
		Login obj = new Login(driver);
		obj.closeCart();

	}

	public void tecDetails() {
		Login obj = new Login(driver);
		obj.productDetails();
	}

	public void takescreenshots() {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\screenshots\\screenshot.png";
		// Copy the file to a location and use try catch block to handle exception
		try {
			FileUtils.copyFile(screenshot, new File(destinationFile));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
