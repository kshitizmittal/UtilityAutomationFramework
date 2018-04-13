package test.java.automationFramework;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import test.java.pageObjects.Quiz_Page;
import test.java.utility.Constant;
import test.java.utility.ExcelUtils;


@RunWith(Parameterized.class)
public class Quiz_Page_Temp { 

    private String ipx;
    private static WebDriver driver = null;
    
    
    @BeforeClass
    public static void setUp() throws InterruptedException{
    	
        System.setProperty("webdriver.chrome.driver", "D:\\Projects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        String appUrl = Constant.baseURL;
               
		
		driver.get(appUrl);
		
		driver.findElement(By.xpath("/html/body/header/div/section[2]/nav/ul/li[3]/a")).click();
		
		Thread.sleep(10000);
		
        driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(Constant.Username);
        
        driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(Constant.Password);
        
        driver.findElement(By.id("mainButton")).click();
        
        Thread.sleep(10000);
        
        driver.findElement(By.xpath(".//*[@id='joinCourse']/span")).click();
        
        Thread.sleep(10000);
        
        driver.findElement(By.xpath(".//*[@id='root']/div/div/div[2]/div/div[2]/div/div[2]/div/a/div/div[1]/img")).click();
        
        Thread.sleep(80000);
        
        driver.findElement(By.id("startPath")).click();
        
        
        Thread.sleep(10000);
        
        
/*        Thread.sleep(10000);
        
        
    	WebElement pePanel_body = Quiz_Page.pePanel_body(driver);
    	System.out.println("PE Panel: " + pePanel_body.isDisplayed());
    	
    	
    	WebElement idk = Quiz_Page.btn_idontknow(driver);
    	System.out.println("PE Panel: " + idk.isDisplayed());
    	
    	WebElement ac = Quiz_Page.assessmentContent(driver);
    	System.out.println("PE Panel: " + ac.isDisplayed());
*/

/*    	WebElement button = Quiz_Page.btn_Submit(driver);
    	System.out.println("PE Panel: " + button.isEnabled());
*/    	
    	

    }
    
    
   
    @Parameters
    public static Collection spreadsheetData() throws IOException {
        InputStream spreadsheet = new FileInputStream(Constant.Path_TestData + Constant.File_TestData);
        return new ExcelUtils(spreadsheet).getData();
    }

    public Quiz_Page_Temp(String ipx) {
        super();
        this.ipx = ipx;
    }

    @Test
    public void shouldCalculateATimesB() {
    	
    	
    	System.out.println(ipx);
    	
        
        
    	WebElement pePanel_body = Quiz_Page.pePanel_body(driver);
    	System.out.println("PE Panel: " + pePanel_body.isDisplayed());
    	
    	
    	WebElement idk = Quiz_Page.btn_idontknow(driver);
    	System.out.println("PE Panel: " + idk.isDisplayed());
    	
    	WebElement ac = Quiz_Page.assessmentContent(driver);
    	System.out.println("PE Panel: " + ac.isDisplayed());

    	
/*	    	WebElement pePanel_body = Quiz_Page.pePanel_body(driver);
	    	System.out.println("PE Panel: " + pePanel_body.isDisplayed());
	    	
	    	WebElement button = Quiz_Page.btn_Submit(driver);
	    	System.out.println("PE Panel: " + button.isDisplayed());
	    	
	    	WebElement idk = Quiz_Page.btn_idontknow(driver);
	    	System.out.println("PE Panel: " + idk.isDisplayed());
*/

    }
    
    
}
