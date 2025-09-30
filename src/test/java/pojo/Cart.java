package pojo;

import java.util.Date;
import java.util.List;

public class Cart {

	private int userID;
	private Date date;
	private List<CartProducts> products;

	public Cart(int userID, Date date, List<CartProducts> products) {
		this.userID = userID;
		this.date = date;
		this.products = products;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<CartProducts> getProducts() {
		return products;
	}

	public void setProducts(List<CartProducts> products) {
		this.products = products;
	}

}
