package org.excel;


import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.collect.Table.Cell;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchExcel {
	public static  WebDriver driver;
	public static String price = null;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1280, 680));
		
		try{
		
		WebElement loginPopup = driver.findElement(By.xpath("//div[text()='Facebook']"));
		if(loginPopup.isDisplayed()){
			
		}
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		System.out.println("passed");
		
		driver.findElement(By.xpath("")).sendKeys("mobiles",Keys.ENTER);
		
		List<WebElement> mobileName = driver.findElements(By.xpath("//div[contains(text(),'GB')]/parent::div/div[1]"));
		
		List<WebElement> mobilePrice = driver.findElements(By.xpath("//div[contains(text(),'GB')]/parent::div/following-sibling::div/div[1]/div/div[1]"));
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet(" Student Data ");
		
	
		
		for (int i = 0; i < mobileName.size(); i++) {
			
			String names = mobileName.get(i).getText();
			System.out.println(names);
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(names);
			
			 price = mobilePrice.get(i).getText();
			System.out.println(price);
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(1);
			cell.setCellValue(price);
			
		}
		
		
		FileOutputStream out = new FileOutputStream(
	            new File("C:/savedexcel/GFGsheet.xlsx"));
	  
	        workbook.write(out);
	        out.close();
	        
	    //store in array and use ascending or descending order
	        int j = Integer.parseInt(price);
	        int[] k	= {100,10000};        
	    //    least value in array ----> excel 
	        
	        FileInputStream fis=new FileInputStream(new File("C:\\demo\\student.xls"));  
	        HSSFWorkbook wb=new HSSFWorkbook(fis);
	        HSSFSheet sheet=wb.getSheetAt(0);
	        int rows; // No of rows
	        rows = sheet.getPhysicalNumberOfRows();

	        int cols = 0; // No of columns
	        int tmp = 0;
	        
	        for (int i = 0; i < mobileName.size(); i++) {
	        	row = sheet.getRow(i);
	        	 if(row != null) {
	                 tmp = sheet.getRow(i);
	               String  cell = row.getCell(1).getStringCellValue();
	               int l = Integer.parseInt(cell);
	        if(k[0] == l){
	        	sheet.getRow(i);
	        	String  lestPriceMobilename = row.getCell(0).getStringCellValue();
	        }
	        }

		
		
	}
	        
	        driver.findElement(By.xpath("//div[text()='"+lestPriceMobilename+"']")).click();

}
