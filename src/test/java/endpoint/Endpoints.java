package endpoint;

public class Endpoints {

	public static final String BASE_URL = "https://fakestoreapi.com";

	// Products Endpoints

	public static final String GET_ALL_PRODUCTS = "/products";
	public static final String GET_PRODUCT_BY_ID = "/products/{id}";
	public static final String GET_PRODUCTS_WIH_LIMIT = "/products?limit={limit}";
	public static final String GET_PRODUCTS_SORTED = "/products?sort={order}";
	public static final String GET_PRODUCTS_BY_CATEGORY = "/products/{category}";
	public static final String GET_PRODUCTS_ALL_CATEGORIES = "/products/categories";
	public static final String CREATE_PRODUCT = "/products";
	public static final String UPDATE_PRODUCT = "/products/{id}";
	public static final String DELETE_PRODUCT = "/products/{id}";

	// Users Endpoints

	public static final String GET_ALL_USERS = "/users";
	public static final String GET_USER_BY_ID = "/users/{id}";
	public static final String CREATE_USER = "/users";
	public static final String GET_USERS_SORTED = "/users?sort={order}";
	public static final String UPDATE_USER_FIELD = "/users/{id}";

}
