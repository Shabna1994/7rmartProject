package com.qa.exelcode;

import java.io.FileInputStream;
import java.io.IOException;
//import java.io.InputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.obsqura.main.base.Base;

public class ExelRead extends Base {

	static 	FileInputStream f;   
	static XSSFWorkbook w;
	static XSSFSheet s;    
	
	public static String readstringdata(int i,int j,String sheetName,String exelSheet)throws IOException
	{  
	f=new FileInputStream(exelSheet);  
	
	w=new XSSFWorkbook (f);
	s=w.getSheet(sheetName);
	Row r =s.getRow(i);//interface
	Cell c=r.getCell(j); //interface
	return c.getStringCellValue();
	}
	public static String readIntData(int i,int j,String sheetName,String exelSheet)throws IOException
	{
		f=new FileInputStream(exelSheet);
		w=new XSSFWorkbook (f);
		s=w.getSheet(sheetName);
		Row r =s.getRow(i);
		Cell c=r.getCell(j);
		
		//int d=(int)c.getNumericCellValue();	//if cell value is integer which convert to string value
		//return String.valueOf(d); //String valueOf    
		
		return c.getStringCellValue();
	}
	
	
}
