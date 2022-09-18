package marketStudy;

import java.io.*;
import java.util.Iterator;
import java.util.StringTokenizer;

public class ProductFile {

	File file = new File("products.txt");

	// txt file�� ������ ����
	public void fileInput(String name, int price) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
			bw.write(name + "/" + String.valueOf(price));
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// txt file ������ ArrayList�� ����
	public void fileOutput() {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String txt = null;
			while ((txt = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(txt, "/");
				String name = st.nextToken();
				int price = Integer.parseInt(st.nextToken());
				Product p = new Product(name, price);
				ProductManagement.productList.add(p);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//���� �� ������ �ʱ�ȭ �� ArrayList�� �ִ� ������ ����
	public void exitUI() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, false))) {
			Iterator<Product> itr = ProductManagement.productList.iterator();
			while (itr.hasNext()) {
				Product product = itr.next();
				bw.write(product.getName() + "/" + String.valueOf(product.getPrice()));
				bw.newLine();
			}

			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
