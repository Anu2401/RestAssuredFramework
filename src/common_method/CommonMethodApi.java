package common_method;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class CommonMethodApi {

	public static int postResponseStatuscodeExtractor(String baseuri,String resource,String requestBody)
	{
		
		RestAssured.baseURI=baseuri;
		int responseStatuscode = given().header("Content-Type","application/json").body(requestBody)
				                 .when().post(resource)
				                 .then().extract().statusCode();
		return responseStatuscode ;
		
	}
	public static String postResponseBodyExtractor(String baseuri , String resource , String requestBody)
	{
		RestAssured.baseURI=baseuri;
		String responseBody = given().header("Content-Type","application/json").body(requestBody)
				              .when().post(resource)
				.then().extract().response().asString();
		return responseBody ;
		
	}
	public static int getResponseStatuscodeExtractor(String baseuri,String resource,String requestBody)
	{
		
		RestAssured.baseURI=baseuri;
		int responseStatuscode = given().header("Content-Type","application/json").body(requestBody)
				                 .when().get(resource)
				                 .then().extract().statusCode();
		return responseStatuscode ;
		
	}
	public static String getResponseBodyExtractor(String baseuri , String resource , String requestBody)
	{
		RestAssured.baseURI=baseuri;
		String responseBody = given().header("Content-Type","application/json").body(requestBody)
				              .when().get(resource)
				.then().extract().response().asString();
		return responseBody ;
		
	}
	public static int putResponseStatuscodeExtractor(String baseuri,String resource,String requestBody)
	{
		
		RestAssured.baseURI=baseuri;
		int responseStatuscode = given().header("Content-Type","application/json").body(requestBody)
				                 .when().put(resource)
				                 .then().extract().statusCode();
		return responseStatuscode ;
		
	}
	public static String putResponseBodyExtractor(String baseuri , String resource , String requestBody)
	{
		RestAssured.baseURI=baseuri;
		String responseBody = given().header("Content-Type","application/json").body(requestBody)
				              .when().put(resource)
				.then().extract().response().asString();
		return responseBody ;
		
	}
	public static int patchResponseStatuscodeExtractor(String baseuri,String resource,String requestBody)
	{
		
		RestAssured.baseURI=baseuri;
		int responseStatuscode = given().header("Content-Type","application/json").body(requestBody)
				                 .when().patch(resource)
				                 .then().extract().statusCode();
		return responseStatuscode ;
		
	}
	public static String patchResponseBodyExtractor(String baseuri , String resource , String requestBody)
	{
		RestAssured.baseURI=baseuri;
		String responseBody = given().header("Content-Type","application/json").body(requestBody)
				              .when().patch(resource)
				.then().extract().response().asString();
		return responseBody ;
		
	}
}
