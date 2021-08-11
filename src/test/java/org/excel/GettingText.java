package org.excel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.excel.LaunchFb;
public class GettingText {
	@Test
	public void test4() {
		
		WebElement logIn = driver.findElement(By.name("login"));
		Assert.assertTrue(logIn.getText().contains("what"));
		logIn.getText();
		System.out.println(logIn);
	} 
	
	@Test
	public void test5(){
		WebElement btn = driver.findElement(By.xpath("(//a[@role='button'])[3]"));
		btn.getText();
	}
}
