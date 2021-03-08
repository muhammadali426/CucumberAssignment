package resources;

import java.io.FileReader;

import io.restassured.path.json.JsonPath;

public class reuseable {

	public static JsonPath rawToJson(String string)
	{
		JsonPath jp = new JsonPath(string);
		return jp;
		
	}
	
	

	public static JsonPath rawToJson(FileReader fileReader) {
		
		JsonPath jp = new JsonPath(fileReader);
		return jp;
		
	}
}
