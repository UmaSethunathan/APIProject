package com.w2a.utilities;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataUtil {
@DataProvider(name="data")
public static Object[][]getData(Method m) throws IOException{
		String Sheetname = m.getName();
		int rows = ExcelReader.getRowCount(Sheetname);
		int col = ExcelReader.getCellCount(Sheetname,1);
		Object[][] data = new Object[rows-1][col];
		System.out.println("Total Rows and col are"+rows+" "+col);
		for(int i=2;i<=rows;i++){
			for(int j=0;j<col;j++){
				data[i-2][j] = ExcelReader.getCellData(Sheetname, i, j);
			}
		}
		return data;
	}
}

