package test.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import test.java.pageObjects.LogIn_Page;
import test.java.pageObjects.Quiz_Page;
import test.java.utility.Constant;
import test.java.utility.ExcelUtils;


@RunWith(Parameterized.class)
public class Quiz_Page_TCTest {

	private String ipx;
	private static WebDriver driver = null;

	private Logger Log = Logger.getLogger(Quiz_Page_TCTest.class
			.getName());


	@BeforeClass
	public static void setUp() throws InterruptedException {

		DOMConfigurator.configure("log4j.xml");
		System.setProperty("webdriver.chrome.driver",
				Constant.ChromeDriverPath);
		driver = new ChromeDriver();



	}

	@Before
	public void setupTest() throws InterruptedException {
		

		Log.info("ipx is: " + ipx);

		String appUrl = Constant.baseURL + ipx;
		
		Log.info("Starting with URL: " + appUrl);

		driver.get(appUrl);

		Boolean apply = true;

		try {
			apply = LogIn_Page.btn_SignIn(driver).isDisplayed();
		} catch (Exception e) {
			apply = false;
			Log.error("Exception in Signing in: ", e);
		}

		if (apply) {
			LogIn_Page.btn_SignIn(driver).click();
			Thread.sleep(10000);
		}

		try {
			apply = LogIn_Page.txtbx_UserName(driver).isDisplayed();
			Log.info("At Login Page: ");
		} catch (Exception e) {
			Log.error("Exception in Login Page: ", e);
		}
		if (apply) {
			Log.info("Enter username and password: ");
			LogIn_Page.txtbx_UserName(driver).sendKeys(Constant.Username);
			LogIn_Page.txtbx_Password(driver).sendKeys(Constant.Password);
			LogIn_Page.btn_LogIn(driver).click();
			Thread.sleep(10000);
		}

		try {
			Log.info("Course tile is displayed: ");
			apply = LogIn_Page.img_Tile(driver).isDisplayed();
		} catch (Exception e) {
			Log.error("Exception in Course Title: ", e);
		}
		if (apply) {
			Log.info("Clicking on course tile: ");
			LogIn_Page.img_Tile(driver).click();
			Thread.sleep(40000);
		}

		/*try {
			Log.info("Join Course page is displayed: ");
			apply = LogIn_Page.btn_joinCourse(driver).isDisplayed();
		} catch (Exception e) {
			Log.error("Exception in Join Course: ", e);
		}
		if (apply) {
			 LogIn_Page.btn_joinCourse(driver).click();
			 Thread.sleep(10000);
		}*/

		try {
			apply = LogIn_Page.btn_continue(driver).isDisplayed();
		} catch (Exception e) {
			Log.error("Exception in continuing online test: ", e);
		}
		if (apply) {
			LogIn_Page.btn_continue(driver).click();
			Thread.sleep(10000);
		}

		Log.info("Page is blank : Refreshing");
		driver.navigate().refresh();

		Thread.sleep(10000);
	}

	@Parameters
	public static Collection spreadsheetData() throws IOException {
		InputStream spreadsheet = new FileInputStream(Constant.Path_TestData
				+ Constant.File_TestData);
		return new ExcelUtils(spreadsheet).getData();
	}

	public Quiz_Page_TCTest(String ipx) {
		super();
		this.ipx = ipx;
	}

	@Test
	public void quizPageValidation() {

		Boolean condition = false;

		try {

			WebElement errorMsg = driver
					.findElement(By
							.xpath(".//*[@id='ErrorHandlingContainer']"));

			condition = errorMsg.isDisplayed();
			Log.info("At Something went wrong page - Test should be failed and Condition should be: TRUE - " + condition);
		} catch (Exception e) {
			Log.error("In Something went wrong block: ", e);
			Log.error("Condition 0 which should be FALSE: " + condition);
		}
		if (condition) {
			Assert.assertTrue("Something Went Wrong", condition);
		}

		try {
			WebElement pePanel_body = Quiz_Page.pePanel_body(driver);
			condition = pePanel_body.isDisplayed();
			Log.info("Condition 1: " + condition);

			WebElement idk = Quiz_Page.btn_idontknow(driver);
			Log.info("PE Panel: " + idk.isDisplayed());
			condition = idk.isDisplayed();
			Log.info("Condition 2: " + condition);
			
			WebElement ac = Quiz_Page.assessmentContent(driver);
			Log.info("PE Panel: " + ac.isDisplayed());
			condition = ac.isDisplayed();
			Log.info("Condition 3: " + condition);

		} catch (Exception e) {

		}
		Assert.assertTrue("condition is: " + condition, condition);

	}
	
	@After
	public void teardownTest() {
		Log.info("One iteration completed: ");
	}
	

}
