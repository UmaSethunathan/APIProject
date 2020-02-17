package com.w2a.utilities;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Parameterization {
	@DataProvider(name="Paramdata")
	public static Object[][] getdata(Method m){
		String SheetName=m.getName();
		System.out.println("SheetName:"+SheetName);
		int rows = ExcelReader.getRowCount(SheetName);
		System.out.println("total rows:"+rows);
		int col = ExcelReader.getCellCount(SheetName,1);
		System.out.println("total cols:"+col);
		Object[][] data= new Object[rows][1];
		Hashtable<String,String> table = null;
		for(int i=1;i<=rows;i++){
			table = new Hashtable<String,String>();
			for(int j=0;j<col;j++){
			try {
				table.put(ExcelReader.getCellData(SheetName, 0, j), ExcelReader.getCellData(SheetName, i, j));
				data[i-1][0]=table;

				//System.out.println(XLUtil.getCellData(SheetName, i,j));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			}
		}
		
		return data;	
			
	}
}
