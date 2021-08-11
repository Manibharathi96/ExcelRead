package org.excel;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNg {
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
		@BeforeMethod
		public void start() {
			Date d = new Date();
			System.out.println(d);
		}
		@AfterMethod
		public void end() {
			Date d = new Date();
			System.out.println(d);
		}
        @Parameters({"username"})
		@Test
		public void    test1(String username) {
			WebElement userTxt = driver.findElement(By.xpath("//input[@id='email']"));
			userTxt.sendKeys(username);
		}
	
		@Test(priority=1, groups= {"regression"})
			public void test2() {
		    WebElement pass = driver.findElement(By.xpath("//input[@id='pass']"));
			pass.sendKeys("password");
		}
		@Test(priority=2, groups= {"regression"})
		public void test3() {
			WebElement click = driver.findElement(By.xpath("//button[@name='login']"));
			click.click();
		}
		
}



