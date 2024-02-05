package Day1;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

import static io.restassured.matcher.RestAssuredMatchers.*;

public class REST_Assured {

	
	 @Test(enabled = false)
	 public void setup() {
	
	  Response rep = RestAssured.get("https://reqres.in/api/users");
	   int a = rep.getStatusCode();
	   Assert.assertEquals(a, 200);
	  
	   }
	 
	 @Test(enabled = false)
		public void ListUsers() {
			given().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all();
		}
	 
	 
		@Test(enabled = false)
		public void SingleUser() {
			given().get("https://reqres.in/api/users/2").then().statusCode(200).body("data.first_name", equalTo("Janet")).log().all();
		}
		
		
		@Test(enabled = false)
		public void SINGLE_USER_NOT_FOUND() {
			given().get("https://reqres.in/api/users/23").then().statusCode(404).log().all();
		}
		
		@Test(enabled = false)
		public void LIST_RESOURCE(){
			given().get("https://reqres.in/api/unknown").then().statusCode(200).log().all();
			
		}
		
	    @Test(enabled = false)
	    public void SINGLE_RESOURCE() {
	    	
	    	given().get("https://reqres.in/api/unknown/2").then().statusCode(200).body("data.name", equalTo("fuchsia rose")).log().all();
	    }
		
		@Test(enabled = false)
		public void SINGLE_RESOURCE_NOT_FOUND() {
			
			given().get("https://reqres.in/api/unknown/23").then().statusCode(404).log().all();
		}
		
		@Test(enabled = false)
		public void CREATE() {
			
			JSONObject obj = new JSONObject();	
			 obj.put("name", "Abhi");
			 obj.put("job", "Silent Tester");
			 given().body(obj.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
	
		}
		
		
		 @Test(enabled = false)
		 public void Delete() {
			 given().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
			 
		 }
		 
		 @Test(enabled = false)
		 public void REGISTER_SUCCESSFUL() {
			 JSONObject obj = new JSONObject();	
			 obj.put("email", "SilentKiller@gmail.com");
			 obj.put("password", "gun123");
			 
			 given().body(obj.toJSONString()).when().post("https://reqres.in/api/register").then().statusCode(200).log().all();
			 
		 }
		 
	 @Test(enabled = false)
	public void REGISTER_UNSUCCESSFUL() {
		 JSONObject obj = new JSONObject();	
		 obj.put("email", "SilentKiller@gmail.com");
		
		 given().body(obj.toJSONString()).when().post("https://reqres.in/api/register").then().statusCode(400).log().all();
		 
	}
	 
	 @Test(enabled = false)
	 public void LOGIN_UNSUCCESSFUL() {
		 
		 JSONObject obj = new JSONObject();
		 obj.put("email", "SilentKiller@gmail.com");
		
		 given().body(obj.toJSONString()).when().post("https://reqres.in/api/login").then().statusCode(400).log().all();
	 }
	 
	 @Test(enabled = true)
	 public void DELAYED_RESPONSE() {
		 
		 given().get("https://reqres.in/api/users?delay=3").then().statusCode(200).log().all();
	 }
		
		
		
		
		
}
