package request_repository;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

import common_method.getData;

public class PutRequestRepository {
	
		public static String baseuri()
		{
			String baseuri = "https://reqres.in/";
			return baseuri ;
		}
		public static String resource()
		{
			String resource = "api/users/2";
			return resource ; 
		}
	
		public static String putRequestTc1() throws IOException
		{
			ArrayList<String> data= getData.getDataExcel("put_data","tc2");
			String name = data.get(1);
			String job =data.get(2);
			System.out.println(name+" "+job);
			String requestBody = "{\r\n"
					+ "    \"name\": \"morpheus\",\r\n"
					+ "    \"job\": \"zion resident\"\r\n"
					+ "}" ;
			
			return requestBody ;
		}
	  
}


