package DB;

import java.sql.SQLException;
import java.util.Scanner;

public class DBManagement {

	SqlTest sql = new SqlTest();
	Scanner sc = new Scanner(System.in);

	public void show() {
		try {
			String cmd = "SELECT * FROM PRODUCT ORDER BY PRICE ASC";

			sql.st = sql.con.createStatement();
			sql.rs = sql.st.executeQuery(cmd);

			while (sql.rs.next()) {
				String name = sql.rs.getString("name");
				int price = sql.rs.getInt("price");
				System.out.printf("name : %s, price : %d\n", name, price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void add(String name, int price) {
		try {
			String cmd = "INSERT INTO PRODUCT (name, price)" + "VALUES ('" + name + "', '" + price + "')";

			sql.st = sql.con.createStatement();
			int result = sql.st.executeUpdate(cmd);

			System.out.println(result + "���� ���������� �߰��Ǿ����ϴ�.");
		} catch (SQLException e) {
			System.out.println(name + "��(��) ���� ��ǰ�� �ֽ��ϴ�.");
			// e.printStackTrace();
			return;
		}
	}

	public void delete(String name) {
		try {
			String cmd = "DELETE FROM PRODUCT WHERE NAME = '" + name + "'";

			sql.st = sql.con.createStatement();
			int result = sql.st.executeUpdate(cmd);

			System.out.println(result + "���� ���������� �����Ǿ����ϴ�.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(String name) {
		try {
			System.out.print("��ǰ�� ���Է� : ");
			String newName = sc.nextLine();
			System.out.print("��ǰ ���� ���Է� : ");
			int newPrice = sc.nextInt();
			
			sc.nextLine(); // buffer ���

			String cmd = "UPDATE PRODUCT SET name = '" + newName + "', price = '" + newPrice + "' WHERE name = '" + name
					+ "'";

			sql.pst = sql.con.prepareStatement(cmd);
			int result = sql.pst.executeUpdate();

			System.out.println(result + "���� ���������� �����Ǿ����ϴ�.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void findPrice(String name) {
		try {
			String cmd = "SELECT PRICE FROM PRODUCT WHERE NAME = '" + name + "'";

			sql.st = sql.con.createStatement();
			sql.rs = sql.st.executeQuery(cmd);

			sql.rs.next(); // �� ����

			int price = sql.rs.getInt("price");
			System.out.println(name + "�� ������ " + price + "�� �Դϴ�.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
