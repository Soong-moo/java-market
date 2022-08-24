package market;

import java.util.Scanner;

public class MarketUI {

	Scanner sc = new Scanner(System.in);
	Product p = new Product();
	
	public void start() {
			while (true) {

			System.out.print("입력 : ");
			int num = sc.nextInt();

			switch (num) {

			case 1: {
				System.out.println("물건 조회");
				p.showProduct();
				break;
			}
			case 2: {
			
				System.out.println("물건 등록");
				System.out.print("물건명 ");
				System.out.print("물건 가격 ");
				//p.setProduct(sc.next(), sc.nextInt());
				p.addProduct(sc.next(), sc.nextInt());
				break;
			}
			case 3: {
				System.out.println("물건 삭제");
				System.out.print("삭제할 물건 입력 : ");
				String n = sc.next();
				p.removeProduct(n);
				break;
			}
			case 4: {
				p.showProduct();
				System.out.println("상품 입력 : ");
				String n = sc.next();
				p.noticePrice(n);
				break;
			}
			case 5: {
				System.out.println("종료");
				System.exit(0);
				
			}
			default: {
				continue;
			}
			}
		}
	}
}
