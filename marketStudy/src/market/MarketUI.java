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
				System.out.println(p.test);
				break;
			}
			case 2: {
			
				System.out.println("물건 등록");
				System.out.print("물건명 ");
				System.out.print("물건 가격 ");
				p.setProduct(sc.next(), sc.nextInt());
				
				break;
			}
			case 3: {
				System.out.println("물건 삭제");
				System.out.print("삭제할 물건 입력 : ");
				p.test.remove(sc.next());
				break;
			}
			case 4: {
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
