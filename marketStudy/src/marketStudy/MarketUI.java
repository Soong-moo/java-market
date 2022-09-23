package marketStudy;

import java.util.Scanner;

public class MarketUI {

	boolean isExecuting = true;

	Scanner sc = new Scanner(System.in);
	ProductManagement p = new ProductManagement();
	ProductFile pf = new ProductFile();

	// �ڵ� ���� (Ctrl + shift + f)
	public void start() throws Exception {

		// DB ����
		DB.SqlTest.main(null);

		// ��ȸ�� ������ ������ �޼ҵ� ������ ���� switch�� ������
		pf.fileOutput();

		while (isExecuting) {

			System.out.printf("----------\n" + "1. ���� ��ȸ\n" + "2. ���� ���\n" + "3. ���� ����\n" + "4. ���� ã��\n" + "5. ���� ����\n"
					+ "6. ����\n" + "----------\n");
			System.out.print("�Է� : ");
			int num = sc.nextInt();

			sc.nextLine(); // buffer ���

			switch (num) {

			case 1: {
				System.out.println("���� ��ȸ");
				p.showProduct();
				break;
			}
			case 2: {
				System.out.println("���� ���");
				System.out.print("���Ǹ� : ");
				String name = sc.nextLine();
				System.out.print("���� ���� : ");
				int price = sc.nextInt();
				// next()�� space ������, nextLine()�� �ٳѱ� ������
				p.addProduct(name, price);
				break;
			}
			case 3: {
				System.out.println("���� ����");
				System.out.print("������ ���� �Է� : ");
				String n = sc.nextLine();
				p.removeProduct(n);
				break;
			}
			case 4: {
				System.out.println("���� ��ȸ");
				System.out.print("��ǰ �Է� : ");
				String n = sc.nextLine();
				p.noticePrice(n);
				break;
			}
			case 5: {
				System.out.println("���� ����");
				System.out.print("���� �Է� : ");
				String n = sc.nextLine();
				p.reviseProduct(n);
				break;

			}
			case 6: {
				System.out.println("����");
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
