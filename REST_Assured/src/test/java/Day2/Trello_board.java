package Day2;

import org.testng.annotations.Test;import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

import static io.restassured.matcher.RestAssuredMatchers.*;

public class Trello_board {
	//https://api.trello.com/1/boards/?name={name}&key=APIKey&token=APIToken
	
     @Test
     public void Create_Board() {
    	 
    	 RestAssured.baseURI="https://trello.com";
 		Response rep = given().queryParam("name", "Abhishek")
 		.queryParam("key", "b0e22a5cbe338f38c2887dc2e268ba05")
 		.queryParam("token", "ATTA866b89030566eaf6f98e4ab3627f8801d3a691ab61058c5ddf1206ba77dcb7cd0BBB5444")
 		.header("Content-Type","application/json")
 		.when().post("/1/boards/")
 		.then().contentType(ContentType.JSON)
 		.extract().response();
 		String str = rep.asString();
 		JsonPath js = new JsonPath(str);
 		String id = js.get("id");
 		System.out.println(id);
 		
 		given().queryParam("key", "b0e22a5cbe338f38c2887dc2e268ba05")
		.queryParam("token", "ATTA866b89030566eaf6f98e4ab3627f8801d3a691ab61058c5ddf1206ba77dcb7cd0BBB5444")
		.header("Content-Type", "application/json").when().delete("/1/boards/"+id).then().contentType(ContentType.JSON);
	}
    	 
    	 
     }
	


