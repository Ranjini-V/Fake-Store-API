package testcases;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import org.testng.annotations.BeforeClass;

import endpoint.Endpoints;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import util.ConfigReader;

public class BaseClass {

	ConfigReader configReader;
	//for logging
	RequestLoggingFilter requestLoggingFilter;
	ResponseLoggingFilter responseLoggingFilter;

	@BeforeClass
	public void setUp() {
		try {
			configReader = new ConfigReader();
			FileOutputStream fos = new FileOutputStream(".\\logs\\testLogs.log");
			PrintStream log = new PrintStream(fos, true);
			requestLoggingFilter = new RequestLoggingFilter(log);
			responseLoggingFilter = new ResponseLoggingFilter(log);

			RestAssured.filters(requestLoggingFilter, responseLoggingFilter);
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
