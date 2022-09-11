package tests;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.keyword;

public class Search_Testclass4 extends BaseTest {

	/**
	 * Test Class-4 1. Use navigation, to search for mobile such as mi mobile 2.
	 * Validate the results, for instance, 1-16 of 264 results for mi mobile 3.
	 * Select Avg. Customer Review as 4 stars & up 4. Select the first mobile, a.
	 * Validate the change in the title, whether it is relevant to the selected
	 * mobile. 5. Get the mobile price and validate it 6. Validate the Delivery
	 * location a. Click on the Select delivery location 7. Popup window and pincode
	 * validation a. Wait for the pop up Choose your location to appear b. Enter the
	 * pincode and click on the Apply button c. Validate the change in the delivery
	 * location. d. It should display Deliver to<citypincode> 8. Click on the
	 * sponsored link as shown below : a. There is no IFrame to click so click on
	 * the new product which will stay on the same page.
	 */

	@BeforeClass
	public void beforeClass() {
		kw = new keyword(driver);

		String path = System.getProperty("useer.dir") + "\\ExtentReportResulttestclass4.html";
		// String path= System.getProperty("user.dir")+"\\ExtentReportResults.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results of Sathya Shankaran");
		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QEEngineer", "SathyaShankaran");
	}

//	1. Use navigation, to search for mobile such as mi mobile

	@Test(priority = 1)
	public void search_MiMobile() {
		ExtentTest test = extent.createTest("reports");
		kw.amazonSearchbox();
		test.info("searching MI Mobile successfull");
		test.getStatus();
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\screenshotsTest4\\searchmobile.png";
		// Copy the file to a location and use try catch block to handle exception
		try {
			FileUtils.copyFile(screenshot, new File(destinationFile));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

// 2. Validate the results, for instance, 1-16 of 264 results for mi mobile

	@Test(dependsOnMethods = { "search_MiMobile" })
	public void search_Results() {
		ExtentTest test = extent.createTest("reports");
		kw.searchResult();
		test.info("searching  results successfull");
		test.getStatus();
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\screenshotsTest4\\searchresults.png";
		// Copy the file to a location and use try catch block to handle exception
		try {
			FileUtils.copyFile(screenshot, new File(destinationFile));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

//3. Select Avg. Customer Review as 4 stars & up

	// @Test(dependsOnMethods={"search_Results"})
	@Test(dependsOnMethods = { "search_MiMobile" })
	public void customer_Review() {
		ExtentTest test = extent.createTest("reports");
		kw.average4StarRating();
		test.info("customer Review with average 4 star rating clicked successfully");
		test.getStatus();
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\screenshotsTest4\\customerreview.png";
		// Copy the file to a location and use try catch block to handle exception
		try {
			FileUtils.copyFile(screenshot, new File(destinationFile));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

//Select the first mobile, and in this case, Redmi Note 8 (Moonlight White, 6GB RAM, 128GB Storage)	

	@Test(dependsOnMethods = { "customer_Review" })
	public void first_Mobile() {
		ExtentTest test = extent.createTest("reports");
		kw.pageWait();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		kw.selectMobile();
		test.info("clicked on first mobile successfully");
		test.getStatus();
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\screenshotsTest4\\firstMobileproduct.png";
		// Copy the file to a location and use try catch block to handle exception
		try {
			FileUtils.copyFile(screenshot, new File(destinationFile));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

//Validate the change in the title, whether it is relevant to the selected mobile
	@Test(dependsOnMethods = { "first_Mobile" })
	public void validate_Mobile() {
		ExtentTest test = extent.createTest("reports");
		try {
			kw.switchTabs();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("switched to different iframe to validate the mobile title");
		String actual = kw.getCurrentPageTitle();
		Reporter.log("current page title is " + actual);
		test.info("current page title is " + actual);
		test.getStatus();
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\screenshotsTest4\\validatemobile.png";
		// Copy the file to a location and use try catch block to handle exception
		try {
			FileUtils.copyFile(screenshot, new File(destinationFile));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

//Get the mobile price and validate it
	@Test(dependsOnMethods = { "validate_Mobile" })
	public void validate_Mobile_Price() {
		ExtentTest test = extent.createTest("reports");
		kw.mobilePrice();
		test.info("mobile price validated successfully");
		test.getStatus();
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\screenshotsTest4\\mobileprice.png";
		// Copy the file to a location and use try catch block to handle exception
		try {
			FileUtils.copyFile(screenshot, new File(destinationFile));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

//Validate the Delivery location 
	// a. Click on the Select delivery location

	@Test(dependsOnMethods = { "validate_Mobile_Price" })
	public void validate_Delivery_Location() {
		ExtentTest test = extent.createTest("reports");
		kw.deliveryLocation();
		Reporter.log("Delivery location selected successfully");
		test.info("Delivery location selected successfully");
		test.getStatus();
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\screenshotsTest4\\deliveryLocation.png";
		// Copy the file to a location and use try catch block to handle exception
		try {
			FileUtils.copyFile(screenshot, new File(destinationFile));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

//	Popup window and pincode validation
//	a. Wait for the pop up Choose your location to appear
	// b. Enter the pincode and click on the Apply button
	// c. Validate the change in the delivery location.
	// d. It should display Deliver to<citypincode>
	@Test(dependsOnMethods = { "validate_Delivery_Location" })
	public void validate_Pincode() {
		ExtentTest test = extent.createTest("reports");
		kw.enterPincode();
		Reporter.log("Pincode entered successfully");
		test.info("Pincode entered successfully");
		test.getStatus();
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\screenshotsTest4\\pincode.png";
		// Copy the file to a location and use try catch block to handle exception
		try {
			FileUtils.copyFile(screenshot, new File(destinationFile));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/********
	 * Sponsored link does not have a Iframe and does not navigate to separate
	 * window
	 *************/
//	8. Click on the sponsored link as shown below :
//	a. There is no IFrame to click so  click on the new product which will stay on the same page.

	@Test(dependsOnMethods = { "validate_Pincode" })
	public void sponsored_Link() {
		ExtentTest test = extent.createTest("reports");
		kw.pageWait();
		kw.clickSponsored();
		Reporter.log("first item from sponsored item is chosen");
		driver.navigate().back();
		test.info("first item from sponsored item is chosen");
		test.getStatus();
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\screenshotsTest4\\sponsoredlink.png";
		// Copy the file to a location and use try catch block to handle exception
		try {
			FileUtils.copyFile(screenshot, new File(destinationFile));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

//9. Click on Add to Cart
//a. Wait for the window to be displayed
//	b. Validate the Added to Cart message
//	c. Close the Added to Cart window

	@Test(dependsOnMethods = { "sponsored_Link" })
	public void add_To_Cart() {
		ExtentTest test = extent.createTest("reports");
		kw.addCartItem();
		Reporter.log("added to cart successfully");
		kw.pageWait();
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\screenshotsTest4\\addtocart.png";
		// Copy the file to a location and use try catch block to handle exception
		try {
			FileUtils.copyFile(screenshot, new File(destinationFile));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		kw.addedCartItem();
		kw.pageWait();
		File screenshot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile2 = System.getProperty("user.dir") + "\\screenshotsTest4\\addedtocart.png";
		// Copy the file to a location and use try catch block to handle exception
		try {
			FileUtils.copyFile(screenshot2, new File(destinationFile2));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		kw.closeSheet();
		test.info("added to cart successfully");
		test.info("closed the added cart sheet successfully");
		test.getStatus();
		File screenshot3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile3 = System.getProperty("user.dir") + "\\screenshotsTest4\\backtoproduct.png";
		// Copy the file to a location and use try catch block to handle exception
		try {
			FileUtils.copyFile(screenshot3, new File(destinationFile3));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	// 10. Use JavaScriptExecutor to scroll the page downwards until the ‘Technical
	// Details’ are displayed

	@Test(dependsOnMethods = { "add_To_Cart" })
	public void tecnical_Details() {
		ExtentTest test = extent.createTest("reports");

		kw.tecDetails();
		test.info("scrolled down to Technical Details successfully");
		test.getStatus();
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\screenshotsTest4\\technicaldetails.png";
		// Copy the file to a location and use try catch block to handle exception
		try {
			FileUtils.copyFile(screenshot, new File(destinationFile));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
