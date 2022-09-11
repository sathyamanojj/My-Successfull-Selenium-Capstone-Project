package tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.keyword;

public class LoginValidation_Testclass3 extends BaseTest {

	/**
	 * Test Class-3 1. Create a testng.xml with parameter as valid and invalid
	 * credentials and use them in the test class 2. Create the test case for login
	 * validation 3. Validate login and logout 4. Validate invalid login and logout
	 */

	@BeforeClass
	public void beforeClass() {
		kw = new keyword(driver);

		String path = System.getProperty("useer.dir") + "\\ExtentReportResulttestclass3.html";
		// String path= System.getProperty("user.dir")+"\\ExtentReportResults.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results of Sathya Shankaran");
		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QEEngineer", "SathyaShankaran");
	}

	@Parameters({ "validUsername", "validPassword" })
	@Test(priority = 1)
	public void validUsernameValidPassword(String username, String password) {
		ExtentTest test = extent.createTest("reports");
		kw.login(username, password);
		Reporter.log(username);
		Reporter.log(password);
		test.info("validusername" + username);
		test.info("validpassword" + password);
		test.getStatus();
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\screenshotstestclass3\\validusername.png";
		// Copy the file to a location and use try catch block to handle exception
		try {
			FileUtils.copyFile(screenshot, new File(destinationFile));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	@Parameters({ "invalidUsername", "invalidPassword" })

	@Test(priority = 2)
	public void invalidUsernameValidPassword(String username, String password) {
		ExtentTest test = extent.createTest("reports");
		driver.navigate().back();
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		kw.invalidLogin(username, password);
		Reporter.log(username);
		Reporter.log(password);
		test.info("invalidusername" + username);
		test.info("invalidpassword" + password);
		test.getStatus();
		// extent.flush();
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\screenshotstestclass3\\Invalidusername.png";
		// Copy the file to a location and use try catch block to handle exception
		try {
			FileUtils.copyFile(screenshot, new File(destinationFile));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
