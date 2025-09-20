package testcases;

import org.testng.annotations.Test;

import endpoint.Endpoints;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

public class ProductTest extends BaseClass {

	// test to retrieve all products
	@Test
	public void testGetAllProducts() {
		given().when().get(Endpoints.GET_ALL_PRODUCTS).then().statusCode(200).body("size()", greaterThan(0)).log()
				.body();
	}
	
	
	// test to retrieve single product by ID
	@Test
	public void getSingleProduct() {
		
		int productId = configReader.getIntProperty("productID");
		
		given()
			.pathParam("id", productId)
		.when()
			.get(Endpoints.GET_PRODUCT_BY_ID)
		.then()
			.statusCode(200)
			.log().body();
	}

}