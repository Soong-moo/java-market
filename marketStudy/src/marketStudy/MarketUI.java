package marketStudy;

import java.util.Scanner;

public class MarketUI {

	boolean isExecuting = true;

	Scanner sc = new Scanner(System.in);
	ProductManagement p = new ProductManagement();
	ProductFile pf = new ProductFile();

	// 코드 정렬 (Ctrl + shift + f)
	public void start() throws Exception {

		// DB 연결
		DB.SqlTest.main(null);

		// 조회를 제외한 나머지 메소드 실행을 위해 switch문 밖으로
		pf.fileOutput();

		while (isExecuting) {

			System.out.printf("----------\n" + "1. 물건 조회\n" + "2. 물건 등록\n" + "3. 물건 삭제\n" + "4. 가격 찾기\n" + "5. 물건 수정\n"
					+ "6. 종료\n" + "----------\n");
			System.out.print("입력 : ");
			int num = sc.nextInt();

			sc.nextLine(); // buffer 비움

			switch (num) {

			case 1: {
				System.out.println("물건 조회");
				p.showProduct();
				break;
			}
			case 2: {
				System.out.println("물건 등록");
				System.out.print("물건명 : ");
				String name = sc.nextLine();
				System.out.print("물건 가격 : ");
				int price = sc.nextInt();
				// next()는 space 전까지, nextLine()은 줄넘김 전까지
				p.addProduct(name, price);
				break;
			}
			case 3: {
				System.out.println("물건 삭제");
				System.out.print("삭제할 물건 입력 : ");
				String n = sc.nextLine();
				p.removeProduct(n);
				break;
			}
			case 4: {
				System.out.println("가격 조회");
				System.out.print("상품 입력 : ");
				String n = sc.nextLine();
				p.noticePrice(n);
				break;
			}
			case 5: {
				System.out.println("물건 수정");
				System.out.print("물건 입력 : ");
				String n = sc.nextLine();
				p.reviseProduct(n);
				break;

			}
			case 6: {
				System.out.println("종료");
				pf.exitUI();
				DB.SqlTest.con.close();
				DB.SqlTest.rs.close();
				DB.SqlTest.st.close();
				System.exit(0);

			}
			default: {
				continue;
			}
			}
		}
	}
}
