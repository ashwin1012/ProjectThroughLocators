package com.actitime.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLibClass {

	public String getPropertyData(String key) throws IOException {
	FileInputStream fis=new FileInputStream("./data/data.property");
	Properties p=new Properties();
	p.load(fis);
	String data1 = p.getProperty(key);
	return data1;
	}
public String getExcelData(String sheetName,int row,int cell) throws EncryptedDocumentException,IOException {
	FileInputStream fi=new FileInputStream("./data/testscript.xlsx");
	Workbook wb = WorkbookFactory.create(fi);
	String data2 = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
	return data2;
}
}








