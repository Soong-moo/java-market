package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class SqlTest {

	public static Connection con = null;
	public static Statement st = null;
	public static ResultSet rs = null;
	public static PreparedStatement pst = null;

	public static void main(String[] args) {
		// Connection ��ü�� �ڵ��ϼ����� import�� ���� com.mysql.connection�� �ƴ�
		// java ǥ���� java.sql.Connection Ŭ������ import�ؾ� �Ѵ�.

		try {
			// 1. ����̹� �ε�
			// ����̹� �������̽��� ������ Ŭ������ �ε�
			// mysql, oracle �� �� ������ ���� Ŭ���� �̸��� �ٸ���.
			// mysql�� "com.mysql.jdbc.Driver"�̸�, �̴� �ܿ�� ���� �ƴ϶� ���۸��ϸ� �ȴ�.
			// ����� ������ �����ߴ� jar ������ ���� com.mysql.jdbc ��Ű���� Driver ��� Ŭ������ �ִ�.
			Class.forName("com.mysql.jdbc.Driver");

			// 2. �����ϱ�
			// ����̹� �Ŵ������� Connection ��ü�� �޶�� ��û�Ѵ�.
			// Connection�� ��� ���� �ʿ��� url ����, �����縶�� �ٸ���.
			// mysql�� "jdbc:mysql://localhost/�����db�̸�" �̴�.
			String url = "jdbc:mysql://localhost/products";

			// @param getConnection(url, userName, password);
			// @return Connection
			con = DriverManager.getConnection(url, "test", "test");
			System.out.println("���� ����");

		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println("����: " + e);
		}
	}

}
