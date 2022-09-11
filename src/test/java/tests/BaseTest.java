package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.common;
import utils.keyword;

public class BaseTest {

	common common;

	static WebDriver driver;
	ExtentReports extent;
	static ExtentTest test;
	static ExtentReports report;
	keyword kw;

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void beforeTest(String browser, String url) {

		common = new common();
		common.setupBrowser(browser, url);
		driver = common.getDriver();
		driver.manage().window().maximize();
	}

	@AfterSuite
	public void afterclass() {
		extent.flush();
	}

	@AfterTest
	public void afterTest() {
		common.quitBrowser();
	}

}
