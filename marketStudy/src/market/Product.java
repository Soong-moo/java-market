package market;

//import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

public class Product {

	private String name;
	private int price;

	public Product() {
	};

	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	// public static HashMap<String, Integer> test = new HashMap<String, Integer>();

	// public void setProduct(String name, int price) {
	// test.put(name, price);
	// }

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

	public void addProduct(String name) {
		System.out.println(name + "���´�");
	}

	// ��ǰ �߰�
	public void addProduct(String name, int price) {
		Iterator<Product> itr = ProductList.a.iterator();
		while (itr.hasNext()) {
			Product product = itr.next();
			if (product.getName().equals(name)) {
				System.out.println("�̹� �ִ� ��ǰ�Դϴ�.");
				return;
			}
		}
		if (price < 0) {
			System.out.println("������ ������ �� �� �����ϴ�.");
			return;
		}
		Product p = new Product(name, price);
		// p.setName(name);
		// p.setPrice(price);
		ProductList.a.add(p);
	}

	// ��ǰ ��ȸ (��� ǥ�� �̿Ϸ�)
	public void showProduct() {
		Iterator<Product> itr = ProductList.a.iterator();
		if (ProductList.a.size() == 0) {
			System.out.println("��ǰ ����");
			return;
		}
		while (itr.hasNext()) {
			Product product = itr.next();
			System.out.println(product.getName() + " = " + product.getPrice());
		}
	}

	// ��ǰ ���� (iterator ����)
	public void removeProduct(String name) {
		Iterator<Product> itr = ProductList.a.iterator();
		while (itr.hasNext()) {
			Product product = itr.next();
			if (product.getName().equals(name)) {
				itr.remove();
				return;
			}
		}
		System.out.println("��ǰ�� �������� �ʽ��ϴ�.");
	}

	// ���� �˸�
	public void noticePrice(String name) {
		Iterator<Product> itr = ProductList.a.iterator();
		while (itr.hasNext()) {
			Product product = itr.next();
			if (product.getName().equals(name)) {
				System.out.println(product.getName() + "�� ������ " + product.getPrice() + "�� �Դϴ�.");
				return;
			}
		}
	}

}
