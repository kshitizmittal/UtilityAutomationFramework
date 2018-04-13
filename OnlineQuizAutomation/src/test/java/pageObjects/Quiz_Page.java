package test.java.pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;




public class Quiz_Page {
	
	private static WebElement element = null;
	
	public static WebElement pePanel_body(WebDriver driver){

	    element = driver.findElement(By.xpath(".//*[@id='Assessment']/div/form/div[1]/div[1]/div"));

	    return element;

	    }
	
	public static WebElement assessmentContent(WebDriver driver){

	    element = driver.findElement(By.xpath(".//*[@id='Assessment']/div/form/div[1]/div[2]/div"));

	    return element;

	    }
	
	
	public static WebElement btn_Submit(WebDriver driver){

		element = driver.findElement(By.xpath(".//div[@class='pe-btn__primary--btn_large']"));

	    return element;

	    }
	
	public static WebElement btn_idontknow(WebDriver driver){

		element = driver.findElement(By.xpath(".//div[@class='idontknowbtn']"));

	    return element;

	    }

}
