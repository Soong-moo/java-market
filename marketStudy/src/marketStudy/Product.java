package marketStudy;

import DB.DBManagement;

public class Product {

	private String name;
	private int price;

	public Product() {
	};

	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

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
	public static boolean isCheckingPrice(int price) {
		if (price < 0) {
			return false;
		} else {
			return true;
		}
	}

	
	public boolean compare(String name) {
		return new DBManagement().compare(name);
	}
	// 상품명 비교 (객체를 리턴?)
//	public Product compareName(String name) {
//		Iterator<Product> itr = pm.productList.iterator();
//		while (itr.hasNext()) {
//			Product product = itr.next();
//			if (product.getName().equals(name)) {
//				return product;
//			}
//		}
//		return null;
//	}

}
