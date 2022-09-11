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

public class BasicValidation_Testclass1 extends BaseTest {

	/**
	 * Test Class-1 1. URL validation a. Enter the URL as http://amzn.in and check
	 * whether the URL is redirected to https://www.amazon.in/ 2. Validate the page
	 * title —Online Shopping site in India: Shop Online for Mobiles, Books,
	 * Watches, Shoes and More - Amazon.in
	 */

	@BeforeClass
	public void beforeClass() {
		kw = new keyword(driver);

		String path = System.getProperty("useer.dir") + "\\ExtentReportResulttestclass1.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results of Sathya Shankaran");
		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QEEngineer", "SathyaShankaran");
	}

	// Enter the URL as http://amzn.in and check whether the URL is
	// redirected to https://www.amazon.in/

	@Test
	public void urlValidation() {
		ExtentTest test = extent.createTest("reports");
		String expectedUrl = "https://www.amazon.in/";
		String actualUrl = kw.getCurrentPageUrl();
		String failureMessage = "URL validation failed";

		kw.compareText(expectedUrl, actualUrl, failureMessage);
		Reporter.log("Expected URL = " + expectedUrl);
		Reporter.log("Actual URL = " + actualUrl);
		test.info("url validation successfull");
		test.getStatus();
		kw.takescreenshots();
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\screenshotstestclass1\\urlValidation.png";
		// Copy the file to a location and use try catch block to handle exception
		try {
			FileUtils.copyFile(screenshot, new File(destinationFile));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	// Validate the page title —Online Shopping site in India: Shop Online for
	// Mobiles, Books, Watches, Shoes and More - Amazon.in

	@Test
	public void titleValidation() {
		ExtentTest test = extent.createTest("reports");
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actualTitle = kw.getCurrentPageTitle();
		String failureMessage = "Page title validation failed";

		kw.compareText(expectedTitle, actualTitle, failureMessage);
		Reporter.log("Expected title = " + expectedTitle);
		Reporter.log("Actual title = " + actualTitle);
		test.info("title validation successful");
		test.getStatus();
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\screenshotstestclass1\\titleValidation.png";
		// Copy the file to a location and use try catch block to handle exception
		try {
			FileUtils.copyFile(screenshot, new File(destinationFile));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
