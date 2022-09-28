package marketStudy;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import DB.*;

public class ProductManagement {

	//public ArrayList<Product> productList = new ArrayList<Product>();
	Scanner sc = new Scanner(System.in);
	Product p = new Product();
	DBManagement sql = new DBManagement();
	SqlTest st = new SqlTest();

	// ��ǰ �߰�
	public void addProduct(String name, int price) {
		if (!p.isCheckingPrice(price)) {
			System.out.println("������ ������ �� �� �����ϴ�.");
			return;
		}
		if(!p.compare(name)) {
			System.out.println("������ ��ǰ�� �����մϴ�.");
			return; // false�ϸ� return���� ����
		}
		else {
			System.out.println("��ǰ �߰� �Ϸ�");
		}
	}

	// ��ǰ ��ȸ
	public void showProduct() throws SQLException {
		sql.show(); // DB ������ ��� ���
		while(st.rs.next()) {
			String name = st.rs.getString("name");
			int price = st.rs.getInt("price");
			System.out.printf("name : %s, price : %d\n", name, price);
		}
	}

	// ��ǰ ����
	public void removeProduct(String name) {
		int result = sql.delete(name);
		if(result == 1) {
			System.out.println("����");
		} else {
			System.out.println("����");
		}
	}

	// ���� ����
	public void reviseProduct(String name) {
		System.out.print("��ǰ�� ���Է� : ");
		String newName = sc.nextLine();
		System.out.print("��ǰ ���� ���Է� : ");
		int newPrice = sc.nextInt();
		
		sc.nextLine(); // buffer ���

		int result = sql.update(name, newName, newPrice);
		if(result == 1) {
			System.out.println("����");
		} else {
			System.out.println("����");
		}
	}

	// ���� �˸�
	public void noticePrice(String name) {
		int price = sql.findPrice(name);
		if(price > 0) {
			System.out.println(name + "�� ������ " + price + "�� �Դϴ�.");
		} else {
			System.out.println("�ش� ��ǰ�� �������� �ʽ��ϴ�.");
		}
	}
}
