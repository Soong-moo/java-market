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

	// 상품 추가
	public void addProduct(String name, int price) {
//		Product product = p.compareName(name);
//		if (product != null) {
//			System.out.println(name + "은(는) 이미 있는 상품입니다.");
//			return;
//		}
		if (!p.isCheckingPrice(price)) {
			System.out.println("가격은 음수가 될 수 없습니다.");
			return;
		}
//		Product pro = new Product(name, price);
//		pf.fileInput(name, price);
//		productList.add(pro);
		sql.add(name, price); //DB에 데이터 저장
	}

	// 상품 조회
	public void showProduct() {
		sql.show(); // DB 데이터 목록 출력
//		if (productList.size() == 0) {
//			System.out.println("상품 없음");
//			return;
//		}
//		Iterator<Product> itr = productList.iterator();
//		while (itr.hasNext()) {
//			Product product = itr.next();
//			System.out.printf("%s %d\n", product.getName(), product.getPrice());
//		}
	}

	// 상품 제거
	public void removeProduct(String name) {
//		Iterator<Product> itr = productList.iterator();
//		while (itr.hasNext()) {
//			Product product = itr.next();
//			if (product.getName().equals(name)) {
//				itr.remove(); // remove() 대체 방법 찾지 못함
//				return;
//			}
//		}
		sql.delete(name);
	}

	// 물건 수정
	public void reviseProduct(String name) {
		Product product = p.compareName(name);
		if (product != null) {
			System.out.print("상품명 재입력 : ");
			String newName = sc.nextLine();
			System.out.print("상품 가격 재입력 : ");
			int newPrice = sc.nextInt();
			product.setName(newName);
			product.setPrice(newPrice);
			return;
		} else {
			System.out.println("상품이 존재하지 않습니다.");
		}
	}

	// 가격 알림
	public void noticePrice(String name) {
		Product product = p.compareName(name);
		System.out.println(product.getName() + "의 가격은 " + product.getPrice() + "원 입니다");
	}
}
