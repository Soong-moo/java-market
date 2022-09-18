package marketStudy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ProductManagement {

	public static ArrayList<Product> productList = new ArrayList<Product>();
	Scanner sc = new Scanner(System.in);
	ProductFile pf = new ProductFile();
	Product p = new Product();
	DB.DBManagement sql = new DB.DBManagement();

	// ��ǰ �߰�
	public void addProduct(String name, int price) {
//		Product product = p.compareName(name);
//		if (product != null) {
//			System.out.println(name + "��(��) �̹� �ִ� ��ǰ�Դϴ�.");
//			return;
//		}
		if (!p.isCheckingPrice(price)) {
			System.out.println("������ ������ �� �� �����ϴ�.");
			return;
		}
//		Product pro = new Product(name, price);
//		pf.fileInput(name, price);
//		productList.add(pro);
		sql.add(name, price); //DB�� ������ ����
	}

	// ��ǰ ��ȸ
	public void showProduct() {
		sql.show(); // DB ������ ��� ���
//		if (productList.size() == 0) {
//			System.out.println("��ǰ ����");
//			return;
//		}
//		Iterator<Product> itr = productList.iterator();
//		while (itr.hasNext()) {
//			Product product = itr.next();
//			System.out.printf("%s %d\n", product.getName(), product.getPrice());
//		}
	}

	// ��ǰ ����
	public void removeProduct(String name) {
//		Iterator<Product> itr = productList.iterator();
//		while (itr.hasNext()) {
//			Product product = itr.next();
//			if (product.getName().equals(name)) {
//				itr.remove(); // remove() ��ü ��� ã�� ����
//				return;
//			}
//		}
		sql.delete(name);
	}

	// ���� ����
	public void reviseProduct(String name) {
		Product product = p.compareName(name);
		if (product != null) {
			System.out.print("��ǰ�� ���Է� : ");
			String newName = sc.nextLine();
			System.out.print("��ǰ ���� ���Է� : ");
			int newPrice = sc.nextInt();
			product.setName(newName);
			product.setPrice(newPrice);
			return;
		} else {
			System.out.println("��ǰ�� �������� �ʽ��ϴ�.");
		}
	}

	// ���� �˸�
	public void noticePrice(String name) {
		Product product = p.compareName(name);
		System.out.println(product.getName() + "�� ������ " + product.getPrice() + "�� �Դϴ�");
	}
}
