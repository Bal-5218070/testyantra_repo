package com.testyantra.generic.fileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
public String getDataFromExcel(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
	FileInputStream fis2 =new FileInputStream("./testdata/Testyantra.xlsx");
	Workbook workbook = WorkbookFactory.create(fis2);
String data = workbook.getSheet(sheetname).getRow(rownum).getCell(cellnum).toString();
workbook.close();
return data;
}
public int getLastRowCount(String sheetname) throws EncryptedDocumentException, IOException {
	FileInputStream fis3 =new FileInputStream("./testdata/Testyantra.xlsx");
	Workbook workbook = WorkbookFactory.create(fis3);
	Sheet sheet = workbook.getSheet(sheetname);
	int rowcount=sheet.getLastRowNum();
	workbook.close();
	return rowcount;
}
public void setDataIntoExcelSheet(String sheetname,int rownum,int cellnum,String data) throws EncryptedDocumentException, IOException {
	FileInputStream fis4 =new FileInputStream("./testdata/Testyantra.xlsx");
	Workbook workbook = WorkbookFactory.create(fis4);
	Sheet sheet = workbook.getSheet(sheetname);
	Row row = sheet.getRow(rownum);
	Cell cell = row.createCell(cellnum);
	cell.setCellType(CellType.STRING);
	cell.setCellValue("pass");
	FileOutputStream fos2 =new FileOutputStream("./testdata/Testyantra.xlsx");
	workbook.write(fos2);
	workbook.close();
	
}
}

