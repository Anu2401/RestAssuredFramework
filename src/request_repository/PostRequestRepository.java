package request_repository;

import java.io.IOException;
import java.util.ArrayList;
import org.testng.annotations.Test;
import common_method.getData;
public class PostRequestRepository {
	
	public static String baseuri()
	{
		String baseuri = "https://reqres.in/";
		return baseuri ;
	}
	public static String resource()
	{
		String resource = "api/users";
		return resource ; 
		
	}
	
	public static String postRequestTc1() throws IOException
	{
		
		ArrayList<String> data= getData.getDataExcel("post_data","tc1");
		String name = data.get(1);
		String job =data.get(2);
		System.out.println(name+" "+job);
		String requestBody = "{\r\n"
				+ "    \"name\": \""+name+"\",\r\n"
				+ "    \"job\": \""+job+"\"\r\n"
				+ "}" ;
		
		return requestBody ;
}
}
