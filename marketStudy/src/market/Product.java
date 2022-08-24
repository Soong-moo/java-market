package market;

//import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

public class Product {

	private String name;
	private int price;
	
	public ArrayList<Product> a = new ArrayList<Product>();
	
	//public static HashMap<String, Integer> test = new HashMap<String, Integer>();
	
	//public void setProduct(String name, int price) {
	//	test.put(name, price);
	//}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	//상품 추가
	public void addProduct(String name, int price) {
		Iterator<Product> itr = a.iterator();
		while(itr.hasNext()) {
			Product product = itr.next();
				if(product.getName().equals(name)) {
					System.out.println("이미 있는 상품입니다.");
					return;
				}
		}
		Product p = new Product();
		p.setName(name);
		p.setPrice(price);
		a.add(p);
	}
	
	//상품 조회 (경고 표시 미완료)
	public void showProduct() {
		Iterator<Product> itr = a.iterator();
		while(itr.hasNext()) {
			Product product = itr.next();
			System.out.println(product.getName() + " = " + product.getPrice());
		}
	}
	
	//상품 제거 (iterator 정리)
	public void removeProduct(String name) {
		Iterator<Product> itr = a.iterator();
		while(itr.hasNext()) {
			Product product = itr.next();
				if(product.getName().equals(name)) {
					itr.remove();
					return;
				}
		}
		System.out.println("상품이 존재하지 않습니다.");
	}
	
	//가격 알림
	public void noticePrice(String name) {
		Iterator<Product> itr = a.iterator();
		while(itr.hasNext()) {
			Product product = itr.next();
				if(product.getName().equals(name)) {
					System.out.println(product.getName() + "의 가격은 " + product.getPrice() + "원 입니다.");
					return;
				}
		}
	}
	
	
	
}
