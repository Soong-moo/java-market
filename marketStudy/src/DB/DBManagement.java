package DB;

import java.sql.SQLException;

public class DBManagement {

	SqlTest sql = new SqlTest();

	public void show() {
		try {
			String cmd = "select * from product";

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
			String cmd = "DELETE FROM PRODUCT WHERE NAME = '"+ name + "'";
			
			sql.st = sql.con.createStatement();
			int result = sql.st.executeUpdate(cmd);
			
			System.out.println(result + "���� ���������� �����Ǿ����ϴ�.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
