package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;

import endpoint.Endpoints;
import io.restassured.RestAssured;
import util.ConfigReader;

public class BaseClass {

	ConfigReader configReader;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
	                                           

	@BeforeClass
	public void setUp() {
		try {
			configReader = new ConfigReader();
		} catch (IOException e) {
			e.printStackTrace();
		}
		RestAssured.baseURI = Endpoints.BASE_URL;

	}

}
