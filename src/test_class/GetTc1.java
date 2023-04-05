package test_class;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import common_method.CommonMethodApi;
import common_method.CommonMethodUtilities;
import io.restassured.path.json.JsonPath;
import request_repository.GetRequestRepository;

public class GetTc1 {
	@Test
		public static void orchestrator() throws IOException
		{    
			String responseBody = "" ;
			int responseStatuscode = 0;
			String baseUri = GetRequestRepository.baseuri();
			String resource = GetRequestRepository.resource();
			String requestBody = "";
			for(int i=0 ; i<5 ; i++) 
	        {
			 responseStatuscode = CommonMethodApi.getResponseStatuscodeExtractor(baseUri, resource, requestBody);	
	          if (responseStatuscode == 200)
			  {
				responseBody = CommonMethodApi.getResponseBodyExtractor(baseUri, resource, requestBody);
				responseBodyValidator(responseBody);
				
				break;
		      }
	          else
	          {
	        	  System.out.println("correct status code is not found in the iteration " + i);
	          }
	        } 
			CommonMethodUtilities.evidenceFileCreator("GetTc1",requestBody,responseBody);
			Assert.assertEquals(responseStatuscode, 200);
			
	     }

	    public static void responseBodyValidator(String responseBody)
		{
			// create jsonPath object to extract responseBody parameters
			JsonPath jsp = new JsonPath(responseBody);

			//find length of data object array
			int data_array_len = jsp.getInt("data.size()");
			//System.out.println("data JSON object length : "+data_array_len);
			
			//extract responsebody parameters data object 
			
		    int exp_id[] = {7,8,9,10,11,12};
		    String exp_email[] = {"michael.lawson@reqres.in","lindsay.ferguson@reqres.in","tobias.funke@reqres.in","byron.fields@reqres.in","george.edwards@reqres.in","rachel.howell@reqres.in"};
		    String exp_fname[] = {"Michael","Lindsay","Tobias","Byron","George","Rachel"};
		    String exp_lname[] = {"Lawson","Ferguson","Funke","Fields","Edwards","Howell"};
		    String exp_avatar[] = {"https://reqres.in/img/faces/7-image.jpg","https://reqres.in/img/faces/8-image.jpg","https://reqres.in/img/faces/9-image.jpg","https://reqres.in/img/faces/10-image.jpg","https://reqres.in/img/faces/11-image.jpg","https://reqres.in/img/faces/12-image.jpg"};

		    //String d = jsp.getString("data");
		         
		   // System.out.println("DATA JSON OBJECT ELEMENTS : ");    
		   
			for(int i=0 ; i<data_array_len ; i++)
			{   
				int res_id = jsp.getInt("data["+i+"].id");
				String res_email = jsp.getString("data["+i+"].email");
				String res_fname = jsp.getString("data["+i+"].first_name");
				String res_lname = jsp.getString("data["+i+"].last_name");
				String res_avatar = jsp.getString("data["+i+"].avatar");
				
				/*System.out.println(res_id); 
				System.out.println(res_email);
		        System.out.println(res_fname);
		        System.out.println(res_lname);
		        System.out.println(res_avatar);  */
		        
				Assert.assertEquals(res_id,exp_id[i]);
				Assert.assertEquals(res_email,exp_email[i]);
				Assert.assertEquals(res_fname,exp_fname[i]);
				Assert.assertEquals(res_lname,exp_lname[i]);
				Assert.assertEquals(res_avatar,exp_avatar[i]);
				
			}

				
		}
	}
