package pom;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;

import utils.keyword;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	WebDriver driver;

	@CacheLookup
	@FindBy(id = "ap_email")
	WebElement emailid;

	@CacheLookup
	@FindBy(name = "password")
	WebElement passwd;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\'nav-flyout-ya-signin\']/a/span")
	WebElement signinpage;

	@CacheLookup
	@FindBy(id = "continue")
	WebElement Continuebtn;

	@CacheLookup
	@FindBy(id = "signInSubmit")
	WebElement signinbtn;

	@CacheLookup
	@FindBy(partialLinkText = "Forgotten password?")
	WebElement forgotPasswordLink;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\'nav-link-accountList\']/span")
	WebElement Accountlist;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\'nav-al-your-account\']/a[3]/span")
	WebElement wishlist;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\'nav-xshop\']/a[11]")
	WebElement accountpay;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\'nav-xshop\']/a[9]")
	WebElement newrelease;

	@CacheLookup
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchbox;

	@CacheLookup
	@FindBy(id = "nav-search-submit-button")
	WebElement searchbtn;

	@CacheLookup
	@FindBy(xpath = "//*[@id='search']/span/div/h1/div/div[1]/div/div/span[1]")
	WebElement searchresults;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\'p_72/1318476031\']/span/a/section/i")
	WebElement custreview;

	@CacheLookup
	@FindBy(xpath = "//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'][1]")
	WebElement FirstProduct;

	@CacheLookup
	@FindBy(xpath = "//*[@id='corePriceDisplay_desktop_feature_div']/div[1]/span[2]/span[2]/span[1]")
	WebElement symbol;

	@CacheLookup
	@FindBy(xpath = "//*[@id='corePriceDisplay_desktop_feature_div']/div[1]/span[2]/span[2]/span[2]")
	WebElement pricewhole;

	@CacheLookup
	@FindBy(xpath = "//*[@id='corePriceDisplay_desktop_feature_div']/div[1]/span[2]/span[2]/span[3]")
	WebElement fractions;

	@CacheLookup
	@FindBy(id = "contextualIngressPtLabel_deliveryShortLine")
	WebElement Location;

	@CacheLookup
	@FindBy(id = "GLUXZipUpdateInput")
	WebElement pin;

	@CacheLookup
	@FindBy(xpath = "//*[@id='GLUXZipUpdate']/span/input")
	WebElement applybtn;

	@CacheLookup
	@FindBy(xpath = "//*[@id='contextualIngressPtLabel_deliveryShortLine']/span[2]")
	WebElement loc_change;

	@CacheLookup
	@FindBy(id = "HLCXComparisonWidget_feature_div")
	WebElement frameElement;

	@CacheLookup
	@FindBy(xpath = "//*[@id='HLCXComparisonTable']/tbody/tr[1]/th[3]")
	WebElement firstItem;

	@CacheLookup
	@FindBy(id = "add-to-cart-button")
	WebElement cartitem;

	@CacheLookup
	@FindBy(xpath = "//*[@id='attachDisplayAddBaseAlert']/span")
	WebElement addeditem;

	@CacheLookup
	@FindBy(xpath = "//*[@id='nav-cart-count-container']/span[2]")
	WebElement confirmitem;

	@CacheLookup
	@FindBy(id = "attach-close_sideSheet-link")
	WebElement closeaddcart;

	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginWithCredentials(String username, String password) {

		Reporter.log("username = " + username);
		Reporter.log("password = " + password);
		emailid.clear();
		emailid.sendKeys(username);
		Continuebtn.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		passwd.clear();
		passwd.sendKeys(password);

	}

	public void invalidloginWithCredentials(String username, String password) {

		Reporter.log("username = " + username);
		Reporter.log("password = " + password);
		emailid.clear();
		emailid.sendKeys(username);
		Continuebtn.click();

	}

	public void forgotPassword(String username) {
		forgotPasswordLink.click();
	}

	public void hoverAccounts() {
		Actions actions = new Actions(driver);
		actions.moveToElement(Accountlist).perform();
		signinpage.click();

	}

	public void accountWishlist() {
		Actions actions = new Actions(driver);
		actions.moveToElement(Accountlist).perform();
		wishlist.click();

	}

	public void accountPayModule() {
		accountpay.click();
	}

	public void newReleaseModule() {
		newrelease.click();
	}

	public void searchTextbox() {
		searchbox.click();
		searchbox.sendKeys("mi mobile");
		searchbtn.click();
		Reporter.log("navigated to search box successfully ");
	}

	public void resultText() {

		keyword obj = new keyword(driver);
		obj.pageWait();
		String expected = "1-16 of 66 results for";
		if (expected.matches("1-16 of ([1-100]+) results for")) {
			System.out.println("matched");
		}
		String result = searchresults.getText();
		String failureMessage = " results does not match";
		System.out.println(result);
		assertTrue(result.equals(expected), failureMessage + ",");
		Reporter.log(result + " mi mobile");
		Reporter.log(expected + " mi mobile");

	}

	public void customerReview() {
		custreview.click();
		Reporter.log("4 star customer reveiew clicked successfully");
	}

	public void selectProduct() {
		keyword obj = new keyword(driver);
		obj.pageWait();
		FirstProduct.click();
		Reporter.log("First mi mobile product selected successfully with 4 star rating");

	}

	public void productPrice() {

		String Sym = symbol.getText();
		String pri = pricewhole.getText();
		String frac = fractions.getText();
		Reporter.log(Sym + " " + pri + "." + frac);

	}

	public void selectDelivery() {
		Location.click();

	}

	public void pincode() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		pin.clear();
		pin.sendKeys("560079");
		applybtn.click();
		String str_loc = loc_change.getText();
		Reporter.log("Delivered to < " + str_loc + " >");

	}

	public void sponsoredItem() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement Element = driver.findElement(By.xpath("//*[@id='comparison_table_title']"));

		// Scroll the web page till the web element is found
		// js.executeScript("arguments[0].scrollIntoView();", Element);
		js.executeScript("window.scrollBy(97,2445)");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		firstItem.click();
	}

	public void addItem() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.id("add-to-cart-button"));
		// Scroll the web page till the web element is found
		js.executeScript("arguments[0].scrollIntoView();", Element);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cartitem.click();

	}

	public void addedItem() {
		String str_added = addeditem.getText();
		System.out.println(str_added);
		Reporter.log("validated the message " + str_added);
	}

	public void confirmCart() {
		confirmitem.click();
	}

	public void productDetails() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//*[@id='prodDetails']/div/div[1]/div[1]/div/div[1]/div/h1"));

		// Scroll the web page till the web element is found
		js.executeScript("arguments[0].scrollIntoView();", Element);

	}

	public void closeCart() {
		closeaddcart.click();
	}

}
