package testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import java.util.Map;

import org.testng.annotations.Test;

import endpoint.Endpoints;
import io.restassured.http.ContentType;
import payloads.Payload;
import pojo.Products;

@SuppressWarnings("unused")
public class ProductDataDrivenTest extends BaseClass {

	@Test(dataProvider = "jsonDataProvider", dataProviderClass = util.DataProviders.class)
	public void testAddNewProduct(Map<String, String> data) {

		String title = data.get("title");
		Double price = Double.parseDouble(data.get("price"));
		String description = data.get("description");
		String image = data.get("image");
		String category = data.get("category");

		Products newProduct = new Products(title, price, description, image, category);
		int productID = given()
				.contentType(ContentType.JSON)
				.body(newProduct)
				.when()
				.post(Endpoints.CREATE_PRODUCT)
				.then()
				.log().body()
				.statusCode(201)
				.body("id", notNullValue())
				.body("title", equalTo(newProduct.getTitle()))
				.extract().response().jsonPath().getInt("id");

		System.out.println("Product ID generated:" + productID);

		// Delete created Products
		given()
				.pathParam("id", productID)
				.when()
				.delete(Endpoints.DELETE_PRODUCT)
				.then()
				.statusCode(200);

		System.out.print("Product ID deleted:" + productID);

	}

}
