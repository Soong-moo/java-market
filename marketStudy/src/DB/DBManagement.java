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

			System.out.println(result + "개가 성공적으로 추가되었습니다.");
		} catch (SQLException e) {
			System.out.println(name + "와(과) 같은 상품이 있습니다.");
			// e.printStackTrace();
			return;
		}
	}

	public void delete(String name) {
		try {
			String cmd = "DELETE FROM PRODUCT WHERE NAME = '" + name + "'";

			sql.st = sql.con.createStatement();
			int result = sql.st.executeUpdate(cmd);

			System.out.println(result + "개가 성공적으로 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(String name) {
		try {
			System.out.print("상품명 재입력 : ");
			String newName = sc.nextLine();
			System.out.print("상품 가격 재입력 : ");
			int newPrice = sc.nextInt();
			
			sc.nextLine(); // buffer 비움

			String cmd = "UPDATE PRODUCT SET name = '" + newName + "', price = '" + newPrice + "' WHERE name = '" + name
					+ "'";

			sql.pst = sql.con.prepareStatement(cmd);
			int result = sql.pst.executeUpdate();

			System.out.println(result + "개가 성공적으로 수정되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void findPrice(String name) {
		try {
			String cmd = "SELECT PRICE FROM PRODUCT WHERE NAME = '" + name + "'";

			sql.st = sql.con.createStatement();
			sql.rs = sql.st.executeQuery(cmd);

			sql.rs.next(); // 행 선택

			int price = sql.rs.getInt("price");
			System.out.println(name + "의 가격은 " + price + "원 입니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
