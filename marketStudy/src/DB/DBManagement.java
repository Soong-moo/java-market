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

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean compare(String name) {
		try {
			String cmd = "SELECT * FROM PRODUCT WHERE name = '" + name + "'";
			
			sql.st = sql.con.createStatement();
			sql.rs = sql.st.executeQuery(cmd);
			if(sql.rs.next()) { // 입력한 상품과 동일한 상품이 존재하면 next() true 반환
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean add(String name, int price) {
		try {
			String cmd = "INSERT INTO PRODUCT (name, price)" + "VALUES ('" + name + "', '" + price + "')";
			
			sql.st = sql.con.createStatement();
			int result = sql.st.executeUpdate(cmd);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public int delete(String name) {
		int result = 0;
		try {
			String cmd = "DELETE FROM PRODUCT WHERE NAME = '" + name + "'";

			sql.st = sql.con.createStatement();
			result = sql.st.executeUpdate(cmd);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int update(String name, String newName, int newPrice) {
		int result = 0;
		try {

			String cmd = "UPDATE PRODUCT SET name = '" + newName + "', price = '" + newPrice + "' WHERE name = '" + name + "'";

			sql.pst = sql.con.prepareStatement(cmd);
			result = sql.pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int findPrice(String name) {
		int price = 0;
		try {
			String cmd = "SELECT PRICE FROM PRODUCT WHERE NAME = '" + name + "'";

			sql.st = sql.con.createStatement();
			sql.rs = sql.st.executeQuery(cmd);

			sql.rs.next(); // 행 선택
			price = sql.rs.getInt("price");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return price;
	}
}
