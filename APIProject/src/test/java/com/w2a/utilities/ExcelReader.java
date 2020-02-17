package com.w2a.utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static  XSSFCell cell;
	public String path;
	 public ExcelReader(String path) throws Exception  
	{
	this.path = path;	
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			wb = new XSSFWorkbook(fis);
		
	}
	public static int getRowCount(String SheetName){
		int index = wb.getSheetIndex(SheetName);
		System.out.println("index:"+index);
		ws = wb.getSheetAt(index);
		int rownum = ws.getLastRowNum();
		System.out.println("row number:"+rownum);
		return rownum;
		
	}
	public static String getCellData(String SheetName,int rowNum,int colNum) throws IOException
	{
		int index = wb.getSheetIndex(SheetName);
		ws = wb.getSheetAt(index);
		row = ws.getRow(rowNum);
		cell = row.getCell(colNum);
		String data;
		try{
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			//System.out.println("Celldata"+cellData);
			return cellData;
				}
		catch(Exception e)
		{
			data="";
			return data;
		}	
			}
	public static int getCellCount(String SheetName,int rowNum){
		int index = wb.getSheetIndex(SheetName);
		ws = wb.getSheetAt(index);
		row = ws.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		return cellCount;
	}

	}






