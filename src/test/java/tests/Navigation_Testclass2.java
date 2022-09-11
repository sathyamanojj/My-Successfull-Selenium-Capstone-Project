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
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.relevantcodes.extentreports.LogStatus;

import pom.Login;
import utils.keyword;

public class Navigation_Testclass2 extends BaseTest {
	/**
	 * Test Class-2 1. Use the navigation to navigate to Accounts and Lists ➔ Create
	 * a Wish List, and verify whether the navigation was successful 2. Use
	 * Navigation to navigate to Amazon Pay module and validate the web page 3.Use
	 * Navigation to navigate to New Releases module and validate the web
	 *
	 */
	@BeforeClass
	public void beforeClass() {
		kw = new keyword(driver);

		String path = System.getProperty("useer.dir") + "\\ExtentReportResulttestclass2.html";
		// String path= System.getProperty("user.dir")+"\\ExtentReportResults.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results of Sathya Shankaran");
		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QEEngineer", "SathyaShankaran");
	}

	// Use the navigation to navigate to Accounts and Lists ➔ Create a Wish List,
	// and
	// verify whether the navigation was successful

	@Test(priority = 0)
	public void wishlist() {
		ExtentTest test = extent.createTest("reports");
		Login obj = new Login(driver);
		obj.accountWishlist();
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\screenshotstestclass2\\wishlist.png";
		// Copy the file to a location and use try catch block to handle exception
		try {
			FileUtils.copyFile(screenshot, new File(destinationFile));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		String expectedtitle = "Wish List";
		String actualTitle = kw.getCurrentPageTitle();
		String failureMessage = "Page title validation failed";

		kw.compareText(expectedtitle, actualTitle, failureMessage);
		Reporter.log("Expected title = " + expectedtitle);
		Reporter.log("Actual title = " + actualTitle);
		Reporter.log("wish list web page validated successfully");
		test.info("wishList created successfully");
		test.getStatus();

	}

	// Use Navigation to navigate to Amazon Pay module and validate the web page

	@Test(priority = 1)
	public void AmazonPay() {
		ExtentTest test = extent.createTest("reports");
		Login obj = new Login(driver);
		obj.accountPayModule();
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\screenshotstestclass2\\AmazonPay.png";
		// Copy the file to a location and use try catch block to handle exception
		try {
			FileUtils.copyFile(screenshot, new File(destinationFile));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		Reporter.log("Account pay module web page navigated successfully");
		test.info("Account pay module web page navigated successfully");
		test.getStatus();

	}

	// Use Navigation to navigate to New Releases module and validate the web page

	@Test(priority = 2)
	public void NewRelease() {
		ExtentTest test = extent.createTest("reports");
		Login obj = new Login(driver);
		obj.newReleaseModule();
		Reporter.log("New Release module web page navigated successfully");
		test.info("New Release module web page navigated successfully");
		test.getStatus();
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\screenshotstestclass2\\NewRelease.png";
		// Copy the file to a location and use try catch block to handle exception
		try {
			FileUtils.copyFile(screenshot, new File(destinationFile));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
