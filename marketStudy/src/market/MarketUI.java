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
				System.out.println(p.test);
				break;
			}
			case 2: {
			
				System.out.println("���� ���");
				System.out.print("���Ǹ� ");
				System.out.print("���� ���� ");
				p.setProduct(sc.next(), sc.nextInt());
				
				break;
			}
			case 3: {
				System.out.println("���� ����");
				System.out.print("������ ���� �Է� : ");
				p.test.remove(sc.next());
				break;
			}
			case 4: {
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
