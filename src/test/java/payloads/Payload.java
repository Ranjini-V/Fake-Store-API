package payloads;

import java.util.Random;
import com.github.javafaker.Faker;
import pojo.Products;

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

}
