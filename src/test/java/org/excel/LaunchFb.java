package org.excel;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LaunchFb {
	public static WebDriver driver;
	
	
	public static void urlfb() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Manibharathi\\eclipse-workspace\\Testing1\\Driver\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.navigate().to("https://www.facebook.com/");
	    driver.manage().window().maximize();
	}
	
	public static void quit() {
		driver.quit();
	}
	public void start() {
		Date d = new Date();
		System.out.println(d);
	}
	
	public void end() {
		Date d = new Date();
		System.out.println(d);
	}
	@Test
	public void    () {
		WebElement userTxt = driver.findElement(By.xpath("//input[@id='email']"));
		userTxt.sendKeys("Manibharathi");
	    WebElement pass = driver.findElement(By.xpath("//input[@id='pass']"));
		pass.sendKeys("123456789");
	}
	@Test
	public void test2() {
		WebElement click = driver.findElement(By.xpath("//button[@name='login']"));
		click.click();
	}
	
	}
