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

	// 상품 추가
	public void addProduct(String name, int price) {
		if (!p.isCheckingPrice(price)) {
			System.out.println("가격은 음수가 될 수 없습니다.");
			return;
		}
		if(!p.compare(name)) {
			System.out.println("동일한 상품이 존재합니다.");
			return; // false하면 return으로 종료
		}
		else {
			System.out.println("상품 추가 완료");
		}
	}

	// 상품 조회
	public void showProduct() throws SQLException {
		sql.show(); // DB 데이터 목록 출력
		while(st.rs.next()) {
			String name = st.rs.getString("name");
			int price = st.rs.getInt("price");
			System.out.printf("name : %s, price : %d\n", name, price);
		}
	}

	// 상품 제거
	public void removeProduct(String name) {
		int result = sql.delete(name);
		if(result == 1) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
	}

	// 물건 수정
	public void reviseProduct(String name) {
		System.out.print("상품명 재입력 : ");
		String newName = sc.nextLine();
		System.out.print("상품 가격 재입력 : ");
		int newPrice = sc.nextInt();
		
		sc.nextLine(); // buffer 비움

		int result = sql.update(name, newName, newPrice);
		if(result == 1) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
	}

	// 가격 알림
	public void noticePrice(String name) {
		int price = sql.findPrice(name);
		if(price > 0) {
			System.out.println(name + "의 가격은 " + price + "원 입니다.");
		} else {
			System.out.println("해당 상품은 존재하지 않습니다.");
		}
	}
}
