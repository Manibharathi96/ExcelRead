package org.excel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OpenFb {
public static WebDriver driver;
	
	

	@Parameters({"crossBrowser"})
	@Test
	public void  test(String browsername) {
		if (browsername.equals("chrome")) {
			  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Manibharathi\\"
			  		+ "eclipse-workspace\\Testing1\\Driver\\chromedriver.exe");
		 	    driver = new ChromeDriver();
			   
			}
		else if (browsername.equals("ff")) {
			  System.setProperty("webdriver.gecko.driver", "C:\\Users\\Manibharathi\\"
			  		+ "eclipse-workspace\\Testing1\\Driver\\geckodriver.exe");
			    driver = new FirefoxDriver();
			   
		}
		else {
			System.out.println("Not matched");
		}
		 driver.navigate().to("https://www.facebook.com/");
		 driver.manage().window().maximize();
		WebElement userTxt = driver.findElement(By.xpath("//input[@id='email']"));
		userTxt.sendKeys("Manibharathi");
	    WebElement pass = driver.findElement(By.xpath("//input[@id='pass']"));
		pass.sendKeys("123456789");
	}
	
	}

 
