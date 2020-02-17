package com.w2a.utilities;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.w2a.Base.BaseTest;

import io.restassured.response.Response;

public class APIClass extends BaseTest{
	public static Response SendPostRequestAPIMethods(Hashtable<String,String> d){
	Response response = given().auth().basic(config.getProperty("ValidKey"),"").formParam("email",d.get("email"))
			.formParam("description",d.get("desc")).post(config.getProperty("CustomerEndpoint"));
	return response;
}
}