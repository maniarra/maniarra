package com.cts.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReport {

public Object[][] getData() throws IOException  {
		
		Object[][] testData = null;
	
	FileInputStream file = new FileInputStream("E:\\eclipse\\eclipse-jee-oxygen-R-win32-x86_64\\eclipse\\WebShopApp\\src\\test\\resources\\Testdata\\maniexcel.xlsx");
	// OPening the workbook
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet loginSheet = workbook.getSheet("Sheet1");
	//to get the number of row in the excel 
	int numberOfData = loginSheet.getPhysicalNumberOfRows();
	System.out.println(numberOfData);
	
	testData = new Object[numberOfData][2];
	
	for(int i=0;i<numberOfData;i++)
	{
		XSSFRow row = loginSheet.getRow(i);
		XSSFCell email = row.getCell(0);
		XSSFCell password = row.getCell(1);
		// to get the value of the cells
		testData[i][0] = email.toString();
		testData[i][1] = password.toString();			
		System.out.println(testData[i][0]);
		System.out.println(testData[i][1]);
	}
			
	return testData;
}

//to get email
	public String excel_username(int a) throws IOException {

		FileInputStream file = new FileInputStream(new File("\"E:\\maniexcel.xlsx\""));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int count = sheet.getLastRowNum();
		System.out.println(count);

		XSSFRow row = sheet.getRow(a);
		XSSFCell cell = row.getCell(0);
		String email = cell.toString();

		return email;
	}

	// to get password
	public String excel_password(int b) throws IOException {

		FileInputStream file = new FileInputStream(new File("\"E:\\maniexcel.xlsx\""));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int count = sheet.getLastRowNum();
		System.out.println(count);

		XSSFRow row = sheet.getRow(b);
		XSSFCell cell1 = row.getCell(1);
		String password = cell1.toString();

		return password;
	}

	
}
