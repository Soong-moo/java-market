package market;

import java.util.HashMap;

public class Product {

	public static HashMap<String, Integer> test = new HashMap<String, Integer>();
	
	public void setProduct(String name, int price) {
		test.put(name, price);
	}
	
	
}
