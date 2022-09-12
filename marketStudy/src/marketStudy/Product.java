package marketStudy;

//import java.util.HashMap;

public class Product {

	private String name;
	private int price;

	public Product() {
	};

	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	/*
	 * public static HashMap<String, Integer> test = new HashMap<String, Integer>();
	 * 
	 * public void setProduct(String name, int price) { test.put(name, price); }
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	// 가격 음수 판별
	public boolean isCheckingPrice(int price) {
		if (price < 0) {
			return false;
		} 
		else {
			return true;
		}
	}

}
