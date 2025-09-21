package testcases;

import java.io.IOException;
import java.util.List;

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
	
	
	public boolean isSortedDescending(List<Integer> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) < list.get(i + 1)) {
				return false;
			}
		}
		return true;
	}
	
	
	public boolean isSortedAscending(List<Integer> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) > list.get(i + 1)) {
				return false;
			}
		}
		return true;
	}

}
