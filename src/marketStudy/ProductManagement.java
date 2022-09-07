package marketStudy;

import java.util.Iterator;

public class ProductManagement {

	ProductList pro = new ProductList();

	// 상품 추가 (1 parameter test)
	public void addProduct(String name) {
		System.out.println(name);
	}

	//상품 추가
	public void addProduct(String name, int price) {
		Iterator<Product> itr = pro.a.iterator();
		while (itr.hasNext()) {
			Product product = itr.next();
			if (product.getName().equals(name)) {
				System.out.println(name + "은(는) 이미 있는 상품입니다.");
				return;
			}
			if (!product.checkPrice(price)) {
				System.out.println("가격은 음수가 될 수 없습니다.");
				return;
			}
		}

		/*
		 * if (price < 0) { System.out.println("가격은 음수가 될 수 없습니다."); return; }
		 */
		Product p = new Product(name, price);
		pro.a.add(p);
	}

	// 상품 조회
	public void showProduct() {
		if (pro.a.size() == 0) {
			System.out.println("상품 없음");
			return;
		}
		Iterator<Product> itr = pro.a.iterator();
		while (itr.hasNext()) {
			Product product = itr.next();
			System.out.printf("%s  %d\n", product.getName(),product.getPrice());
			}
	}

	// 상품 제거
	public void removeProduct(String name) {
		Iterator<Product> itr = pro.a.iterator();
		while (itr.hasNext()) {
			Product product = itr.next();
			if (product.getName().equals(name)) {
				itr.remove();
				return;
			}
		}
		System.out.println("상품이 존재하지 않습니다.");
	}

	// 가격 알림
	public void noticePrice(String name) {
		Iterator<Product> itr = pro.a.iterator();
		while (itr.hasNext()) {
			Product product = itr.next();
			if (product.getName().equals(name)) {
				System.out.println(product.getName() + "의 가격은 " + product.getPrice() + "원 입니다.");
				return;
			}
		}

	}
}
