package marketStudy;

import java.util.Iterator;

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

	// ���� ���� �Ǻ�
	public boolean isCheckingPrice(int price) {
		if (price < 0) {
			return false;
		} else {
			return true;
		}
	}

	// ��ǰ�� �� (��ü�� ����?)
	public Product compareName(String name) {
		Iterator<Product> itr = ProductManagement.productList.iterator();
		while (itr.hasNext()) {
			Product product = itr.next();
			if (product.getName().equals(name)) {
				return product;
			}
		}
		return null;
	}

}
