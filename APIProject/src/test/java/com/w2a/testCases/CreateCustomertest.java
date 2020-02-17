package com.w2a.testCases;
import static io.restassured.RestAssured.*;
import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.w2a.Base.BaseTest;
import com.w2a.utilities.DataUtil;
import com.w2a.utilities.ExcelReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
public class CreateCustomertest extends BaseTest {
@Test(dataProviderClass=DataUtil.class,dataProvider="data")
public void validateCreateCustomerAPI(String name, String email, String desc)
{
		
	Response response = given().auth().basic(config.getProperty("ValidKey"),"").formParam("email",email).formParam("description",desc).post(config.getProperty("CustomerEndpoint"));
	response.prettyPrint();
	System.out.println(response.statusCode());
}
	
}

