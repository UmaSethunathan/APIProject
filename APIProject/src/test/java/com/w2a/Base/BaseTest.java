package com.w2a.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;

import com.w2a.utilities.ExcelReader;

import io.restassured.RestAssured;

public class BaseTest {
	public static Properties config = new Properties();
	private FileInputStream fis;
	public static ExcelReader excel;
@BeforeSuite
public void setup() throws Exception{
		try {
			fis = new FileInputStream(".\\src\\test\\resources\\config.properties");
			 excel = new ExcelReader(".\\src\\test\\resources\\Excel\\testdata.xlsx");
			config.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RestAssured.baseURI = config.getProperty("BaseURI");
		RestAssured.basePath = config.getProperty("Basepath");
		
}
}
