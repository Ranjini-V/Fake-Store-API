package testcases;

import org.testng.annotations.Test;

import endpoint.Endpoints;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.Payload;
import pojo.Products;

public class ProductTest extends BaseClass {

	// test to retrieve all products
	@Test
	public void testGetAllProducts() {

		given()
				.when()
				.get(Endpoints.GET_ALL_PRODUCTS)
				.then()
				.statusCode(200)
				.body("size()", greaterThan(0))
				.log()
				.body();
	}

	// test to retrieve single product by ID
	@Test
	public void testGetSingleProduct() {

		int productId = configReader.getIntProperty("productID");

		given()
				.pathParam("id", productId)
				.when()
				.get(Endpoints.GET_PRODUCT_BY_ID)
				.then()
				.statusCode(200)
				.log().body();
	}

	// test to retrieve a limited number of products
	@Test
	public void testGetLimitedProducts() {

		given()
				.pathParam("limit", 4)
				.when()
				.get(Endpoints.GET_PRODUCTS_WIH_LIMIT)
				.then()
				.statusCode(200)
				.log().body()
				.body("size()", equalTo(4));

	}

	// test to retrieve products sorted in descending order
	@Test
	public void testGetSortedProductsDescending() {

		Response response = given()
				.pathParam("order", "desc")
				.when()
				.get(Endpoints.GET_PRODUCTS_SORTED)
				.then()
				.statusCode(200)
				.extract().response();

		List<Integer> productId = response.jsonPath().getList("id", Integer.class);
		assertThat(isSortedDescending(productId), is(true));
	}

	// test to retrieve products sorted in ascending order
	@Test
	public void testGetSortedProductsAscending() {

		Response response = given()
				.pathParam("order", "asc")
				.when()
				.get(Endpoints.GET_PRODUCTS_SORTED)
				.then()
				.statusCode(200)
				.extract().response();

		List<Integer> productId = response.jsonPath().getList("id", Integer.class);
		assertThat(isSortedAscending(productId), is(true));
	}

	// test to get all products categories
	@Test
	public void testGetAllProductscategories() {

		given()
				.when()
				.get(Endpoints.GET_PRODUCTS_ALL_CATEGORIES)
				.then()
				.statusCode(200)
				.body("size()", greaterThan(0))
				.log().body();
	}

	// test to get products by category
	@Test
	public void testGetProductsCategory() {
		given()
				.pathParam("category", "electronics")
				.when()
				.get(Endpoints.GET_PRODUCTS_BY_CATEGORY)
				.then()
				.statusCode(200)
				.body("size()", greaterThan(0))
				.body("category", everyItem(notNullValue()))
				.body("category", everyItem(equalTo("electronics")));

	}

	// test to create a new product
	@Test
	public void testCreateProduct() {

		Products newProduct = Payload.productPayload();
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

		System.out.print("Product ID generated:" + productID);

	}

	// test to update an existing product
	@Test
	public void testUpdateProduct() {

		int productID = configReader.getIntProperty("productID");
		Products updatedPayload = Payload.productPayload();
		given()
				.contentType(ContentType.JSON).body(updatedPayload)
				.pathParam("id", productID)
				.when()
				.put(Endpoints.UPDATE_PRODUCT)
				.then()
				.log().body()
				.statusCode(200)
				.body("title", equalTo(updatedPayload.getTitle()));

	}

	// test to delete a product
	@Test
	public void testDeleteProduct() {

		int productID = configReader.getIntProperty("productID");

		given()
				.pathParam("id", productID)
				.when()
				.delete(Endpoints.DELETE_PRODUCT)
				.then()
				.statusCode(200);

	}

}