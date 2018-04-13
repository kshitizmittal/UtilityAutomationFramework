 package test.java.pageObjects;

 import org.openqa.selenium.By;

 import org.openqa.selenium.WebDriver;

 import org.openqa.selenium.WebElement;

public class LogIn_Page {

    private static WebElement element = null;

 public static WebElement txtbx_UserName(WebDriver driver){

    element = driver.findElement(By.xpath(".//*[@id='username']"));

    return element;

    }

 public static WebElement txtbx_Password(WebDriver driver){

    element = driver.findElement(By.xpath(".//*[@id='password']"));

 return element;

    }
 
 public static WebElement btn_LogIn(WebDriver driver){

	    element = driver.findElement(By.id("mainButton"));

	 return element;

	    }
 
 public static WebElement btn_SignIn(WebDriver driver){

	    element = driver.findElement(By.xpath("/html/body/header/div/section[2]/nav/ul/li[3]/a"));

	 return element;

	    }
 
 public static WebElement img_Tile(WebDriver driver){

	    element = driver.findElement(By.xpath(".//*[@id='root']/div/div/div[2]/div/div[2]/div/div[2]/div/a/div/div[1]/img"));
	    
	  

	 return element;

	    }
 
 public static WebElement btn_joinCourse(WebDriver driver){

	    element = driver.findElement(By.xpath(".//*[@id='joinCourse']/span"));

	 return element;

	    }
 
 public static WebElement btn_continue(WebDriver driver){

	    element = driver.findElement(By.id("startPath"));

	 return element;

	    }
 

}