package test_class;

import java.io.IOException;
import java.time.LocalDate;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common_method.CommonMethodApi;
import common_method.CommonMethodUtilities;
import io.restassured.path.json.JsonPath;
import request_repository.PostRequestRepository;

public class PostTc1 {
	@Test
	public static void orchestrator() throws IOException {
		String responseBody = "";
		int responseStatuscode = 0;
		String baseUri = PostRequestRepository.baseuri();
		String resource = PostRequestRepository.resource();
		String requestBody = PostRequestRepository.postRequestTc1();
		for (int i = 0; i < 5; i++) {
			responseStatuscode = CommonMethodApi.postResponseStatuscodeExtractor(baseUri, resource, requestBody);

			if (responseStatuscode == 201) {
				responseBody = CommonMethodApi.postResponseBodyExtractor(baseUri, resource, requestBody);
				responseBodyValidator(responseBody,requestBody);
			

			} else {
				System.out.println("correct status code is not found in the iteration " + i);
			}
		}
		CommonMethodUtilities.evidenceFileCreator("PostTc1", requestBody, responseBody);
		Assert.assertEquals(responseStatuscode, 201);

	}
	
  
	public static void responseBodyValidator(String responseBody, String requestBody) {
		// create jsonPath object to extract responseBody parameters
		JsonPath req_jsp = new JsonPath(requestBody);
		JsonPath res_jsp = new JsonPath(responseBody);

		// extract request parameters
		String req_name = req_jsp.getString("name");
		String req_job = req_jsp.getString("job");
	
		// extract responseBody parameters
		String res_name = req_jsp.getString("name"); 
		String res_job = res_jsp.getString("job");
		String res_id = res_jsp.getString("id");
		String res_createdAt = res_jsp.getString("createdAt");

		// System.out.println("name : " + res_name + "\njob : " + res_job + "\nid : " +
		// res_id + "\ncreatedAt : "
		// + res_createdAt);

		// validate responseBody parameter
		Assert.assertEquals(res_name, req_name);
		Assert.assertEquals(res_job, req_job);
		Assert.assertNotNull(res_id, "assertion error , id parameter is null");
	//Assert.assertEquals(res_id, req_id);

		// extract date from createdAt parameter
		String actual_date = res_createdAt.substring(0, 10);
		String current_date = LocalDate.now().toString(); // Create a date object
		Assert.assertEquals(actual_date, current_date);
		// System.out.println("ACtual DATE : " + actual_date + "\nCURRENT DATE : " +
		// current_date);

	}

}
