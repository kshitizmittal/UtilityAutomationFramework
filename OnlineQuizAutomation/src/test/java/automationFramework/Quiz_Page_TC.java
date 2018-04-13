package test.java.automationFramework;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
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
public class Quiz_Page_TC {

	private String ipx;
	private static WebDriver driver = null;

	@BeforeClass
	public static void setUp() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Projects\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Before
	public void setupTest() throws InterruptedException {

		System.out.println(ipx);

		String appUrl = Constant.baseURL + ipx;

		driver.get(appUrl);

		Boolean apply = true;

		try {
			apply = LogIn_Page.btn_SignIn(driver).isDisplayed();
		} catch (Exception e) {
			apply = false;
		}

		if (apply) {
			LogIn_Page.btn_SignIn(driver).click();
			Thread.sleep(10000);
		}

		try {
			apply = LogIn_Page.txtbx_UserName(driver).isDisplayed();
		} catch (Exception e) {
		}
		if (apply) {
			LogIn_Page.txtbx_UserName(driver).sendKeys(Constant.Username);
			LogIn_Page.txtbx_Password(driver).sendKeys(Constant.Password);
			LogIn_Page.btn_LogIn(driver).click();
			Thread.sleep(10000);
		}

		try {
			apply = LogIn_Page.img_Tile(driver).isDisplayed();
		} catch (Exception e) {
		}
		if (apply) {
			LogIn_Page.img_Tile(driver).click();
			Thread.sleep(40000);
		}

		try {
			apply = LogIn_Page.btn_joinCourse(driver).isDisplayed();
		} catch (Exception e) {
		}
		if (apply) {
			// LogIn_Page.btn_joinCourse(driver).click();
			// Thread.sleep(10000);
		}

		try {
			apply = LogIn_Page.btn_continue(driver).isDisplayed();
		} catch (Exception e) {
		}
		if (apply) {
			LogIn_Page.btn_continue(driver).click();
			Thread.sleep(10000);
		}

		System.out.println("Page is blank : Refreshing");
		driver.navigate().refresh();

		Thread.sleep(10000);
	}

	@Parameters
	public static Collection spreadsheetData() throws IOException {
		InputStream spreadsheet = new FileInputStream(Constant.Path_TestData
				+ Constant.File_TestData);
		return new ExcelUtils(spreadsheet).getData();
	}

	public Quiz_Page_TC(String ipx) {
		super();
		this.ipx = ipx;
	}

	@Test
	public void shouldCalculateATimesB() {

		Boolean condition = false;

		try {

			WebElement errorMsg = driver
					.findElement(By
							.xpath(".//*[@id='errorNameUnexpectedError']/div[1]/div/h1"));//*[@id="errorNameUnexpectedError"]/div[1]/div/h1
			
			condition = errorMsg.isDisplayed();
		} catch (Exception e) {
			System.out.println("Condition 0: " + condition);
		}
		if (condition) {
			Assert.assertFalse("Something Went Wrong", condition);
		}

		try {
			WebElement pePanel_body = Quiz_Page.pePanel_body(driver);
			condition = pePanel_body.isDisplayed();
			System.out.println("Condition 1: " + condition);

			WebElement idk = Quiz_Page.btn_idontknow(driver);
			System.out.println("PE Panel: " + idk.isDisplayed());
			condition = idk.isDisplayed();
			System.out.println("Condition 2: " + condition);

			WebElement ac = Quiz_Page.assessmentContent(driver);
			System.out.println("PE Panel: " + ac.isDisplayed());
			condition = ac.isDisplayed();
			System.out.println("Condition 3: " + condition);

		} catch (Exception e) {

		}
		Assert.assertTrue("condition is: " + condition, condition);

	}

}
