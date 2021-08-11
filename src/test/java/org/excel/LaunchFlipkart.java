package org.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchFlipkart {
	static List<String> l = new ArrayList<String>();
	static List<String> l1 = new ArrayList<String>();
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		WebElement close = driver.findElement(By.xpath("//button[text()='✕']"));
		close.click();
		WebElement input = driver.findElement(By.xpath("//input[@type='text']"));
		input.sendKeys("iphone11");
		WebElement search = driver.findElement(By.xpath("//button[@type='submit']"));
		search.click();
		Thread.sleep(3000);
		List<WebElement> phone = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		List<WebElement> cost = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		for (WebElement x : phone) {
			String text = x.getText();
			l.add(text);
			System.out.println(text);
		}
		for (WebElement y : cost) {
			String t1 = y.getText();
			l1.add(t1);
	    System.out.println(t1);
	}
		File f = new File("C:\\Users\\Manibharathi\\Desktop\\Iphone.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet c = w.createSheet();
		Row r1 = c.createRow(0);
		Cell c1 = r1.createCell(0);
		c1.setCellValue("IPHONE11 MODELS");
	//---------------------------------------------------//
		for (int i = 1; i < l.size(); i++) {
			Row r = c.createRow(i);
			Cell e = r.createCell(0); 
			e.setCellValue(l.get(i));
		
		
	// ----------------------------------------------------//	
		for (int j = 1; j < l1.size(); j++) {
			
			 Cell cell = r.createCell(1);
			 cell.setCellValue(l1.get(j));
		}
		}
		FileOutputStream o = new FileOutputStream(f);
		w.write(o);
		
		driver.close();
		}
		
	}


