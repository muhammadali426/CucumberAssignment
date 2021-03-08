package stepDefinitions;



import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.FileReader;

import resources.reuseable;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class StepDefinition {

	
	
	
	String toCurrency;
	double toCurrency1;
	String fromCurrency;
	double fromCurrency1;
	double convert;
	double amount;
	String path = "src/test/java/resources/rate.json";
	
	
	
	@Given("User select {string} {string} {string} from {string}")
	public void user_select_from(String toCur, String fromCur, String amt,String path) throws FileNotFoundException {
       // Write code here that turns the phrase above into concrete actions
	
		
		  
		
		if(path.equalsIgnoreCase("JSONFILE"))
		  {
			
		JsonPath js =  reuseable.rawToJson(new FileReader("src/test/java/resources/rate.json"));

		        toCurrency = js.getString(toCur);
				toCurrency1 = Double.parseDouble(toCurrency);
				fromCurrency = js.getString(fromCur);
				fromCurrency1 = Double.parseDouble(fromCurrency);
				amount = Double.parseDouble(amt);
				System.out.println("Input");
				System.out.println("From Currnecy -> "+fromCur.substring(6));
				System.out.println("To Currency -> "+toCur.substring(6));
				System.out.println("amount -> "+amt);
				
		  }
		else
		{
			RestAssured.baseURI ="https://api.exchangeratesapi.io";
			String getResponse =  given().log().all().queryParam("base", "USD").when().get("latest").then()
			.assertThat().log().all().statusCode(200).extract().response().asString();
			
			
	
			JsonPath js =  reuseable.rawToJson(getResponse);
			int count = js.getInt("rates.size()");
			System.out.println(count);
			
	        toCurrency = js.getString(toCur);
			toCurrency1 = Double.parseDouble(toCurrency);
			fromCurrency = js.getString(fromCur);
			fromCurrency1 = Double.parseDouble(fromCurrency);
			amount = Double.parseDouble(amt);
			System.out.println("Input");
			System.out.println("From Currnecy -> "+fromCur.substring(6));
			System.out.println("To Currency -> "+toCur.substring(6));
			System.out.println("amount -> "+amt);
	
			
		}

	 	
	}
	
	
	@Given("Show the The Exhange Rate and Converted Result")
	public void show_the_The_Exhange_Rate_and_Converted_Result() {
	    
		System.out.println("Output");
		convert = toCurrency1 / fromCurrency1;
		amount = amount*convert;
		System.out.println("Exchange Rate -> "+toCurrency);
		System.out.println("Converted Result -> "+amount);
		
	}
}
