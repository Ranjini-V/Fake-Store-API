package endpoint;

public class Endpoints {

	public static final String BASE_URL = "https://fakestoreapi.com";

	// Products Endpoints

	public static final String GET_ALL_PRODUCTS = "/products";
	public static final String GET_PRODUCT_BY_ID = "/products/{id}";
	public static final String GET_PRODUCTS_WIH_LIMIT = "/products?limit=x";
	public static final String GET_PRODUCTS_SORTED = "/products?sort={order}";
	public static final String GET_PRODUCTS_BY_CATEGORY = "/products/{category}";
	public static final String GET_PRODUCTS_ALL_CATEGORIES = "/products/categories";
	public static final String CREATE_PRODUCT = "/products";
	public static final String UPDATE_PRODUCT = "/products/{id}:";
	public static final String DELETE_PRODUCT = "/products/{id}";

}
