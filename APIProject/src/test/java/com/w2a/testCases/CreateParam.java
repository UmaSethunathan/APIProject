package com.w2a.testCases;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.Test;

import com.w2a.Base.BaseTest;
import com.w2a.utilities.APIClass;
import com.w2a.utilities.Parameterization;

import io.restassured.response.Response;

public class CreateParam extends BaseTest {
@Test(dataProviderClass=Parameterization.class,dataProvider="Paramdata")
 public void validateCreateCustomerAPI(Hashtable<String, String> d){
	Response response = APIClass.SendPostRequestAPIMethods(d);
	response.prettyPrint();
	System.out.println(response.statusCode());
 }




}
