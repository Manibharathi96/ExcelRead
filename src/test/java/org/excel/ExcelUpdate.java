package org.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUpdate {
public static void main(String[] args) throws Throwable{
		
		File f = new File("C:\\Users\\Manibharathi\\Desktop\\AugustBatch.xlsx");
	    
	    FileInputStream f1 = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(f1);
		Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(0);
		Cell c = r.getCell(0);
		int cellType = c.getCellType();
		if (cellType==1) {
		String value = c.getStringCellValue();
		System.out.println(value); 
		if (value.equals("Mani")) {
			c.setCellValue("Ramesh");
			
		}
				}
				else if (cellType==0) {
					if (DateUtil.isCellDateFormatted(c)) {
						Date d = c.getDateCellValue();
						SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
						String value = sd.format(d);
						System.out.println(value);
					}
					else {
						double d = c.getNumericCellValue();
						long l =(long)d;
						String value = String.valueOf(l);
						System.out.println(value);
					}
				}
		
		
	   FileOutputStream f2 = new FileOutputStream(f);
	    w.write(f2);
	
}
}



