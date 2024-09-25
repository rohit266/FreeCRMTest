package com.crm.qa.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class BrowserStackReadExcelTest {

	public static void main(String[] args) throws IOException {
	
		//Path of the excel file
		
		File file =   new File("E:\\Rohit\\EclipseWorkstation\\JavaTraining\\FreeCRMTest\\src\\main\\java\\com"
				+ "\\crm\\qa\\testdata\\FreeCRMTestData.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(inputStream);
		XSSFSheet sheet=wb.getSheet("Contacts");
		XSSFRow row1=sheet.getRow(1);
		System.out.println(sheet.getRow(1).getCell(0));
		
		//Creating a workbook
//		Workbook book = null;
//		book = new XSSFWorkbook(fs);
//		Sheet sht = book.getSheetAt(0);
//		Row row = sht.getRow(0);
//		Cell cell = row.getCell(0);
//		System.out.println(sht.getRow(1).getCell(0));

	}

}
