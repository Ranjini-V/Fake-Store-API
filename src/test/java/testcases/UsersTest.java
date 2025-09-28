package testcases;

import org.testng.annotations.Test;

import endpoint.Endpoints;
import io.restassured.http.ContentType;

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

}
