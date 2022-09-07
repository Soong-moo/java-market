package marketStudy;

import java.util.Iterator;

public class ProductManagement {

	ProductList pro = new ProductList();

	// ��ǰ �߰� (1 parameter test)
	public void addProduct(String name) {
		System.out.println(name);
	}

	//��ǰ �߰�
	public void addProduct(String name, int price) {
		Iterator<Product> itr = pro.a.iterator();
		while (itr.hasNext()) {
			Product product = itr.next();
			if (product.getName().equals(name)) {
				System.out.println(name + "��(��) �̹� �ִ� ��ǰ�Դϴ�.");
				return;
			}
			if (!product.checkPrice(price)) {
				System.out.println("������ ������ �� �� �����ϴ�.");
				return;
			}
		}

		/*
		 * if (price < 0) { System.out.println("������ ������ �� �� �����ϴ�."); return; }
		 */
		Product p = new Product(name, price);
		pro.a.add(p);
	}

	// ��ǰ ��ȸ
	public void showProduct() {
		if (pro.a.size() == 0) {
			System.out.println("��ǰ ����");
			return;
		}
		Iterator<Product> itr = pro.a.iterator();
		while (itr.hasNext()) {
			Product product = itr.next();
			System.out.printf("%s  %d\n", product.getName(),product.getPrice());
			}
	}

	// ��ǰ ����
	public void removeProduct(String name) {
		Iterator<Product> itr = pro.a.iterator();
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
		Iterator<Product> itr = pro.a.iterator();
		while (itr.hasNext()) {
			Product product = itr.next();
			if (product.getName().equals(name)) {
				System.out.println(product.getName() + "�� ������ " + product.getPrice() + "�� �Դϴ�.");
				return;
			}
		}

	}
}
