package payloads;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import com.github.javafaker.Faker;
import pojo.Products;
import pojo.Users;
import pojo.Address;
import pojo.Cart;
import pojo.CartProducts;
import pojo.GeoLocation;
import pojo.Name;

public class Payload {

	private final static Faker faker = new Faker();

	private static final String categoriesArray[] = { "Electronics", "Pharma", "Clothing", "Footwear", "Skincare" };
	static Random randomInt = new Random();

	// Product Payload
	public static Products productPayload() {
		String name = faker.commerce().productName();
		double price = Double.parseDouble(faker.commerce().price());
		String description = faker.lorem().sentence();
		String image = "https://th.bing.com/th/id/R.f7d881df439aca661025925b0e1a5883?rik=QWfY62W7BDhQVA&riu=http%3a%2f%2fi2.wp.com%2fthenewcamera.com%2fwp-content%2fuploads%2f2016%2f01%2fNikon-D500-Sample-Image-3.jpg&ehk=7T%2fUntkqKwYKjRDPBeLM5LJbYTdfqIomkYzs2jrgixk%3d&risl=&pid=ImgRaw&r=0";
		String category = categoriesArray[randomInt.nextInt(categoriesArray.length)];

		Products productsBody = new Products(name, price, description, image, category);

		return productsBody;
	}

	// User Payload
	public static Users usersPayload() {

		String email = faker.internet().emailAddress();
		String username = faker.funnyName().name();
		String password = faker.internet().password();
		String phone = faker.phoneNumber().subscriberNumber(10);

		String firstname = faker.name().firstName();
		String lastname = faker.name().lastName();
		Name name = new Name(firstname, lastname);

		String lat = faker.address().latitude();
		String longi = faker.address().longitude();
		GeoLocation geolocation = new GeoLocation(lat, longi);

		String city = faker.address().city();
		String street = faker.address().streetName();
		String number = faker.address().buildingNumber();
		String zipcode = faker.address().zipCode();
		Address address = new Address(city, street, number, zipcode, geolocation);

		Users usersPayloadBody = new Users(email, username, password, name, address, phone);

		return usersPayloadBody;

	}

	// Cart Payload
	public static Cart cartPayload(int userID) {

		List<CartProducts> products = new ArrayList<>();

		int productID = randomInt.nextInt(100);
		int quantity = randomInt.nextInt(10) + 1;

		CartProducts cartProducts = new CartProducts(productID, quantity);
		products.add(cartProducts);

		Date date = new Date();
		Cart cart = new Cart(userID, date, products);

		return cart;

	}

}
