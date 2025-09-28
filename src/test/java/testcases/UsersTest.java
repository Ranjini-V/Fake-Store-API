package testcases;

import org.testng.annotations.Test;

import endpoint.Endpoints;
import io.restassured.http.ContentType;
import payloads.Payload;
import pojo.Products;
import pojo.Users;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@SuppressWarnings("unused")
public class UsersTest extends BaseClass {

	// Get all Users
	@Test
	public void testGetAllUsers() {

		given()
				.when()
				.get(Endpoints.GET_ALL_USERS)
				.then()
				.statusCode(200)
				.contentType(ContentType.JSON)
				.assertThat().body(matchesJsonSchemaInClasspath("schemas/usersSchema.json"))
				.body("size()", greaterThan(0))
				.log().body();

	}

	// Get user by ID
	@Test
	public void testGetUserByID() {

		int userId = configReader.getIntProperty("userId");

		given()
				.pathParam("id", userId)
				.when()
				.get(Endpoints.GET_USER_BY_ID)
				.then()
				.statusCode(200)
				.contentType(ContentType.JSON)
				.assertThat().body(matchesJsonSchemaInClasspath("schemas/singleUserSchema.json"))
				.body("size()", greaterThan(0))
				.log().body();
	}

	// Create new User
	@Test
	public void testCreateUser() {

		int userID;
		Users user = Payload.usersPayload();

		userID = given()
				.contentType(ContentType.JSON)
				.body(user)
				.when()
				.post(Endpoints.CREATE_USER)
				.then()
				.log().body()
				.statusCode(201)
				.body("id", notNullValue())
				.extract().response().jsonPath().getInt("id");
	}

}
