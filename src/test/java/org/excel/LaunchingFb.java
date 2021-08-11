package org.excel;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class LaunchingFb {
public static WebDriver driver;
	
	@BeforeClass
	public static void urlfb() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Manibharathi\\eclipse-workspace\\Testing1\\Driver\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.navigate().to("https://www.facebook.com/");
	    driver.manage().window().maximize();
	}
	
	@AfterClass
	public static void quit() {
		driver.quit();
	}
	@Before
	public void start() {
		Date d = new Date();
		System.out.println(d);
	}
	@After
	public void end() {
		Date d = new Date();
		System.out.println(d);
	}
	@Test
	public void test1() {
		Assert.assertTrue(driver.getCurrentUrl().contains("com"));
		Assert.assertTrue(driver.getTitle().contains("Facebook"));
		WebElement userTxt = driver.findElement(By.xpath("//input[@id='email']"));
		userTxt.sendKeys("Manibharathi");
	}
	
	@Test
	public void test2() {
	   WebElement pass = driver.findElement(By.xpath("//input[@id='pass']"));
		pass.sendKeys("123456789");
		Assert.assertEquals(pass.getAttribute("value"), "123456789");
	}
	
	@Test
	public void test3() {
		WebElement click = driver.findElement(By.xpath("//button[@name='login']"));
		click.click();
	}
	
	}



