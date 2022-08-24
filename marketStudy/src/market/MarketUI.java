package market;

import java.util.Scanner;

public class MarketUI {

	Scanner sc = new Scanner(System.in);
	Product p = new Product();
	
	public void start() {
			while (true) {

			System.out.print("�Է� : ");
			int num = sc.nextInt();

			switch (num) {

			case 1: {
				System.out.println("���� ��ȸ");
				p.showProduct();
				break;
			}
			case 2: {
			
				System.out.println("���� ���");
				System.out.print("���Ǹ� ");
				System.out.print("���� ���� ");
				//p.setProduct(sc.next(), sc.nextInt());
				p.addProduct(sc.next(), sc.nextInt());
				break;
			}
			case 3: {
				System.out.println("���� ����");
				System.out.print("������ ���� �Է� : ");
				String n = sc.next();
				p.removeProduct(n);
				break;
			}
			case 4: {
				p.showProduct();
				System.out.println("��ǰ �Է� : ");
				String n = sc.next();
				p.noticePrice(n);
				break;
			}
			case 5: {
				System.out.println("����");
				System.exit(0);
				
			}
			default: {
				continue;
			}
			}
		}
	}
}
