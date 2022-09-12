package marketStudy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ProductManagement {
	
	public static ArrayList<Product> productList = new ArrayList<Product>();
	Scanner sc = new Scanner(System.in);
	ProductFile pf = new ProductFile();
	
	
	// ��ǰ �߰� (1 parameter test)
	public void addProduct(String name) {
		System.out.println(name);
	}

	// ��ǰ �߰�
	public void addProduct(String name, int price) {
		Iterator<Product> itr = productList.iterator();
		while (itr.hasNext()) {
			Product product = itr.next();
			if (product.getName().equals(name)) {
				System.out.println(name + "��(��) �̹� �ִ� ��ǰ�Դϴ�.");
				return;
			}
			if (!product.isCheckingPrice(price)) {
				System.out.println("������ ������ �� �� �����ϴ�.");
				return;
			}
		}
		Product p = new Product(name, price);
		pf.fileInput(name,price);
		productList.add(p);
	}

	// ��ǰ ��ȸ
	public void showProduct() {
		if (productList.size() == 0) {
			System.out.println("��ǰ ����");
			return;
		}
		Iterator<Product> itr = productList.iterator();
		while (itr.hasNext()) {
			Product product = itr.next();
			System.out.printf("%s %d\n", product.getName(), product.getPrice());
		}
	}

	// ��ǰ ����
	public void removeProduct(String name) {
		Iterator<Product> itr = productList.iterator();
		while (itr.hasNext()) {
			Product product = itr.next();
			if (product.getName().equals(name)) {
				itr.remove();
				return;
			}
		}
		System.out.println("��ǰ�� �������� �ʽ��ϴ�.");
	}

	// ���� ����
	public void reviseProduct(String name) {
		Iterator<Product> itr = productList.iterator();
		while (itr.hasNext()) {
			Product product = itr.next();
			if (product.getName().equals(name)) {
				System.out.print("��ǰ�� ���Է� : ");
				String newName = sc.nextLine();
				System.out.print("��ǰ ���� ���Է� : ");
				int newPrice = sc.nextInt();
				product.setName(newName);
				product.setPrice(newPrice);
				return;
			}
		}
		System.out.println("��ǰ�� �������� �ʽ��ϴ�.");
	}

	// ���� �˸�
	public void noticePrice(String name) {
		Iterator<Product> itr = productList.iterator();
		while (itr.hasNext()) {
			Product product = itr.next();
			if (product.getName().equals(name)) {
				System.out.println(product.getName() + "�� ������ " + product.getPrice() + "�� �Դϴ�.");
				return;
			}
		}
	}

}
